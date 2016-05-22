package br.unb.cic.sa.visitors;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TryStatement;

import br.unb.cic.sa.model.TryStatementData;
import br.unb.cic.sa.parser.Parser;
import br.unb.cic.sa.similarity.BasicSimilarityChecker;
import br.unb.cic.sa.similarity.SimilarityChecker;

/**
 * This visitor class collects relevant data about the Use of Try Statements.
 * 
 * @author Thiago Cavalcanti / Vinicius Correa / Daniella Angelos
 */
public class TryStatementVisitor extends Visitor<TryStatementData> {

	SimilarityChecker similarity;

	public TryStatementVisitor() {
		similarity = new BasicSimilarityChecker();
	}

	@Override
	public boolean visit(TryStatement node) {

		TryStatementData t = new TryStatementData(this.file, unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition() + node.getLength()));

		
		if (node.resources().size() > 0) {
			t.setTryWithResource(true);
		}
	
		if (node.catchClauses().size() > 1) {
			if (this.checkSimilarity(node.catchClauses())) {
				// TODO: This algorithm does not work (rbonifacio)
				//
				// CatchClause c1 = (CatchClause) node.catchClauses().get(0);
				// CatchClause cn = (CatchClause)
				// node.catchClauses().get(node.catchClauses().size()-1);
				//
				// int c1Init = unit.getLineNumber(c1.getStartPosition());
				// int c1End =
				// unit.getLineNumber(c1.getStartPosition()+c1.getLength());
				// int cnEnd =
				// unit.getLineNumber(cn.getStartPosition()+cn.getLength());
				//
				// int locBeforeRefactoring = (cnEnd-c1Init);
				// int locAfterRefactoring = (c1End - c1Init);
				//
				// t.setLocBeforeRefactoring(locBeforeRefactoring);
				// t.setLocAfterRefactoring(locAfterRefactoring);

				t.setMultiCatch(true);
			}
		}
		
		t.setNumberOfCatches(node.catchClauses() == null ? 0 : node.catchClauses().size());
		
		Block tryBlock = Parser.Instance().parse(node.getBody().toString().toCharArray());
		
		NumberOfStatementVisitor v = new NumberOfStatementVisitor();
		tryBlock.accept(v);
		
		t.setNumberOfStatements(v.numberOfStatements);

		int statements = 0; 
		
		for(Object c: node.catchClauses()) {
			CatchClause cc = (CatchClause)c;
			Block catchBlock = Parser.Instance().parse(cc.getBody().toString().toCharArray());
			v = new NumberOfStatementVisitor();
			catchBlock.accept(v);
			statements += v.numberOfStatements;
		}
		t.setNumberOfCatchStatements(statements);
		this.collectedData.addValue(t);

		return super.visit(node);
	}

	private boolean checkSimilarity(List<CatchClause> catchClause) {
		for (CatchClause cc : catchClause) {
			for (CatchClause cn : catchClause) {
				// To ignore the same catch in loops
				if (!cc.equals(cn)) {
					if (this.similarity.checkSimilarity(cc.getBody(), cn.getBody())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	class NumberOfStatementVisitor extends ASTVisitor {
		int numberOfStatements = 0;

		@Override
		public void postVisit(ASTNode node) {
			if((node instanceof Statement)) 
				numberOfStatements++;
			
			super.postVisit(node);
		}
	}

}
