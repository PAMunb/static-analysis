package br.unb.cic.sa.statements;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.unb.cic.sa.model.CollectedData;

public class MethodStatement extends ASTVisitor {

	private String fileName;
	private CollectedData data;
	
	
	public MethodStatement(String fileName){
		this.fileName = fileName;
		this.data = new CollectedData();
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}


	public CollectedData getCollectedData() {
		return data;
	}
	
	
	
	@Override
	public boolean visit(MethodDeclaration node){
//		System.out.println(node.hashCode());
//		this.data.addMethodDeclaration(node);
		return super.visit(node);
	}

	
	
}
