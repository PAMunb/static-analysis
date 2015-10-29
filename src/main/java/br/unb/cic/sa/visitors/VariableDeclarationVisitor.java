package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

import br.unb.cic.sa.model.Variable;

public class VariableDeclarationVisitor extends Visitor<Variable>{

	@Override
	public boolean visit(SingleVariableDeclaration node){
		Variable var = new Variable(file, node.getName().toString(), node.getType());
		
		if(node.getType().isParameterizedType()){
			var.setParameterized(true);
		}
		
		this.collectedData.addValue(var);
		
		return super.visit(node);
	}
}
