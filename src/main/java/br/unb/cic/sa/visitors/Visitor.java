package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.Data;

public class Visitor<T> extends ASTVisitor implements IVisitor<T> {
	protected CompilationUnit unit;
	protected Data<T> collectedData;
	protected String file;
	
	public Visitor() {}
	
	@Override
	public void setUnit(CompilationUnit unit) {
		this.unit = unit;
	}
	
	@Override
	public void setCollectedData(Data<T> colletion) {
		this.collectedData = colletion;
	}
	
	@Override
	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public Data<T> getCollectedData() {
		return collectedData;
	}
	
	
}
