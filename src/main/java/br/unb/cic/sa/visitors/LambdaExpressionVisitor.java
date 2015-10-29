package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.LambdaExpression;

import br.unb.cic.sa.model.LambdaExp;

public class LambdaExpressionVisitor extends Visitor<LambdaExp>{

	@Override
	public boolean visit(LambdaExpression node) {
		
		//add all LambdaExpression to collection
		this.collectedData.addValue(new LambdaExp(this.file, unit
						.getLineNumber(node.getStartPosition()), unit
						.getLineNumber(node.getStartPosition()
								+ node.getLength())));
			
		return super.visit(node);
	}
	
}
