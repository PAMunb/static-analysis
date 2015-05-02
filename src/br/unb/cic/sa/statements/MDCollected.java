package br.unb.cic.sa.statements;

import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

/*
 * Class response to keep sync between all Methods found and CompilationUnit in the same File
 */
public class MDCollected {
	private List<MethodDeclaration> listMethodDeclaration;
	private CompilationUnit compilationUnit;
	
	
	public MDCollected(List<MethodDeclaration>lmd, CompilationUnit c){
		this.listMethodDeclaration = lmd;
		this.compilationUnit = c;
	}


	public List<MethodDeclaration> getListMethodDeclaration() {
		return listMethodDeclaration;
	}


	public void setListMethodDeclaration(
			List<MethodDeclaration> listMethodDeclaration) {
		this.listMethodDeclaration = listMethodDeclaration;
	}


	public CompilationUnit getCompilationUnit() {
		return compilationUnit;
	}


	public void setCompilationUnit(CompilationUnit compilationUnit) {
		this.compilationUnit = compilationUnit;
	}
	
	
}
