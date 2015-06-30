package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TryStatement;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Try;
import br.unb.cic.sa.similarity.CatchSimilarityInTryBlock;

public class TryStatementVisitor extends Visitor implements IVisitor{


	
	private CatchSimilarityInTryBlock check;
	
	public TryStatementVisitor(){
		super();
		this.check = new CatchSimilarityInTryBlock();
	}
	
	
	public TryStatementVisitor(CompilationUnit unit, String file, CollectedData collection) {
		super(unit, file, collection);
		this.check = new CatchSimilarityInTryBlock();
	}
	

	@Override
	public void setUnit(CompilationUnit unit) {
		this.unit = unit;
	}
	@Override
	public void setColletion(CollectedData colletion) {
		this.collection = colletion;
	}
	
	@Override
	public void setFile(String file) {
		this.file = file;
	}


	@Override
	public boolean visit(TryStatement node) {
		//add all try block to collection
		
		Try t = new Try(this.file, unit
				.getLineNumber(node.getStartPosition()), unit
				.getLineNumber(node.getStartPosition()
						+ node.getLength()));
		
		this.collection.addTry(t);
		
		if(node.resources().size()>0){
			this.collection.addTryResource(t);
		}
		
		// add try block in collection only if has similars catchs
		if (node.catchClauses().size() > 1) {

			if (this.check.check(node.catchClauses())){
				this.collection.addTryWithSimilartyCatch(t);
			}

		}

		return super.visit(node);
	}

}
