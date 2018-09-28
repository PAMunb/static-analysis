package br.unb.cic.sa;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.springframework.beans.factory.annotation.Autowired;

import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.parser.Parser;
import br.unb.cic.sa.util.IO;
import br.unb.cic.sa.visitors.IVisitor;

public class ProjectAnalyser  {
	
	@Autowired
	private List<IVisitor> listVisitors;

	public ProjectAnalyser(){ }
	
	public void setListVisitors(List<IVisitor> listVisitors){
		this.listVisitors = listVisitors;
	}
		
	public void analyse(Project project)  {
		CompilationUnit compilationUnit = null;
		
		System.out.println(project.getProjectName());
	
		try{ 
			List<String> files = IO.listFiles(project.getFilePath(), new String[] { "java" });
			VisitorDeclaration vm = new VisitorDeclaration();
			
			for (String file : files) {
								
				compilationUnit = Parser.Instance().parse(new File(file));
			
				for(IVisitor visitor : listVisitors){
					visitor.getCollectedData().setProject(project);
					visitor.setFile(file);
					visitor.setUnit(compilationUnit);
					
					compilationUnit.accept((ASTVisitor) visitor);	
				}
				
				compilationUnit.accept(vm);
				
			}		
			exportData();
			
			System.out.println("======================================");
			System.out.println("Packages: " + vm.packages.size());
			System.out.println("Classes: " + vm.classes);
			System.out.println("Methods: " + vm.methods);
			System.out.println("======================================");
				
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
				
	}
	
	public void exportData() throws Exception {
		listVisitors.stream().forEach(visitor -> {
											visitor.getCollectedData().export();
											visitor.getCollectedData().clean();
										});
		
	}
	
	class VisitorDeclaration extends ASTVisitor {
		int classes = 0;
		int methods = 0; 
		Set<String> packages; 
		
		public VisitorDeclaration() {
			packages = new HashSet<>();
		}
		
		@Override
		public boolean visit(MethodDeclaration node) {
			methods++;
			return super.visit(node);
		}



		@Override
		public boolean visit(PackageDeclaration decl) {
			packages.add(decl.getName().getFullyQualifiedName()); 
			return super.visit(decl);
		}


		@Override
		public boolean visit(TypeDeclaration node) {
			classes++; 
			return super.visit(node);
		} 
		
		
		
		
	}
	
}
