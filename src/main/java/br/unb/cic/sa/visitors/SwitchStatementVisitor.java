package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;

import br.unb.cic.sa.model.Switch;

public class SwitchStatementVisitor extends Visitor<Switch>{

		@Override
	public boolean visit(SwitchStatement node) {

		this.collectedData.addValue(new Switch(this.file, unit.getLineNumber(node
				.getStartPosition()), unit.getLineNumber(node
				.getStartPosition() + node.getLength())));

		
		if(node.statements().size()>0){
		
			SwitchCase sc = (SwitchCase) node.statements().get(0);
			if (sc.getExpression() instanceof StringLiteral) {
				this.collectedData
						.addValue(new Switch(this.file, unit
								.getLineNumber(node.getStartPosition()), unit
								.getLineNumber(node.getStartPosition()
										+ node.getLength())));
	
			}
		}

		return super.visit(node);
	}

}
