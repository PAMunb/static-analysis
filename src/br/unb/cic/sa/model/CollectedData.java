package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TryStatement;

public class CollectedData {

	private Project project;
	private int numberOfStatements;
	private List<String> analysisError;
	private List<TryStatement> tryStatementData;
	private List<CompilationUnit> compilationUnit;
	private List<String> nameFile;

	public CollectedData() {
		analysisError = new ArrayList<String>();
		tryStatementData = new ArrayList<TryStatement>();
		compilationUnit = new ArrayList<CompilationUnit>();
		nameFile = new ArrayList<String>();
		numberOfStatements = 0;
	}

	public CollectedData(String projectName, String projectRevision,
			String filePath) {
		this();// call the default construct
		this.project = new Project(projectName, projectRevision, filePath);
	}

	public void addNameFile(String nameFile) {
		this.nameFile.add(nameFile);
	}

	public String getNameFile(int position) {
		return this.nameFile.get(position);
	}

	public void addCompilationUnit(CompilationUnit compilationUnit) {
		this.compilationUnit.add(compilationUnit);
	}

	public CompilationUnit getCompilationUnit(int position) {
		return this.compilationUnit.get(position);
	}
	
	public Project getProject() {
		return project;
	}


	public void addTryStatementBlock(List<TryStatement> tryStatements) {
		this.tryStatementData.addAll(tryStatements);
	}

	public void addTryStatement(TryStatement t) {
		this.tryStatementData.add(t);
		numberOfStatements++;
	}

	public List<TryStatement> getTryStatement() {
		return this.tryStatementData;
	}

	public void addStatements(int statements) {
		numberOfStatements += statements;
	}

	public int getNumberOfStatements() {
		return numberOfStatements;
	}

	public void addError(String e) {
		analysisError.add(e);
	}

	public List<String> getError() {
		return analysisError;
	}
}
