package br.unb.cic.sa.model;

/**
 * This model class represents an abstraction over 
 * Try Statements. 
 * 
 * @author Thiago Cavalcanti e Vinicius Correa
 */
public class TryStatementData  {
	private String file;
	private int startLine;
	private int endLine;
	private boolean tryWithResource = false;
	private boolean multiCatch = false;
	private int numberOfCatches;
	private int numberOfStatements;
	private int numberOfCatchStatements;
	



	public TryStatementData(String file, int startLine, int endLine){
		this.file = file;
		this.startLine = startLine;
		this.endLine = endLine;
	}
	
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getStartLine() {
		return startLine;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public boolean isTryWithResource() {
		return tryWithResource;
	}

	public void setTryWithResource(boolean tryWithResource) {
		this.tryWithResource = tryWithResource;
	}


	public boolean isMultiCatch() {
		return multiCatch;
	}


	public void setMultiCatch(boolean multiCatch) {
		this.multiCatch = multiCatch;
	}
	
	public int getNumberOfCatches() {
		return numberOfCatches;
	}


	public void setNumberOfCatches(int numberOfCatches) {
		this.numberOfCatches = numberOfCatches;
	}


	public int getNumberOfStatements() {
		return numberOfStatements;
	}


	public void setNumberOfStatements(int numberOfStatements) {
		this.numberOfStatements = numberOfStatements;
	}


	public int getNumberOfCatchStatements() {
		return numberOfCatchStatements;
	}


	public void setNumberOfCatchStatements(int numberOfCatchStatements) {
		this.numberOfCatchStatements = numberOfCatchStatements;
	}
}
