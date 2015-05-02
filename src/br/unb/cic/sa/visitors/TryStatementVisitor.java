package br.unb.cic.sa.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TryStatement;

public class TryStatementVisitor extends ASTVisitor {
		
	private List<TryStatement> data;
	
	public TryStatementVisitor() {
		this.data = new ArrayList<TryStatement>();
	}

	
	public List<TryStatement> getTSCollected(){
		return this.data;
	}
	
	
	@Override
	public boolean visit(TryStatement node){
//		System.out.println(node.hashCode());
		this.data.add(node);
		return super.visit(node);
	}
	
	
}
