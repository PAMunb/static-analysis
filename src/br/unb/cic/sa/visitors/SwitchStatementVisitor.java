package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SwitchStatement;

import br.unb.cic.sa.model.CollectedData;

public class SwitchStatementVisitor extends ASTVisitor implements IVisitor {

	private CompilationUnit unit;
	private CollectedData colletion;
	private String file;

	public SwitchStatementVisitor() {
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
	public boolean visit(SwitchStatement node) {
		
//		System.out.println("Expression Property:" + node.getStructuralProperty(SwitchStatement.EXPRESSION_PROPERTY));
//		System.out.println("Expression Property:" + node);
//		System.exit(0);

		return super.visit(node);
	}

}
