package br.unb.cic.sa.model;

/**
 * This class maintains relevant information about 
 * method declaration. 
 * 
 * @author Thiago Cavalcanti / Rodrigo Bonifacio
 */
public class MethodDeclaration {
	
	private String file;
	private int startLine;
	private int endLine; 
	private String name;
	private boolean varArgs;
	private boolean parameterizedMethod;
	private String parameterizdType;
	
	public MethodDeclaration(String file, int startLine, int endLine, String name){
		this.file = file;
		this.startLine = startLine;
		this.endLine = endLine;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVarArgs() {
		return varArgs;
	}

	public void setVarArgs(boolean varArgs) {
		this.varArgs = varArgs;
	}

	public boolean isParameterizedMethod() {
		return parameterizedMethod;
	}

	public void setParameterizedMethod(boolean parameterizedMethod) {
		this.parameterizedMethod = parameterizedMethod;
	}

	public String getParameterizdType() {
		return parameterizdType;
	}

	public void setParameterizdType(String parameterizdType) {
		this.parameterizdType = parameterizdType;
	}
}
