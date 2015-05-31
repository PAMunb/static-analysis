package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.CollectedData;

public class Visitor extends ASTVisitor implements IVisitor {

	protected CompilationUnit unit;
	protected CollectedData collection;
	protected String file;
	
	public Visitor() {}
	
	public Visitor(CompilationUnit unit, String file,
			CollectedData collection) {

		this.unit = unit;
		this.file = file;
		this.collection = collection;

	}
	
	@Override
	public void setUnit(CompilationUnit unit) {
		this.unit = unit;
	}
	
	@Override
	public void setColletion(CollectedData colletion) {
		this.collection = colletion;
	}
	
	@Override
	public void setFile(String file) {
		this.file = file;
	}
}
