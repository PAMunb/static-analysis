package br.unb.cic.sa.model;

public class Try extends AbsStatementModel {

	public Try(String file, int startLine, int endLine){
		this.setFile(file);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
	}
	
}
