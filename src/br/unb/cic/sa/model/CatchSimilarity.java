//package br.unb.cic.sa.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.eclipse.jdt.core.dom.AST;
//import org.eclipse.jdt.core.dom.ASTNode;
//import org.eclipse.jdt.core.dom.ASTParser;
//import org.eclipse.jdt.core.dom.CatchClause;
//import org.eclipse.jdt.core.dom.CompilationUnit;
//import org.eclipse.jdt.core.dom.TryStatement;
//import org.eclipse.jdt.core.dom.TypeDeclaration;
//
//import br.unb.cic.sa.similarity.CheckSimilarity;
//import br.unb.cic.sa.statements.TSCollected;
//
//public class CatchSimilarity {
//
//	private List<TSCollected> tryStatements;
//	private List<CatchClause> catchClause;
//	private CheckSimilarity checkSimilarity;
//
//	public CatchSimilarity(CollectedData collectedData) {
//		
//		//list of all tryblock foundin a project
//		this.tryStatements = collectedData.getTryStatement();
//		
//		//all catchclasuse in all project
//		this.catchClause = populeteCatClause(this.tryStatements);
//		
//		//class to check similarity using ASTMatch
//		this.checkSimilarity = new CheckSimilarity();
//		
//	}
//	
//	public void check(){
//		for (CatchClause c : this.catchClause) {
//			for (CatchClause cn : this.catchClause) {
//				//To ignore the same catch in loops
//				if (!c.equals(cn)) {
//					boolean equal = this.checkSimilarity.match(c, cn);
//					if (equal) {
//						//method to print name of constructor class and the content
//						this.getClassName(c.getRoot(), cn.getRoot(), c.toString(), cn.toString());
//
//					}
//				}
//
//			}
//
//		}
//
//	}
//
//	
//	/**
//	 * 
//	 * @param node, is all code of class
//	 * @param node2
//	 * @param b1, is the string with content of catch clause
//	 * @param b2
//	 */
//	private void getClassName(ASTNode node, ASTNode node2, String b1, String b2) {
//
//		ASTParser parser = ASTParser.newParser(AST.JLS4);
//		parser.setSource(node.toString().toCharArray());//change class to string array
//		parser.setKind(ASTParser.K_COMPILATION_UNIT); 
//
//		final CompilationUnit c1 = (CompilationUnit) parser.createAST(null);
//
//		parser.setSource(node2.toString().toCharArray());
//		parser.setKind(ASTParser.K_COMPILATION_UNIT);
//
//		final CompilationUnit c2 = (CompilationUnit) parser.createAST(null);
//	
//		List<TypeDeclaration> types1 = c1.types();
//		List<TypeDeclaration> types2 = c2.types();
//
//		TypeDeclaration typeDec1 = types1.get(0);
//		TypeDeclaration typeDec2 = types2.get(0);
//		
//
//		System.out.println("Similarity Catchs in class:");
//		System.out.println(c1.getPackage().getName() + "." + typeDec1.getName());
//		System.out.println(c2.getPackage().getName() + "." + typeDec2.getName());
//		System.out.println(b1);
//		System.out.println(b2);
//		System.out.println("--------------------------------------------------------");
//
//	}
//
//	
//	//Generate a list with all CatchClause in a try block 
//	@SuppressWarnings("unchecked")
//	private List<CatchClause> populeteCatClause(List<TryStatement> tryStatements) {
//		List<CatchClause> cc = new ArrayList<CatchClause>();
//		for (TryStatement t : tryStatements) {
//			cc.addAll(t.catchClauses());
//		}
//		return cc;
//	}
//
//}
