package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;

import br.unb.cic.sa.model.AnonymousClass;

public class AnonymousClassVisitor extends Visitor {

	@Override
	public boolean visit(AnonymousClassDeclaration node) {

		AnonymousClass a = new AnonymousClass(this.file, unit
				.getLineNumber(node.getStartPosition()), unit
				.getLineNumber(node.getStartPosition()
						+ node.getLength()));	
		
		collection.addAnonymousClass(a);
		
		
		return super.visit(node);
	}

}
