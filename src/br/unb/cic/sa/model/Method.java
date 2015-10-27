package br.unb.cic.sa.model;

public class Method extends AbsStatementModel{
	
	
	public Method(String file, String name, int startLine, int endLine){
		this.setName(name);
		this.setFile(file);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
	}


}
