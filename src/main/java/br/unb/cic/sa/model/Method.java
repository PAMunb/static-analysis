package br.unb.cic.sa.model;

public class Method extends AbsStatementModel{
	
	private boolean varArgs;
	private boolean parameterizedMethod;
	
	public Method(String file, String name, int startLine, int endLine){
		this.setName(name);
		this.setFile(file);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
	}

	public boolean getVarArgs() {
		return varArgs;
	}

	public void setVarArgs(boolean varArgs) {
		this.varArgs = varArgs;
	}

	public boolean getParameterizedMethod() {
		return parameterizedMethod;
	}

	public void setParameterizedMethod(boolean parameterizedMethod) {
		this.parameterizedMethod = parameterizedMethod;
	}
	
	


}
