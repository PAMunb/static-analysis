package br.unb.cic.sa.similarity;

import org.eclipse.jdt.core.dom.Block;

/**
 * An interface for checking for code clones using the 
 * Eclipse API. 
 * 
 * @author rbonifacio
 */
public interface SimilarityChecker {

	/**
	 * Returns true when the both arguments (first and second blocks) are similar. 
	 * 
	 * @param first a block 
	 * @param second a different block 
	 * 
	 * @return <i>true</i> when first and second are similar. 
	 */
	public boolean checkSimilarity(Block first, Block second);
}
