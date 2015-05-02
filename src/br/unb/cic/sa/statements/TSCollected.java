package br.unb.cic.sa.statements;

import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TryStatement;

/*
 * Class response to keep sync between all TryStatemens found and CompilationUnit in the same File
 */
public class TSCollected {
	
	private List<TryStatement> listTrystatement;
	private CompilationUnit compilation;
	
	public TSCollected(List<TryStatement> lts, CompilationUnit c){
		this.listTrystatement = lts;
		this.compilation = c;
	}

	public List<TryStatement> getListTrystatement() {
		return listTrystatement;
	}

	public void setListTrystatement(List<TryStatement> listTrystatement) {
		this.listTrystatement = listTrystatement;
	}

	public CompilationUnit getCompilationUnit() {
		return compilation;
	}

	public void setCompilationUnit(CompilationUnit compilation) {
		this.compilation = compilation;
	}
	
}
