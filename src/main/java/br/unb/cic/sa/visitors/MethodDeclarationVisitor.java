package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.unb.cic.sa.model.Method;

public class MethodDeclarationVisitor extends Visitor<Method>  {
	@Override
	public boolean visit(MethodDeclaration node) {
		Method method = new Method(file, node.getName().toString(),
				unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition()
						+ node.getLength()));

		
		if (node.isVarargs()) {	
			method.setVarArgs(true);
		}
		
		if(!node.isConstructor() && 
				node.getReturnType2() != null && node.getReturnType2().isParameterizedType()){
			method.setParameterizedMethod(true);
		}

		this.collectedData.addValue(method);
		
		return super.visit(node);
	}
}
