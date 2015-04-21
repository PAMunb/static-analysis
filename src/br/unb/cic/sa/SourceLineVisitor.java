package br.unb.cic.sa;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class SourceLineVisitor extends ASTVisitor {

	private final CompilationUnit compilationUnit;
	private final int startLine;
	private final int endLine;
	
	private ASTNode node = null;

	public SourceLineVisitor(CompilationUnit compilationUnit, int startLine, int endLine){
		super();
		this.compilationUnit = compilationUnit;
		this.startLine = startLine;
		this.endLine = endLine;
	}

	
	@Override 
	public void preVisit(ASTNode node){
		if(this.node == null){
			int lineNumber = compilationUnit.getLineNumber(node.getStartPosition());
			if(lineNumber >= startLine && lineNumber <= endLine){
				this.node = node;
			}
		}
	}
	
	
	public ASTNode getASTNode(){
		return node;
	}
	
	
}

