package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.LambdaExpression;

import br.unb.cic.sa.model.LambdaExp;

/**
 * This visitor class collects relevant data about the Use of Lambda
 * Expressions.
 * 
 * @author Thiago Cavalcanti / Vinicius Correa
 */
public class LambdaExpressionVisitor extends Visitor<LambdaExp> {
	
	@Override
	public boolean visit(LambdaExpression node) {
		// add all LambdaExpression to collection

		LambdaExp exp = new LambdaExp(this.file, unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition() + node.getLength()));

//		exp.setParentMethodInvocation(node.getParent().toString());

		exp.setParentMethodInvocation("");

		
		this.collectedData.addValue(exp);

		return super.visit(node);
	}

}
