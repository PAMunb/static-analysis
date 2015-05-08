package br.unb.cic.sa.similarity;

import java.util.List;

import org.eclipse.jdt.core.dom.CatchClause;

public class CatchSimilarityInTryBlock {

	private CheckSimilarity checkSimilarity;

	
	public CatchSimilarityInTryBlock(){
		this.checkSimilarity = new CheckSimilarity();
	}
	
	
	public boolean check(List<CatchClause> catchClause){
								
		for(CatchClause cc : catchClause){
			for(CatchClause cn : catchClause){
				//To ignore the same catch in loops
				if (!cc.equals(cn)) {
					if (this.checkSimilarity.match(cc.getBody(), cn.getBody())) {
						return true;
					}
				}
			}
		}
		
		return false;


	}
	
	

//	/**
//	 * 
//	 * @param node, is all code of class
//	 * @param b1, is the string with content of catch clause
//	 */
//	private void getClassName(ASTNode node, int StartPosition, int EndPosition, String b1) {
//
//		ASTParser parser = ASTParser.newParser(AST.JLS4);
//		parser.setSource(node.toString().toCharArray());//change class to string array
//		parser.setKind(ASTParser.K_COMPILATION_UNIT); 
//
//		final CompilationUnit c1 = (CompilationUnit) parser.createAST(null);
//
//
//		List<TypeDeclaration> types1 = c1.types();
//
//		TypeDeclaration typeDec1 = types1.get(0);
//		
//
//		System.out.println("Similarity Catchs in class");
//		System.out.println("StartLine:"+ c1.getLineNumber(StartPosition));
//		System.out.println("EndLine:"+ c1.getLineNumber(StartPosition+EndPosition));
//		
//		System.out.println(c1.getPackage().getName() + "." + typeDec1.getName());
//		System.out.println(b1);
//		System.out.println("--------------------------------------------------------");
//
//	}

}
