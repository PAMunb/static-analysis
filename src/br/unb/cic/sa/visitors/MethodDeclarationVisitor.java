package br.unb.cic.sa.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MethodDeclarationVisitor extends ASTVisitor {

	private List<MethodDeclaration> data;

	
	public MethodDeclarationVisitor(){
		this.data = new ArrayList<MethodDeclaration>();
	}
	
	
	public List<MethodDeclaration> getMDCollected() {
		return data;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		// TODO Auto-generated method stub
		this.data.add(node);
		return super.visit(node);
	}
	
	
}
