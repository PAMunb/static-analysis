package br.unb.cic.sa.visitors;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.functors.ForClosure;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;

import br.unb.cic.sa.model.LambdaExpOpportunities;

public class MapPatternVisitor extends Visitor<LambdaExpOpportunities>{

	private SingleVariableDeclaration var;
	
	@Override
	public boolean visit(EnhancedForStatement node) {
		var = node.getParameter();
		Statement statement = node.getBody();
		
		if(statement instanceof Block && checkBlock((Block)statement)) {
			LambdaExpOpportunities exp = new LambdaExpOpportunities(file, unit
					.getLineNumber(node.getStartPosition()), unit
					.getLineNumber(node.getStartPosition()
							+ node.getLength()));
			
			exp.setStatements(((Block)statement).statements().size());
			collectedData.addValue(exp);
		}
		return true;
	}
	
	private boolean checkBlock(Block block) {
		if(block.statements().isEmpty()) {
			return false;
		}
		
		int idxLastStatement = block.statements().size() - 1;
		Statement lastStatement = (Statement)block.statements().get(idxLastStatement);
		if(lastStatement instanceof ExpressionStatement) {
			ExpressionStatement exp = (ExpressionStatement)lastStatement;
			if(exp.getExpression() instanceof MethodInvocation) {
				MethodInvocation mi = (MethodInvocation)exp.getExpression();
				if(!mi.getName().toString().equals("add")) {
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
		for(int i = 0; i < idxLastStatement; i++) {
			if(!checkStatement((Statement)block.statements().get(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean checkStatement(Statement statement) {
		if(statement instanceof ExpressionStatement) {
			return checkExpressionStatement((ExpressionStatement)statement);
		}
		return false;
	}

	private boolean checkExpressionStatement(ExpressionStatement statement) {
		if(statement.getExpression() instanceof MethodInvocation) {
			MethodInvocation mi = (MethodInvocation)statement.getExpression();
			return mi.getExpression() != null && mi.getExpression().toString().equals(var.getName().toString());
		}
		else if(statement.getExpression() instanceof Assignment) {
			Assignment ass = (Assignment)statement.getExpression();
			Expression lhs = ass.getLeftHandSide();
			return (lhs instanceof SimpleName) && ((SimpleName)lhs).toString().equals(var.getName().toString()); 
		}
		return false;
	}
	
	public void test() {
		List<String> in = new ArrayList<>();
		List<String> out = new ArrayList<>();
		
		in.add("abc");
		in.add("efg");
		
		for(String s: in) {
			s.toUpperCase();
			out.add(s);
		}
	}
}
