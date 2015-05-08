package br.unb.cic.sa;

import java.io.File;
import java.util.concurrent.Callable;

import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.util.IO;
import br.unb.cic.sa.visitors.MethodDeclarationVisitor;
import br.unb.cic.sa.visitors.TryStatementVisitor;

public class ProjectAnalyser implements Callable<CollectedData> {

	private Project project;
	
	public ProjectAnalyser(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return this.project;
	}

	public CollectedData call() throws Exception {
		
		CompilationUnit compilationUnit = null;
		CollectedData collectionProject = new CollectedData(project.getProjectName(),
				project.getProjectRevision(), this.project.getFilePath());

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
				collectionProject.addError(e.getMessage() + " parsing file "+ file);
				continue;
			}
			

			// Visitors
			TryStatementVisitor tsVisitor = new TryStatementVisitor(compilationUnit, file, collectionProject);
			MethodDeclarationVisitor mdVisitor = new MethodDeclarationVisitor(compilationUnit, file, collectionProject);
			
			
			//Add visitors to search them statements in parser of each project file
			compilationUnit.accept(tsVisitor);
			compilationUnit.accept(mdVisitor);
			
			//Add name each file name in collecation
			collectionProject.addNameFile(file);
			
	

		}
		
		return collectionProject;
	}
	

}
