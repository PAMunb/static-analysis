package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.TypeDeclaration;

import br.unb.cic.sa.model.ClassDeclaration;

public class TypeDeclarationVisitor extends Visitor<ClassDeclaration>{

	@Override
	public boolean visit(TypeDeclaration node) {
		ClassDeclaration t = new ClassDeclaration(this.file, node.getName().toString(),
				node.getSuperclassType(),
				node.superInterfaceTypes(),
				unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition()
						+ node.getLength()));
		
		if(!(node.typeParameters().isEmpty())){
			t.setParameterized(true);
		}
		
		collectedData.addValue(t);
		
		return super.visit(node);
	}
}
