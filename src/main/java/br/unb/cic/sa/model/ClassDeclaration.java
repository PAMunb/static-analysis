package br.unb.cic.sa.model;

import java.util.List;

import org.eclipse.jdt.core.dom.Type;

public class ClassDeclaration extends AbsStatementModel{
		private boolean isParameterized;
	
	public ClassDeclaration(String file, String name, Type superClass,
			List<Type> interfaces, int startLine, int endLine){
		this.setFile(file);
		this.setName(name);
		this.setSuperClass(superClass);
		this.setInterfaces(interfaces);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
	}

	public boolean getParameterized() {
		return isParameterized;
	}

	public void setParameterized(boolean isParameterized) {
		this.isParameterized = isParameterized;
	}
	
	
	
}