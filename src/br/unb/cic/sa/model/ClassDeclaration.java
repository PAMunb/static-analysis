package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.Type;

public class ClassDeclaration {
	
	private String file;
	private String name;
	private Type superClass;
	private List<Type> interfaces;
	private int startLine;
	private int endLine;
	
	public ClassDeclaration(){
		
	}
	
	public ClassDeclaration(String file, String name, Type superClass,
			List<Type> interfaces, int startLine, int endLine){
		this.file = file;
		this.name = name;
		this.superClass = superClass;
		this.interfaces = new ArrayList<Type>();
		this.interfaces = interfaces;
		this.startLine = startLine;
		this.endLine = endLine;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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