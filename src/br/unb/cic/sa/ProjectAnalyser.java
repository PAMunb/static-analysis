package br.unb.cic.sa;

import java.io.File;
import java.util.concurrent.Callable;

import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.statements.TryStatementVisitor;
import br.unb.cic.sa.util.IO;

public class ProjectAnalyser implements Callable<CollectedData> {

	private Project project;
	private CollectedData collectionProject;
	private CompilationUnit compilationUnit;
	
	public ProjectAnalyser(Project project) {
		this.project = project;
		this.collectionProject = new CollectedData(project.getProjectName(),
				project.getProjectRevision(), this.project.getFilePath());
		this.compilationUnit = null;
	}

	public Project getProject() {
		return this.project;
	}

	public CollectedData call() throws Exception {

		for (String file : IO.listFiles(project.getFilePath(),
				new String[] { "java" })) {
			try {
				// fazer um parser de cada arquivo.java encontrado no projeto
				compilationUnit = Parser.Instance().parse(new File(file));
				if (compilationUnit == null) {
					collectionProject.addError("Error parsing file " + file);
					continue;
				}

			} catch (Throwable e) {
				collectionProject.addError(e.getMessage() + " parsing file "
						+ file);
				continue;
			}
			
			

			// Visitor of TryStatement
			TryStatementVisitor ts = new TryStatementVisitor(file);
			
			compilationUnit.accept(ts);
			
			//Add name each file name in collecation
			collectionProject.addNameFile(file);
			
			//Add name each CompilationUnit of file in collecation
			collectionProject.addCompilationUnit(compilationUnit);
			
			collectionProject.addTryStatementBlock(ts.getCollectedData().getTryStatement());
		}
		
		return collectionProject;
	}
	
	
	public CompilationUnit getCompilationUnit(){
		return compilationUnit;
	}



}
