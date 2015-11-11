package br.unb.cic.sa.visitors;

import java.util.List;

import org.eclipse.jdt.core.dom.MarkerAnnotation;

import br.unb.cic.sa.model.MethodDeclaration;

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

		if (!node.isConstructor() && node.getReturnType2() != null && node.getReturnType2().isParameterizedType()) {
			method.setParameterizedMethod(true);
			method.setParameterizdType(node.getReturnType2().toString());
		}
		else {
			method.setParameterizdType("none");
		}
			
		method.setAnnotations(Annotations(node.modifiers()));

		method.setSynchronizedMethod(Synchronized(node.modifiers()));

		this.collectedData.addValue(method);

		return super.visit(node);
	}
		
	private boolean Synchronized(List<MarkerAnnotation> list){
		return list.toString().contains("synchronized");
	}
	
	private String Annotations(List<MarkerAnnotation> list) {
		
		String annotations;
		if(list.toString().contains("@")) annotations = list.toString();
		else annotations = "[]";
		return annotations; 
		
	}
	
}
