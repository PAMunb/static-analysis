package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Method;



public class MethodDeclarationVisitor extends ASTVisitor implements IVisitor {

	private CompilationUnit unit;
	private CollectedData colletion;
	private String file;

	public MethodDeclarationVisitor(){ }
	
	public MethodDeclarationVisitor(CompilationUnit unit, String file,
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
	public boolean visit(MethodDeclaration node) {

		this.colletion.addMethods(new Method(file, node.getName().toString(),
				unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition()
						+ node.getLength())));
		
		
		if (node.isVarargs()) {	
			this.colletion.addMethodWithVargs(new Method(file, node.getName().toString(),
					unit.getLineNumber(node.getStartPosition()),
					unit.getLineNumber(node.getStartPosition()
							+ node.getLength())));
		}

		return super.visit(node);
	}
}
