package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Type;

public class TypeDeclarationVisitor extends ASTVisitor implements IVisitor{

	private CompilationUnit unit;
	private CollectedData collection;
	private String file;
	
	public TypeDeclarationVisitor(){ }
	
	public TypeDeclarationVisitor(CompilationUnit unit, String file,
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
	public void setColletion(CollectedData collection) {
		this.collection = collection;
	}
	@Override
	public void setFile(String file) {
		this.file = file;
	}
	
	@Override
	public boolean visit(TypeDeclaration node) {
		Type t = new Type(this.file, node.getName().toString(),
				unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition()
						+ node.getLength()));
		//add type in collection
		this.collection.addType(t);
		if(!(node.typeParameters().isEmpty())){
			this.collection.addParameterizedType(t);
		}
		return super.visit(node);
	}
}
