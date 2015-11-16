package br.unb.cic.sa.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;

import br.unb.cic.sa.model.LambdaExpOpportunities;

public class FilterPatternVisitor extends Visitor<LambdaExpOpportunities>{

	private SingleVariableDeclaration var;
	private boolean reference = false;
	
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
			reference = false;
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
		
		//only a <i>call to an add method</i> statement on the then clause
		if(stmt.getThenStatement() instanceof Block) {
			Block block = (Block)stmt.getThenStatement();
			if(block.statements().size() == 1 && block.statements().get(0) instanceof ExpressionStatement) {
				ExpressionStatement exp = (ExpressionStatement)block.statements().get(0);
				if(exp.getExpression() instanceof MethodInvocation) {
					if(!checkStatementOfThenClause((MethodInvocation)exp.getExpression())) {
						return false;
					}
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else if(stmt.getThenStatement() instanceof ExpressionStatement) {
			ExpressionStatement exp = (ExpressionStatement)stmt.getThenStatement();
			if(exp.getExpression() instanceof MethodInvocation) {
				if(!checkStatementOfThenClause((MethodInvocation)exp.getExpression())) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else{ 
			return false;
		}
		
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

	private boolean checkStatementOfThenClause(MethodInvocation mi) {
		if(mi.getName().toString().equals("add") && mi.arguments().size() == 1) {
			reference = false;
			Expression e = (Expression)mi.arguments().get(0);
		
			e.accept(new ASTVisitor() {
				@Override
				public boolean visit(SimpleName n) {
					if(n.toString().equals(var.getName().toString())) {
						reference = true;
					}
					return true;
				}
				
				@Override
				public boolean visit(MethodInvocation mi) {
					if(mi.getExpression() != null && mi.getExpression().toString().equals(var.getName().toString())) {
						reference = true;
					}
					return true;
				}
			});
			return reference;
		}
		else {
			return false;
		}
	//	return mi.getName().toString().equals("add") && mi.arguments().size() == 1 && checkArgument(mi.arguments().get(0));
	}
	
	
//	private boolean checkArgument(Object exp) {
//		if(exp instanceof SimpleName) {
//			return ((SimpleName)exp).toString().equals(var.getName().toString());
//		}
//		else if(exp instanceof MethodInvocation) {
//			MethodInvocation mi = (MethodInvocation)exp;
//			return mi.getExpression() != null && mi.getExpression().toString().equals(var.getName().toString());
//		}
//		return false;
//	}

	public void test() {
		List<String> l = new ArrayList<>();
		List<String> m = new ArrayList<>();
		l.add("foo");
		for(String s: l) {
			if(s.equals("foo")) {
				m.add(s);
			}
		}
	}

	
}
