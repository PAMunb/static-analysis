package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;


public class IfVisitor extends Visitor{
	
	
	@Override
	public boolean visit(IfStatement node){

		node.structuralPropertiesForType();
		Expression e = node.getExpression();
		
		
	node.getElseStatement().getNodeType();
	node.getThenStatement();
		System.out.println("Expression:"+ node.getExpression());
		
		
		return super.visit(node);
	}
	
}
