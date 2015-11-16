package br.unb.cic.sa.model;

/**
 * This class maintains relevant information about 
 * the opportunities for using Lambda Expressions.  
 * 
 * @author Thiago Cavalcanti / Vinicius Correa
 */
public class LambdaExpOpportunities {

	private String file;
	private int startLine;
	private int endLine;
	private int statements = 0;
	
	//	private boolean filter;
//	private boolean map;
//	private boolean hasThrow;
//	private boolean hasExternalReference;
//	private boolean hasBreak;
//	private boolean hasReturn;
//	private boolean hasContinue;
//	

	public LambdaExpOpportunities(String file, int startLine, int endLine) {
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

	public int getStatements() {
		return statements;
	}

	public void setStatements(int statements) {
		this.statements = statements;
	}

	
	
	
}
