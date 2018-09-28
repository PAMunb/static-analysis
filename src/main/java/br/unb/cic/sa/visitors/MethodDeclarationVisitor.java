package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.WhileStatement;

import br.unb.cic.sa.model.MethodDeclaration;
import br.unb.cic.sa.model.ModifyHandler;

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
		
		for(Object m: node.modifiers()) {
			if(m.toString().equals("default")) {
				method.setDefaultMethod(true);
			}
		}
		
		if (!node.isConstructor() && node.getReturnType2() != null && node.typeParameters().size() > 0) {
			method.setParameterizedMethod(true);
			method.setParameterizedType(node.getReturnType2().toString());
		}
		else {
			method.setParameterizedType("none");
		}
			
		method.setAnnotations(ModifyHandler.listAnnotations((node.modifiers())));

		method.setSynchronizedMethod(ModifyHandler.isSynchronized(node.modifiers()));
		
		ACCNVisitor visitor = new ACCNVisitor();
		
		node.accept(visitor);
		
		method.setAccn(visitor.accn);

		this.collectedData.addValue(method);

		return super.visit(node);
	}
	
	/*
	 * A helper visitor for computing the metric ACCN
	 */
	class ACCNVisitor extends ASTVisitor {
		int accn = 1;
		
		@Override
		public boolean visit(IfStatement node) {
			accn++;
			return super.visit(node);
		}
		
		@Override
		public boolean visit(DoStatement node) {
			accn++;
			return super.visit(node); 
		}
		
		@Override
		public boolean visit(WhileStatement node) {
			accn++;
			return super.visit(node);
		}
		
		@Override
		public boolean visit(ForStatement node) {
			accn++;
			return super.visit(node); 
		}
		
		@Override
		public boolean visit(SwitchCase node) {
			accn++;
			return super.visit(node);
		}
		
		@Override
		public boolean visit(CatchClause node) {
			accn++;
			return super.visit(node);
		}
		
		@Override
		public boolean visit(ConditionalExpression exp) {
			accn++;
			return super.visit(exp);
		}
		
		@Override
		public boolean visit(EnhancedForStatement stmt) {
			accn++;
			return super.visit(stmt); 
		}
	}
	
}
