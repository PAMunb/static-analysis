package br.unb.cic.sa.model;

import java.util.List;

import org.eclipse.jdt.core.dom.Type;

/**
 * This class maintains relevant information about 
 * class declarations. 
 * 
 * @author Thiago Cavalcante / Vinicius Correa
 */
public class TypeDeclaration {
	private String file;
	private int startLine;
	private int endLine;
	
	private String name;
	private Type superClass;
	private List<Type> interfaces;
	
	private int typeParameters;
	private List<String> typeParameterModifiers;
	
	public TypeDeclaration(String file, String name, Type superClass,
			List<Type> interfaces, int startLine, int endLine){
		this.file = file;
		this.name = name;
		this.superClass = superClass;
		this.interfaces = interfaces;
		this.startLine = startLine;
		this.endLine = endLine;
	}

	
	public int getTypeParameters() {
		return typeParameters;
	}


	public void setTypeParameters(int typeParameters) {
		this.typeParameters = typeParameters;
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

	public List<Type> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<Type> interfaces) {
		this.interfaces = interfaces;
	}


	public List<String> getTypeParameterModifiers() {
		return typeParameterModifiers;
	}


	public void setTypeParameterModifiers(List<String> typeParameterModifiers) {
		this.typeParameterModifiers = typeParameterModifiers;
	}
}