package br.unb.cic.sa.model;

public class Type {
	
	private String file;
	private String name;
	private int startLine;
	private int endLine;
	
	public Type(){
		
	}
	public Type(String file, String name, int startLine, int endLine){
		this.file = file;
		this.name = name;
		this.startLine = startLine;
		this.endLine = endLine;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}