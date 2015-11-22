package br.unb.cic.sa.visitors;

import br.unb.cic.sa.model.MethodDeclaration;
import br.unb.cic.sa.model.ModifyHandler;

/**
 * This visitor class collects relevant data about the Use of Lambda
 * Expressions.
 * 
 * @author Thiago Cavalcanti / Vinicius Correa / Daniella Angelos
 */
public class MethodDeclarationVisitor extends Visitor<MethodDeclaration> {
	
	@Override
	public boolean visit(org.eclipse.jdt.core.dom.MethodDeclaration node) {

		MethodDeclaration method = new MethodDeclaration(file, unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition() + node.getLength()), node.getName().toString());
		
		
		if (node.isVarargs()) {
			method.setVarArgs(true);
		}

		
		if (!node.isConstructor() && node.getReturnType2() != null && node.typeParameters().size() > 0) {
			method.setParameterizedMethod(true);
			method.setParameterizedType(node.getReturnType2().toString());
		}
		else {
			method.setParameterizedType("none");
		}
			
		method.setAnnotations(ModifyHandler.listAnnotations((node.modifiers())));

		method.setSynchronizedMethod(ModifyHandler.isSynchronized(node.modifiers()));

		this.collectedData.addValue(method);

		return super.visit(node);
	}
		
	
}
