package br.unb.cic.sa.similarity;

import org.eclipse.jdt.core.dom.ASTMatcher;
import org.eclipse.jdt.core.dom.Block;

/**
 * A basic <i>SimilarityChecker</i> based on subtree matching. 
 * 
 * @author Thiago Cavalcanti / Vinicius Correa
 */
public class BasicSimilarityChecker extends ASTMatcher implements SimilarityChecker {

	/**
	 * Default constructor. 
	 */
	public BasicSimilarityChecker(){}

	@Override
	public boolean checkSimilarity(Block first, Block second){
		return first.subtreeMatch(new ASTMatcher(), second);
	}
}
