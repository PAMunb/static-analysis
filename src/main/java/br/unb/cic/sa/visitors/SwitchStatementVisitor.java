package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SwitchCase;

import br.unb.cic.sa.model.SwitchStatement;

/**
 * This visitor class collects relevant data about the Use of SwitchStatements
 * 
 * @author Thiago Cavalcanti / Vinicius Correa / Daniella Angelos
 */
public class SwitchStatementVisitor extends Visitor<SwitchStatement>{

	@Override
	public boolean visit(org.eclipse.jdt.core.dom.SwitchStatement node) {

		SwitchStatement ss = new SwitchStatement(this.file, unit.getLineNumber(node
				.getStartPosition()), unit.getLineNumber(node
				.getStartPosition() + node.getLength()));
		
		if(node.statements().size() > 0){
			SwitchCase sc = (SwitchCase) node.statements().get(0);
			if (sc.getExpression() instanceof StringLiteral) {
				ss.setSwitchString(true);
			}
		}

		this.collectedData.addValue(ss);

		return super.visit(node);
	}

}
