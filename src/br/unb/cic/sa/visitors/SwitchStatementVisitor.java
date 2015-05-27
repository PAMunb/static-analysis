package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SwitchStatement;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Switch;

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

		this.colletion.addSwitch(new Switch(this.file, unit.getLineNumber(node
				.getStartPosition()), unit.getLineNumber(node
				.getStartPosition() + node.getLength())));


		if (((Object)node.getExpression()) instanceof SimpleName) {
			this.colletion.addSwichWithString(new Switch(this.file, unit
					.getLineNumber(node.getStartPosition()), unit
					.getLineNumber(node.getStartPosition()
							+ node.getLength())));
		}
		
		

		return super.visit(node);
	}

}
