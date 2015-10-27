package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.StringLiteral;

import br.unb.cic.sa.model.OpportunitieSwitchString;


public class OpportunitiesSwitchStringVisitor extends Visitor{
	
	InfixExpression infix;
//	PrefixExpression prefix;

	@Override
	public boolean visit(IfStatement node){

		infix = null;
//		prefix = null;
		
		Expression expression = node.getExpression();
				
		if(expression instanceof InfixExpression){
			infix = (InfixExpression) node.getExpression();
			
			if(infix.getOperator() == InfixExpression.Operator.EQUALS)
				ProcessInfix(infix, node);
		}

		return super.visit(node);
	}
	
	
	public void ProcessInfix(InfixExpression infix, IfStatement node){
		
		if(
			(infix.getLeftOperand() instanceof StringLiteral) ||
			(infix.getRightOperand() instanceof StringLiteral)){
//			System.out.println("StringLiteral");
//			System.out.println("In "+this.file + " Line: "+ unit
//					.getLineNumber(node.getStartPosition()));
			
//			System.out.println("## "+infix.getLeftOperand()+" "+infix.getRightOperand());
//			System.out.println();

			
			this.collection.addOpportunitieSwichString(new OpportunitieSwitchString(this.file,
					unit.getLineNumber(node.getStartPosition()),
					unit.getLineNumber(node.getStartPosition()+node.getLength())));
		}
		
	}
	
	
	/**
	 * ---- Ignore at the moment ----
	 * 
	 * PrefixExpression Model 
	 * !checkVersion(jvmVersion,args)
	 * !extractor.supportsOperation(referenceDialect)
	 * !nullable
	 */
//	public void ProcessPrefix(PrefixExpression prefix){
//		
//		System.out.println("Prefix " + prefix.getOperand());
//		if((prefix.getOperand() instanceof StringLiteral) || (prefix.getRightOperand() instanceof StringLiteral)){
//			System.out.prinln("StringLiteral");
//		}
//	}
	
}
