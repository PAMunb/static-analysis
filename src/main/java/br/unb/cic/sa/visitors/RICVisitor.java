package br.unb.cic.sa.visitors;

import java.lang.reflect.Modifier;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import br.unb.cic.sa.Parser;
import br.unb.cic.sa.model.OpportunitiesLambdaExp;

public class RICVisitor extends Visitor {

	static int total = 0;
	static int validos = 0;
	static int nReturn = 0;
	static int nContinue = 0;
	static int nBreak = 0;
	static int nThrows = 0;
	static int nExtReference = 0;
	
	
	@Override
	public boolean visit(EnhancedForStatement node) {
		
		OpportunitiesLambdaExp o = new OpportunitiesLambdaExp(file, unit
				.getLineNumber(node.getStartPosition()), unit
				.getLineNumber(node.getStartPosition()
						+ node.getLength()));
		
		collection.addEnhancedFor(o);
		
		String body = node.getBody().toString();
		
		if (criteria2(body) && criteria3(body) && criteria4(body)
				&& criteria5(body) && criteria6(body)){
			
			validos++;

			collection.addOpportunitiesLambdaExp(o);

		}
		
	
		return true;
	}

	
	
	/*
	 * Check if param is present in any if on code
	 */
	public boolean criteria1(Expression exp){
	
		 System.out.println(exp.getClass().getClasses());
		 
		 return false;
		
	}
	
	
	
	/* 
	 *Check if in body not contain any throws
	 */
	public boolean criteria2(String body){
		nThrows = 0;
		
		char[]contents = body.toCharArray();
		
		Block b = Parser.Instance().parse(contents);
		
		b.accept(new ASTVisitor() {
			@Override
			public boolean visit(ThrowStatement ts){
				nThrows++;
				return true;				
			}
		});
		
		
		if(nThrows > 0){
			return false;
		}
		
		return true;
	}
	
	
	
	/* 
	 *Check if in body do not has more than one external reference
	 */
	public boolean criteria3(String body){
		nExtReference = 0;
		
		char[]contents = body.toCharArray();
		
		Block b = Parser.Instance().parse(contents);
		
		b.accept(new ASTVisitor() {
			@Override
			public boolean visit(VariableDeclarationStatement s){
				
//				System.out.println("S-> "+s);
//				System.out.println(Modifier.isFinal(s.getModifiers()));
				
				if(Modifier.isFinal(s.getModifiers()) == false){
					nExtReference++;
				}
				
				return true;				
			}
		});
		
		
		if(nExtReference > 1){
			return false;
		}
		
		return true;
	}
	
	
	/*
	 *Check if in body not contain any break
	 */
	public boolean criteria4(String body){
		nBreak = 0;
		
		char[]contents = body.toCharArray();
		
		Block b = Parser.Instance().parse(contents);
		
		b.accept(new ASTVisitor() {
			@Override
			public boolean visit(BreakStatement bk){
				nBreak++;
				return true;				
			}
			
		});
		
		
		if(nBreak > 1){
			return false;
		}
		
		return true;
		
	}
	
	
	/*
	 *Check if in body not contain more than 1 return statement
	 */
	public boolean criteria5(String body){
		nReturn = 0;
		
		char[]contents = body.toCharArray();
		
		Block b = Parser.Instance().parse(contents);
		
		b.accept(new ASTVisitor() {
			@Override
			public boolean visit(ReturnStatement r){
				nReturn++;
				return true;
			}
		});
		
		
		if(nReturn > 1){
			return false;
		}
		
		return true;
		
	}

	
	/*
	 *Check if in body not exists continue statement 
	 */
	public boolean criteria6(String body){
		nContinue = 0;
		
		char[]contents = body.toCharArray();
		
		Block b = Parser.Instance().parse(contents);
		
		b.accept(new ASTVisitor() {
			
			@Override
			public boolean visit(ContinueStatement c){
				nContinue++;
				return true;
			}
		});
		
		if(nContinue == 0){
			return true;
		}
		
		return false;
	}
	

	
	
}
