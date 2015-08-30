package br.unb.cic.sa.model;

public class AnonymousClass extends AbsStatementModel {

	public AnonymousClass(String file, int startLine, int endLine) {
		this.setFile(file);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
	}

}
