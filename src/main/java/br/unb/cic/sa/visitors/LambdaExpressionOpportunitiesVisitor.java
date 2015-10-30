package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;

import br.unb.cic.sa.Parser;
import br.unb.cic.sa.model.LambdaExpOpportunities;

/**
 * This visitor class collects relevant data about the opportunities for using Lambda
 * Expressions.
 * 
 * TODO: acho que precisa sincronizar com a implementacao mais atual.
 * 
 * @author Thiago Cavalcanti / Vinicius Correa / Daniella Angelos
 */
public class LambdaExpressionOpportunitiesVisitor extends Visitor<LambdaExpOpportunities> {

	@Override
	public boolean visit(ForStatement node) {

		char[]contents = node.getBody().toString().toCharArray();
		
		Block b = Parser.Instance().parse(contents);
 
		b.accept(new ASTVisitor() {
			public boolean visit(IfStatement statement) {
				LambdaExpOpportunities o = new LambdaExpOpportunities(file, unit
						.getLineNumber(node.getStartPosition()), unit
						.getLineNumber(node.getStartPosition()
								+ node.getLength()));
				
				collectedData.addValue(o);
				
				return true;
			}
			
		});
		return super.visit(node);
	}

}
