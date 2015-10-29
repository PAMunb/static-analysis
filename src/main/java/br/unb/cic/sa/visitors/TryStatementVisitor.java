package br.unb.cic.sa.visitors;

import java.util.List;

import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.TryStatement;

import br.unb.cic.sa.model.TryStatementData;
import br.unb.cic.sa.similarity.BasicSimilarityChecker;
import br.unb.cic.sa.similarity.SimilarityChecker;

public class TryStatementVisitor extends Visitor<TryStatementData>{

	SimilarityChecker similarity;
	
	public TryStatementVisitor() {
		similarity = new BasicSimilarityChecker();
	} 
	
	@Override
	public boolean visit(TryStatement node) {
		//add all try block to collection
		
		TryStatementData t = new TryStatementData(this.file, unit
				.getLineNumber(node.getStartPosition()), unit
				.getLineNumber(node.getStartPosition()
						+ node.getLength()));
		
		this.collectedData.addValue(t);
		
		if(node.resources().size()>0){
			t.setTryWithResource(true);
		}
		
		// add try block in collection only if has similar catches
		
		if (node.catchClauses().size() > 1) {

			if (this.checkSimilarity(node.catchClauses())){
				//TODO: This algorithm does not work (rbonifacio)
//				
//				CatchClause c1  = (CatchClause) node.catchClauses().get(0);
//				CatchClause cn  = (CatchClause) node.catchClauses().get(node.catchClauses().size()-1);
//				
//				int c1Init = unit.getLineNumber(c1.getStartPosition());
//				int c1End  = unit.getLineNumber(c1.getStartPosition()+c1.getLength());
//				int cnEnd  = unit.getLineNumber(cn.getStartPosition()+cn.getLength());
//				
//				int locBeforeRefactoring = (cnEnd-c1Init);
//				int locAfterRefactoring = (c1End - c1Init);
//				
//				t.setLocBeforeRefactoring(locBeforeRefactoring);
//				t.setLocAfterRefactoring(locAfterRefactoring);
				
				t.setMultiCatch(true);
			}
		}

		this.collectedData.addValue(t);
		
		return super.visit(node);
	}
	
	private boolean checkSimilarity(List<CatchClause> catchClause){
		for(CatchClause cc : catchClause){
			for(CatchClause cn : catchClause){
				//To ignore the same catch in loops
				if (!cc.equals(cn)) {
					if (this.similarity.checkSimilarity(cc.getBody(), cn.getBody())) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
