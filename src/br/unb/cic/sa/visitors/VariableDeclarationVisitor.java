package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

import br.unb.cic.sa.model.Variable;

public class VariableDeclarationVisitor extends Visitor implements IVisitor {

	@Override
	public boolean visit(SingleVariableDeclaration node){
		Variable var = new Variable(file, node.getName().toString(),
				unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition() 
						+ node.getLength()));
		this.collection.addVariable(var);
		
		if(node.getType().isParameterizedType()){
			this.collection.addParameterizedVariable(var);
		}
		return super.visit(node);
	}
}
