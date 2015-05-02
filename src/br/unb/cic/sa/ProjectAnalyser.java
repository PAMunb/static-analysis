package br.unb.cic.sa;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.statements.MDCollected;
import br.unb.cic.sa.statements.TSCollected;
import br.unb.cic.sa.util.IO;
import br.unb.cic.sa.visitors.MethodDeclarationVisitor;
import br.unb.cic.sa.visitors.TryStatementVisitor;

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
				collectionProject.addError(e.getMessage() + " parsing file "+ file);
				continue;
			}
			

			// Visitors
			TryStatementVisitor tsVisitor = new TryStatementVisitor();
			MethodDeclarationVisitor mdVisitor = new MethodDeclarationVisitor();
			
			//Add visitors to search them statements in parser of each project file
			compilationUnit.accept(tsVisitor);
			compilationUnit.accept(mdVisitor);
			
			
			TSCollected tsc = new TSCollected(tsVisitor.getTSCollected(), compilationUnit);
			MDCollected mdc = new MDCollected(mdVisitor.getMDCollected(), compilationUnit);
		
			
			//Add name each file name in collecation
			collectionProject.addNameFile(file);
			
			//add tryBlocks in collection of project
			collectionProject.addTryStatementBlock(tsc);

			//add methods  in collection of project
			collectionProject.addMethodDeclarationBlock(mdc);
			
			
		}
		
		return collectionProject;
	}
	
	
	public CompilationUnit getCompilationUnit(){
		return compilationUnit;
	}



}
