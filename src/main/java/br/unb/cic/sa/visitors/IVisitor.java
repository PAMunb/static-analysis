package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.Data;

public interface IVisitor<T> {
	
	public void setUnit(CompilationUnit unit);
	public void setCollectedData(Data<T> colletion);
	public Data<T> getCollectedData();
	public void setFile(String file);
	
}
