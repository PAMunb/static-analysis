package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;

import br.unb.cic.sa.model.Switch;

public class SwitchStatementVisitor extends Visitor implements IVisitor {

		@Override
	public boolean visit(SwitchStatement node) {

		this.collection.addSwitch(new Switch(this.file, unit.getLineNumber(node
				.getStartPosition()), unit.getLineNumber(node
				.getStartPosition() + node.getLength())));

		SwitchCase sc = (SwitchCase) node.statements().get(0);
		if (sc.getExpression() instanceof StringLiteral) {
			this.collection
					.addSwichWithString(new Switch(this.file, unit
							.getLineNumber(node.getStartPosition()), unit
							.getLineNumber(node.getStartPosition()
									+ node.getLength())));

		}

		return super.visit(node);
	}

}
