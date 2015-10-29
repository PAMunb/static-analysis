package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;

import br.unb.cic.sa.Parser;
import br.unb.cic.sa.model.OpportunitiesLambdaExp;

public class OpportunitiesLambdaExpVisitor extends Visitor<OpportunitiesLambdaExp> {

	@Override
	public boolean visit(ForStatement node) {

		char[]contents = node.getBody().toString().toCharArray();
		
		Block b = Parser.Instance().parse(contents);
 
		b.accept(new ASTVisitor() {
			
			@Override
			public boolean visit(IfStatement statement) {
			
//				System.out.println("File: "+file + " StartLine: "+ unit.getLineNumber(node.getStartPosition()) );
				
				OpportunitiesLambdaExp o = new OpportunitiesLambdaExp(file, unit
						.getLineNumber(node.getStartPosition()), unit
						.getLineNumber(node.getStartPosition()
								+ node.getLength()));
				
				collectedData.addValue(o);
				
				return true;
			}
			
		});
		
		return super.visit(node);
	}

}
