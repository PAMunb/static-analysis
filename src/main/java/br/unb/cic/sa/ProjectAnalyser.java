package br.unb.cic.sa;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.springframework.beans.factory.annotation.Autowired;

import br.unb.cic.sa.model.Project;
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
			
			for (String file : files) {
				
				compilationUnit = Parser.Instance().parse(new File(file));
			
				for(IVisitor visitor : listVisitors){
					visitor.getCollectedData().setProject(project);
					visitor.setFile(file);
					visitor.setUnit(compilationUnit);
					
					compilationUnit.accept((ASTVisitor) visitor);
					
				}
			}
			
			exportData();
			
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
	
}
