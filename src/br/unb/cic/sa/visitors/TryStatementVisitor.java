package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.TryStatement;

import br.unb.cic.sa.model.Try;
import br.unb.cic.sa.similarity.CatchSimilarityInTryBlock;

public class TryStatementVisitor extends Visitor{

	private CatchSimilarityInTryBlock check = new CatchSimilarityInTryBlock();
	

	@Override
	public boolean visit(TryStatement node) {
		//add all try block to collection
		
		Try t = new Try(this.file, unit
				.getLineNumber(node.getStartPosition()), unit
				.getLineNumber(node.getStartPosition()
						+ node.getLength()), 0, 0);
		
		this.collection.addTry(t);
		
		if(node.resources().size()>0){
			this.collection.addTryResource(t);
		}
		
		// add try block in collection only if has similars catchs
		if (node.catchClauses().size() > 1) {

			if (this.check.check(node.catchClauses())){
				
				CatchClause c1  = (CatchClause) node.catchClauses().get(0);
				CatchClause cn  = (CatchClause) node.catchClauses().get(node.catchClauses().size()-1);
				
				int c1Init = unit.getLineNumber(c1.getStartPosition());
				int c1End  = unit.getLineNumber(c1.getStartPosition()+c1.getLength());
				int cnEnd  = unit.getLineNumber(cn.getStartPosition()+cn.getLength());
				
				int locBeforeRefactoring = (cnEnd-c1Init);
				int locAfterRefactoring = (c1End - c1Init);
						
				
				t.setLocBeforeRefactoring(locBeforeRefactoring);
				t.setLocAfterRefactoring(locAfterRefactoring);
				
				System.out.println(file);
				
				System.out.println("Catch init: "+ c1Init);
				System.out.println("Cn End: "+cnEnd);
				
				System.out.println("Loc Before Refactoring: "+  (cnEnd - c1Init));
				System.out.println("Loc Before Refactoring: "+  t.getLocBeforeRefactoring());
				
				System.out.println("#Loc After Refactoring: "+  (c1End - c1Init));
				System.out.println("#Loc After Refactoring: "+  t.getLocAfterRefactoring());

				
				
				this.collection.addTryWithSimilartyCatch(t);

				
			}


		}

		return super.visit(node);
	}

}
