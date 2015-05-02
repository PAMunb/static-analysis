package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.sa.statements.MDCollected;
import br.unb.cic.sa.statements.TSCollected;

public class CollectedData {

	private Project project;
	private int numberOfStatements;
	private int numberOfTryStatements;
	private int numberOfMethodDeclaration;
	private List<String> analysisError;
	private List<TSCollected> tryStatementCollectedData;
	private List<MDCollected> methodDeclarationCollectedData;
	private List<String> nameFile;

	public CollectedData() {
		this.analysisError = new ArrayList<String>();
		this.tryStatementCollectedData = new ArrayList<TSCollected>();
		this.methodDeclarationCollectedData = new ArrayList<MDCollected>();
		this.nameFile = new ArrayList<String>();
		this.numberOfStatements = 0;
		this.numberOfTryStatements = 0;
		this.numberOfMethodDeclaration = 0;
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


	public Project getProject() {
		return project;
	}


	public void addTryStatementBlock(TSCollected tryStatementCollectedData) {
		this.tryStatementCollectedData.add(tryStatementCollectedData);
		//increment number of statemens
		this.incrementStatements(tryStatementCollectedData.getListTrystatement().size());
		//incremente number of trystatement
		this.incrementTryStatements(tryStatementCollectedData.getListTrystatement().size());
	}
	
	
	public void addMethodDeclarationBlock(MDCollected mdCollectedData){
		this.methodDeclarationCollectedData.add(mdCollectedData);
		
		//increment number of statements
		this.incrementStatements(mdCollectedData.getListMethodDeclaration().size());
		
		//incremente number of methodDeclaration
		this.incrementMethodDeclaration(mdCollectedData.getListMethodDeclaration().size());
	}
	

	public List<TSCollected> getTryStatement() {
		return this.tryStatementCollectedData;
	}

	
	public List<MDCollected> getMethodDeclaration(){
		return this.methodDeclarationCollectedData;
	}
	
	
	private void incrementStatements(int statements) {
		numberOfStatements += statements;
	}

	private void incrementTryStatements(int statements){
		this.numberOfTryStatements += statements;
	}
	
	private void incrementMethodDeclaration(int statements){
		this.numberOfMethodDeclaration += statements;
	}
	
	
	
	public int getNumberOfStatements() {
		return this.numberOfStatements;
	}
	
	public int getNumberOfTryStatements() {
		return this.numberOfTryStatements;
	}
	
	public int getNumberOfMethodDeclaritionStatements() {
		return this.numberOfMethodDeclaration;
	}	

	public void addError(String e) {
		analysisError.add(e);
	}

	public List<String> getError() {
		return analysisError;
	}
}
