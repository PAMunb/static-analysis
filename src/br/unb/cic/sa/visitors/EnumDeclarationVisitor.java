package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumDeclaration;

import br.unb.cic.sa.model.CollectedData;

public class EnumDeclarationVisitor extends ASTVisitor implements IVisitor {

	private CompilationUnit unit;
	private CollectedData colletion;
	private String file;
	
	public EnumDeclarationVisitor(){ }
	
	public EnumDeclarationVisitor(CompilationUnit unit, String file,
			CollectedData collection) {

		this.unit = unit;
		this.file = file;
		this.colletion = collection;

	}
	
	@Override
	public void setUnit(CompilationUnit unit) {
		this.unit = unit;
	}
	@Override
	public void setColletion(CollectedData colletion) {
		this.colletion = colletion;
	}
	@Override
	public void setFile(String file) {
		this.file = file;
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
