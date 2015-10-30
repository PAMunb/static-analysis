package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.StringLiteral;

import br.unb.cic.sa.model.SwitchStringOpportunities;


/**
 * This visitor class collects relevant data about the opportunities for using Switch 
 * Strings
 * 
 * TODO: acho que devemos discutir um pouco essa implementacao.
 * 
 * @author Thiago Cavalcanti / Vinicius Correa / Daniella Angelos
 */
public class SwitchStringOpportunitiesVisitor extends Visitor<SwitchStringOpportunities>{
	
	InfixExpression infix;

	@Override
	public boolean visit(IfStatement node){
		infix = null;
		
		Expression expression = node.getExpression();
				
		if(expression instanceof InfixExpression){
			infix = (InfixExpression) node.getExpression();
			
			if(infix.getOperator() == InfixExpression.Operator.EQUALS)
				ProcessInfix(infix, node);
		}

		return super.visit(node);
	}
	
	
	public void ProcessInfix(InfixExpression infix, IfStatement node){
		if((infix.getLeftOperand() instanceof StringLiteral) || (infix.getRightOperand() instanceof StringLiteral)){
			this.collectedData.addValue(new SwitchStringOpportunities(this.file,
					unit.getLineNumber(node.getStartPosition()),
					unit.getLineNumber(node.getStartPosition()+node.getLength())));
		}
	}
}
