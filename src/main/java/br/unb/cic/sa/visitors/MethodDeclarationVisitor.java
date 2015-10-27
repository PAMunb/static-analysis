package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.unb.cic.sa.model.Method;

public class MethodDeclarationVisitor extends Visitor implements IVisitor {
	@Override
	public boolean visit(MethodDeclaration node) {
		Method method = new Method(file, node.getName().toString(),
				unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition()
						+ node.getLength()));

		this.collection.addMethods(method);
		
		
		if (node.isVarargs()) {	
			this.collection.addMethodWithVargs(method);
		}
		
		if(!node.isConstructor() && 
				node.getReturnType2() != null && node.getReturnType2().isParameterizedType()){
			this.collection.addParameterizedMethod(method);
		}

		return super.visit(node);
	}
}
