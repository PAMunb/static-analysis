package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.TypeDeclaration;

import br.unb.cic.sa.model.Type;

public class TypeDeclarationVisitor extends Visitor implements IVisitor{

	@Override
	public boolean visit(TypeDeclaration node) {
		Type t = new Type(this.file, node.getName().toString(),
				unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition()
						+ node.getLength()));
		//add type in collection
		collection.addType(t);
		if(!(node.typeParameters().isEmpty())){
			collection.addParameterizedType(t);
		}
		
		return super.visit(node);
	}
}
