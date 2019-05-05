package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ImportDeclaration;

import br.unb.cic.sa.model.ImpDeclaration;

/**
 * This visitor class collects relevant data about the opportunities for using Lambda
 * Expressions.
 * 
 * 
 * @author Thiago Cavalcanti / Vinicius Correa / Daniella Angelos
 */
public class ImportDeclarationVisitor extends Visitor<ImpDeclaration> {

	static int total = 0;
	static int validos = 0;
	static int nReturn = 0;
	static int nContinue = 0;
	static int nBreak = 0;
	static int nThrows = 0;
	static int nExtReference = 0;
	static int totalFilter = 0;
	static boolean filter = false;
	
	
	
	@Override
	public boolean visit(ImportDeclaration node) {
		ImpDeclaration id = new ImpDeclaration(file, unit
				.getLineNumber(node.getStartPosition()), unit
				.getLineNumber(node.getStartPosition()
						+ node.getLength()));
		
		id.setImportDeclaration(node.getName().toString().replace(";", ""));
		
		collectedData.addValue(id);
		return true;
	}
	
	
	
}
