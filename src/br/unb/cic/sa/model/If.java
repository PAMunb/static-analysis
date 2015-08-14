package br.unb.cic.sa.model;

public class If extends AbsStatementModel {

	public If(String file, int startLine, int endLine) {
		this.setFile(file);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
	}
}
