package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TryStatement;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Try;
import br.unb.cic.sa.similarity.CatchSimilarityInTryBlock;

public class TryStatementVisitor extends ASTVisitor {

	private CompilationUnit unit;

	private CollectedData colletion;
	private String file;
	private CatchSimilarityInTryBlock check;

	public TryStatementVisitor(CompilationUnit unit, String file,
			CollectedData collection) {
		this.unit = unit;
		this.file = file;
		this.colletion = collection;

		this.check = new CatchSimilarityInTryBlock();
	}


	@Override
	public boolean visit(TryStatement node) {

		//add all try block to collection
		this.colletion.addTry(new Try(this.file, unit
				.getLineNumber(node.getStartPosition()), unit
				.getLineNumber(node.getStartPosition()
						+ node.getLength())));
		
		
		
		// add try block in collection only if has similars catchs
		if (node.catchClauses().size() > 1) {

			if (this.check.check(node.catchClauses())){

				this.colletion.addTryWithSimilartyCatch(new Try(this.file, unit
						.getLineNumber(node.getStartPosition()), unit
						.getLineNumber(node.getStartPosition()
								+ node.getLength())));
			}

		}

		return super.visit(node);
	}

}
