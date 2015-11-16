package br.unb.cic.sa.model;

import java.util.List;

/**
 * This class captures relevant data about 
 * the declaration of fields and variables.
 * 
 * @author rbonifacio
 */
public class FieldAndVariableDeclaration {
	
	private String file;
	private int startLine;
	private int endLine;
	
	private String name;
	private String type;
	
	private boolean field = false;
	private boolean parameterized = false;
	
	private String baseType;
	private List<String> typeParameters;
	private String annotations;
	
	public FieldAndVariableDeclaration(String file, int startLine, int endLine, String name, String type){
		this.file = file;
		this.startLine = startLine;
		this.endLine = endLine; 
		this.name = name;
		this.type = type;
	}

	public boolean isParameterized() {
		return parameterized;
	}

	public void setParameterized(boolean parameterized) {
		this.parameterized = parameterized;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isField() {
		return field;
	}

	public void setField(boolean field) {
		this.field = field;
	}

	public List<String> getTypeParameters() {
		return typeParameters;
	}

	public void setTypeParameters(List<String> typeParameters) {
		this.typeParameters = typeParameters;
	}

	public String getAnnotations() {
		return annotations;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}
}