package br.unb.cic.sa;

import java.io.File;
import java.util.concurrent.Callable;

import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.util.IO;

public class ProjectAnalyser implements Callable<CollectedData> {

	private Project project;
	private CollectedData collectionProject;
	
	public ProjectAnalyser(Project project){
		this.project = project;
		this.collectionProject = new CollectedData(project.getProjectName(), project.getProjectRevision(), this.project.getFilePath());

	}
	
	public Project getProject(){
		return this.project;
	}
	
	public CollectedData call() throws Exception {
				
		for(String file : IO.listFiles(project.getFilePath(), new String[]{"java"})){
			CompilationUnit cu;
			try{
				//fazer um parser de cada arquivo.java encontrado no projeto
				cu = Parser.Instance().parse(new File(file));
				if(cu == null){
					collectionProject.addError("Error parsing file " + file);
					continue;
				}
				
			}catch(Throwable e){
				collectionProject.addError(e.getMessage() + " parsing file " + file);
				continue;
			}

			//Visitor of TryStatement
			TryStatementVisitor ts = new TryStatementVisitor(file);
			
			cu.accept(ts);
			
			System.out.println("File "+file +" has "+ts.getCollectedData().getTryStatement().size()+" statements.");
			
			collectionProject.addTryStatementBlock(ts.getCollectedData().getTryStatement());
			collectionProject.addStatements(ts.getCollectedData().getNumberOfStatements());
		}
		
		

		
		return collectionProject;
	}
	
	
	

}
