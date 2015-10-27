package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.CollectedData;

public interface IVisitor {
	
	public void setUnit(CompilationUnit unit);
	public void setColletion(CollectedData colletion);
	public void setFile(String file);
	
}
