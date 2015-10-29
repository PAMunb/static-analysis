package br.unb.cic.sa.model;

import org.eclipse.jdt.core.dom.Type;

public class Variable extends AbsStatementModel{
	
	private boolean isParameterized = false;
	
	public Variable(String file, String name, Type type){
		this.setFile(file);
		this.setName(name);
		this.setType(type);
	}

	public boolean getParameterized() {
		return isParameterized;
	}

	public void setParameterized(boolean isParameterized) {
		this.isParameterized = isParameterized;
	}

}