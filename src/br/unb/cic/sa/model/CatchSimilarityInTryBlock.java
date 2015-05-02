package br.unb.cic.sa.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import br.unb.cic.sa.similarity.CheckSimilarity;
import br.unb.cic.sa.statements.TSCollected;

public class CatchSimilarityInTryBlock {

	private CheckSimilarity checkSimilarity;

	
	public CatchSimilarityInTryBlock(){
		this.checkSimilarity = new CheckSimilarity();
	}
	
	
	public void check(List<TSCollected> ltsCollected){
		
		Map<TryStatement, CompilationUnit> withSimilarityCatch = new HashMap<TryStatement, CompilationUnit>();
		
		for(TSCollected tsCollected : ltsCollected){
			CompilationUnit compilation = tsCollected.getCompilationUnit();
			List<TryStatement> lts = tsCollected.getListTrystatement();
		
			for(TryStatement ts : lts){
				
				List<CatchClause> catchClause = this.listCathInTryBlock(ts);
	
				for(CatchClause cc : catchClause){
					for(CatchClause cn : catchClause){
						//To ignore the same catch in loops
						if (!cc.equals(cn)) {
							if (this.checkSimilarity.match(cc.getBody(), cn.getBody())) {
								withSimilarityCatch.put(ts, compilation);
							}
						}
					}
				}
			}
		}

	
		for(Entry<TryStatement, CompilationUnit> entry: withSimilarityCatch.entrySet()){
			TryStatement ts = entry.getKey();
			CompilationUnit compilation = entry.getValue();
			
			System.out.println(compilation.getPackage().toString()+
					"Class: "+((TypeDeclaration)compilation.types().get(0)).getName());
			System.out.println("StartLine: "+compilation.getLineNumber(ts.getStartPosition()));
			System.out.println("EndLine: "+ compilation.getLineNumber(ts.getStartPosition() + ts.getLength())+"\n");
		}

		
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	private List<CatchClause> listCathInTryBlock(TryStatement tryStatement){
		return tryStatement.catchClauses();
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
