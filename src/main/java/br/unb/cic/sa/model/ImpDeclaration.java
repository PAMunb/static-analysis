package br.unb.cic.sa.model;

public class ImpDeclaration {

	private String file;
	private int startLine;
	private int endLine;
	private String importDeclaration;
	
	public ImpDeclaration(String file, int startLine, int endLine){
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

	public String getImportDeclaration() {
		return importDeclaration;
	}

	public void setImportDeclaration(String importDeclaration) {
		this.importDeclaration = importDeclaration;
	}
	
	
}
