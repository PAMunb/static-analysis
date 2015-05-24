package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumDeclaration;

import br.unb.cic.sa.model.CollectedData;

public class EnumDeclarationVisitor extends ASTVisitor {

	private CompilationUnit unit;
	private CollectedData colletion;
	private String file;
	
	public EnumDeclarationVisitor(CompilationUnit unit, String file,
			CollectedData collection) {

		this.unit = unit;
		this.file = file;
		this.colletion = collection;

	}
	
	
	@Override
	public boolean visit(EnumDeclaration node) {
		
		if(node.enumConstants().size()>0){
			System.out.println("Enum in "+this.file);	
		}
		
		
		System.out.println(node.toString());
				
		
		return super.visit(node);
	}

	
}
