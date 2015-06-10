package br.unb.cic.sa.model;

import org.eclipse.jdt.core.dom.Type;

public class Variable {
	
	private String file;
	private String name;
	private Type type;
	
	public Variable(){
		
	}
	public Variable(String file, String name, Type type){
		this.file = file;
		this.name = name;
		this.type = type;
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
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type){
		this.type = type;
	}

//	public int getStartLine() {
//		return startLine;
//	}
//
//	public void setStartLine(int startLine) {
//		this.startLine = startLine;
//	}
//
//	public int getEndLine() {
//		return endLine;
//	}
//
//	public void setEndLine(int endLine) {
//		this.endLine = endLine;
//	}

}