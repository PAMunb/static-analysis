package br.unb.cic.sa.similarity;

import org.eclipse.jdt.core.dom.ASTMatcher;
import org.eclipse.jdt.core.dom.Block;

public class CheckSimilarity extends ASTMatcher {
	
	public CheckSimilarity(){}

	public boolean match(Block node, Block other){

		return node.subtreeMatch(new ASTMatcher(), other);
	
	}
}
