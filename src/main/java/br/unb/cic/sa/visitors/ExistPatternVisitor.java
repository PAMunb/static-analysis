package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;

import br.unb.cic.sa.model.LambdaExpOpportunities;

public class ExistPatternVisitor extends Visitor<LambdaExpOpportunities>{

	private SingleVariableDeclaration var; 
	@Override
	public boolean visit(EnhancedForStatement node) {
		var = node.getParameter();
		Statement statement = node.getBody();
		boolean isFilterPattern = false; 
		
		if(statement instanceof Block) {
			isFilterPattern = checkBlock((Block)statement);
		}
		else if(statement instanceof IfStatement) {
			isFilterPattern = checkIfStatement((IfStatement)statement);
		}
		
		if(isFilterPattern) {
			LambdaExpOpportunities exp = new LambdaExpOpportunities(file, unit
					.getLineNumber(node.getStartPosition()), unit
					.getLineNumber(node.getStartPosition()
							+ node.getLength()));
			
			collectedData.addValue(exp);
		}
		return true;
	}
	
	private boolean checkBlock(Block statement) {
		Block block = (Block)statement;
		if(block.statements().size() == 1 && block.statements().get(0) instanceof IfStatement) {
			return checkIfStatement((IfStatement)block.statements().get(0));
		}
		return false;
	}

	private boolean checkIfStatement(IfStatement stmt) {
		//no else statement
		if(stmt.getElseStatement() != null) {
			return false;
		}
		
		//only a <i>return true</i> statement on the then clause
		if(stmt.getThenStatement() instanceof Block) {
			Block block = (Block)stmt.getThenStatement();
			if(block.statements().size() == 1 && block.statements().get(0) instanceof ReturnStatement) {
				if(!checkReturnStatementOfThenClause((ReturnStatement)block.statements().get(0))) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else if(stmt.getThenStatement() instanceof ReturnStatement) {
			if(!checkReturnStatementOfThenClause((ReturnStatement)stmt.getThenStatement())) {
				return false;
			}
		}
		else{return false;}
		
		//the expression of the if statement must be a method invocation 
		//from the foreach variable.
		if(stmt.getExpression() instanceof MethodInvocation) {
			MethodInvocation mi = (MethodInvocation)stmt.getExpression();
			if(mi.getExpression() instanceof SimpleName) {
				SimpleName name = (SimpleName)mi.getExpression();
				return name.toString().equals(var.getName().toString());
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	private boolean checkReturnStatementOfThenClause(ReturnStatement rs) {
		return rs.getExpression() instanceof BooleanLiteral && ((BooleanLiteral)rs.getExpression()).booleanValue(); 
	}

//	public boolean test() {
//		List<String> l = new ArrayList<>();
//		int count = 0;
//		l.add("foo");
////		return l.stream().anyMatch(s -> s.equals("blah"));
//		for(String s: l) {
//			if(s.equals("foo")) 
//				count++;
//		}
//		
//		for(String s: l) {
//			if(s.equals("blah")) {
//				return true;
//			}
//		}
//		return false;
//	}

	
}
