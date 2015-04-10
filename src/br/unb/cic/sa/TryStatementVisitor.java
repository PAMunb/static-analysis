package br.unb.cic.sa;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TryStatement;

import br.unb.cic.sa.model.CollectedData;

public class TryStatementVisitor extends ASTVisitor {
	
	private String fileName;
	private CollectedData data;
	
	public TryStatementVisitor(String fileName) {
		this.fileName = fileName;
		this.data = new CollectedData();
	}

	
	public CollectedData getCollectedData(){
		return this.data;
	}
	

	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	@Override
	public boolean visit(TryStatement node){
		this.data.addTryStatement(node);
		return super.visit(node);
	}

	

}
