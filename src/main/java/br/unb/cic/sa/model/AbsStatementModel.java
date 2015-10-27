package br.unb.cic.sa.model;

import java.util.List;

import org.eclipse.jdt.core.dom.Type;

public abstract class AbsStatementModel {

	private String file;
	private int startLine;
	private int endLine;
	private String method;
	private String name;
	private Type superClass;
	private Type type;
	private List<Type> interfaces;
	
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
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type){
		this.type = type;
	}
	
	public Type getSuperClass() {
		return superClass;
	}
	
	public void setSuperClass(Type superClass) {
		this.superClass = superClass;
	}
	
	public List<Type> getIntefaces() {
		return interfaces;
	}
	
	public void setInterfaces(List<Type> interfaces) {
		this.interfaces = interfaces;
	}
	

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
