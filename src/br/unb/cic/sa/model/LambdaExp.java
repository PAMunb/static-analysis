package br.unb.cic.sa.model;

public class LambdaExp extends AbsStatementModel{

	
	public LambdaExp(String file, int startLine, int endLine){
		this.setFile(file);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
	}
	
}
