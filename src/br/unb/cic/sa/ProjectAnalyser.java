package br.unb.cic.sa;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.springframework.beans.factory.annotation.Autowired;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.util.IO;
import br.unb.cic.sa.visitors.IVisitor;

public class ProjectAnalyser implements Callable<CollectedData> {

	@Autowired
	private List<IVisitor> listVisitors;
	@Autowired
	private CollectedData collectionProject;
	
	private Project project;
	
	
	public ProjectAnalyser(){ }
	
	public void setListVisitors(List<IVisitor> listVisitors){
		this.listVisitors = listVisitors;
	}
	
	public void setProject(Project project){
		this.project = project;
	}
	
	public void setCollectionProject(CollectedData collectionProject){
		this.collectionProject = collectionProject;
	}
	
	public CollectedData call() throws Exception {
		
		this.collectionProject.setProject(project);
		
//		this.collectionProject = new CollectedData(project.getProjectName(),
//				project.getProjectRevision(), this.project.getFilePath());
				
		CompilationUnit compilationUnit = null;
	
		for (String file : IO.listFiles(project.getFilePath(),
				new String[] { "java" })) {
			try {
				// fazer um parser de cada arquivo.java encontrado no projeto
				compilationUnit = Parser.Instance().parse(new File(file));
								
				if (compilationUnit == null) {
					this.collectionProject.addError("Error parsing file " + file);
					continue;
				}

			} catch (Throwable e) {
				this.collectionProject.addError(e.getMessage() + " parsing file "+ file);
				continue;
			}
			

			
			
			for(IVisitor visitor : listVisitors){
				visitor.setColletion(collectionProject);
				visitor.setFile(file);
				visitor.setUnit(compilationUnit);
				
				compilationUnit.accept((ASTVisitor) visitor);
			}
			
			
			// Visitors
			
//			TryStatementVisitor tsVisitor = new TryStatementVisitor(compilationUnit, file, collectionProject);
//			MethodDeclarationVisitor mdVisitor = new MethodDeclarationVisitor(compilationUnit, file, collectionProject);
						
			
			//Add visitors to search them statements in parser of each project file
//			compilationUnit.accept(tsVisitor);
//			compilationUnit.accept(mdVisitor);
			
//			compilationUnit.accept(enumVisitor);
			
			//Add name each file name in collecation
			collectionProject.addNameFile(file);
			
	

		}
		
		return collectionProject;
	}
	

}
