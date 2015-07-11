package br.unb.cic.sa.model;

import org.eclipse.jdt.core.dom.Type;

public class Variable extends AbsStatementModel{
	
	public Variable(){
		
	}
	
	public Variable(String file, String name, Type type){
		this.setFile(file);
		this.setName(name);
		this.setType(type);
	}
}