package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ThisExpression;

public class ThisExpressionVisitor extends ASTVisitor {

	private boolean found;
	
	public ThisExpressionVisitor() {
		found = false;
	}
	
	public boolean visit(ThisExpression exp) {
		found = true;
		return true;
	}
	
	public boolean found() {
		return found;
	}
}
