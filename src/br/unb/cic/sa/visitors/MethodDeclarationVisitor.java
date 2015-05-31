package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.unb.cic.sa.model.Method;

public class MethodDeclarationVisitor extends Visitor implements IVisitor {
	@Override
	public boolean visit(MethodDeclaration node) {

		this.collection.addMethods(new Method(file, node.getName().toString(),
				unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition()
						+ node.getLength())));
		
		
		if (node.isVarargs()) {	
			this.collection.addMethodWithVargs(new Method(file, node.getName().toString(),
					unit.getLineNumber(node.getStartPosition()),
					unit.getLineNumber(node.getStartPosition()
							+ node.getLength())));
		}

		return super.visit(node);
	}
}
