package br.unb.cic.sa.visitors;

import br.unb.cic.sa.model.EnumDeclaration;

/**
 * This visitor class collects relevant data about Java Enum declarations.
 * 
 * @author rbonifacio
 */
public class EnumDeclarationVisitor extends Visitor<EnumDeclaration> {

	@Override
	public boolean visit(org.eclipse.jdt.core.dom.EnumDeclaration node) {

		EnumDeclaration dec = new EnumDeclaration(this.file, unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getLength() - node.getStartPosition()));
		
		collectedData.addValue(dec);

		return true;
	}

}
