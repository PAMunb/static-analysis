package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.EnumDeclaration;

public class EnumDeclarationVisitor extends Visitor implements IVisitor {
	
	@Override
	public boolean visit(EnumDeclaration node) {
		
		if(node.enumConstants().size()>0){
			System.out.println("Enum in "+this.file);	
		}
		
		System.out.println(node.toString());
				
		return super.visit(node);
	}

	
}
