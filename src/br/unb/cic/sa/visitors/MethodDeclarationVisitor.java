package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Method;



public class MethodDeclarationVisitor extends ASTVisitor {


	private CompilationUnit unit;
	private CollectedData colletion;
	private String file;

	public MethodDeclarationVisitor(CompilationUnit unit, String file,
			CollectedData collection) {

		this.unit = unit;
		this.file = file;
		this.colletion = collection;

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
