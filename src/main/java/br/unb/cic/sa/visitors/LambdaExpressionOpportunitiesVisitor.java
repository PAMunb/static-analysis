package br.unb.cic.sa.visitors;

import java.lang.reflect.Modifier;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import br.unb.cic.sa.Parser;
import br.unb.cic.sa.model.LambdaExpOpportunities;

/**
 * This visitor class collects relevant data about the opportunities for using Lambda
 * Expressions.
 * 
 * 
 * @author Thiago Cavalcanti / Vinicius Correa / Daniella Angelos
 */
public class LambdaExpressionOpportunitiesVisitor extends Visitor<LambdaExpOpportunities> {

	static int total = 0;
	static int validos = 0;
	static int nReturn = 0;
	static int nContinue = 0;
	static int nBreak = 0;
	static int nThrows = 0;
	static int nExtReference = 0;
	static int totalFilter = 0;
	static boolean filter = false;
	static boolean hasThrow = false;
	static boolean hasExternalReference = false;
	static boolean hasBreak = false;
	static boolean hasReturn = false;
	static boolean hasContinue = false;

	
	@Override
	public boolean visit(EnhancedForStatement node) {
		
//		boolean criteria[] = new boolean[]{true, true};
		
		String body = node.getBody().toString();
		
		LambdaExpOpportunities o = new LambdaExpOpportunities(file, unit
				.getLineNumber(node.getStartPosition()), unit
				.getLineNumber(node.getStartPosition()
						+ node.getLength()));
				
		
//		if (criteria2(body) && criteria3(body) && criteria4(body) && criteria5(body) && criteria6(body)) {
			
			SingleVariableDeclaration par = node.getParameter();

			filter = this.detectFilter(body, par);
			hasThrow = criteria2(body);
			hasExternalReference = criteria3(body);
			hasBreak = criteria4(body);
			hasReturn = criteria5(body);
			hasContinue = criteria6(body);
			
			o.setFilter(filter);
			o.setHasThrow(hasThrow);
			o.setHasExternalReference(hasExternalReference);
			o.setHasBreak(hasBreak);
			o.setHasReturn(hasReturn);
			o.setHasContinue(hasContinue);
			
			collectedData.addValue(o);

			
//		}
		
		
		return true;
		
	}
	
	
	@Override
	public boolean visit(ImportDeclaration node) {
		
//		System.out.println(node.getName());
		
		
		return true;
	}
	
	
	/*
	 * Check if in body not contain any throws
	 */
	public boolean criteria2(String body) {
		nThrows = 0;

		char[] contents = body.toCharArray();

		Block b = Parser.Instance().parse(contents);

		b.accept(new ASTVisitor() {
			@Override
			public boolean visit(ThrowStatement ts) {
				nThrows++;
				return true;
			}
		});

		if (nThrows > 0) {
			return false;
		}

		return true;
	}

	/*
	 * Check if in body do not has more than one external reference
	 */
	public boolean criteria3(String body) {
		nExtReference = 0;

		char[] contents = body.toCharArray();

		Block b = Parser.Instance().parse(contents);

		b.accept(new ASTVisitor() {
			@Override
			public boolean visit(VariableDeclarationStatement s) {

				if (Modifier.isFinal(s.getModifiers()) == false) {
					nExtReference++;
				}

				return true;
			}
		});

		if (nExtReference > 1) {
			return false;
		}

		return true;
	}

	/*
	 * Check if in body not contain any break
	 */
	public boolean criteria4(String body) {
		nBreak = 0;

		char[] contents = body.toCharArray();

		Block b = Parser.Instance().parse(contents);

		b.accept(new ASTVisitor() {
			@Override
			public boolean visit(BreakStatement bk) {
				nBreak++;
				return true;
			}

		});

		if (nBreak > 1) {
			return false;
		}

		return true;

	}

	/*
	 * Check if in body not contain more than 1 return statement
	 */
	public boolean criteria5(String body) {
		nReturn = 0;

		char[] contents = body.toCharArray();

		Block b = Parser.Instance().parse(contents);

		b.accept(new ASTVisitor() {
			@Override
			public boolean visit(ReturnStatement r) {
				nReturn++;
				return true;
			}
		});

		if (nReturn > 1) {
			return false;
		}

		return true;

	}

	/*
	 * Check if in body not exists continue statement
	 */
	public boolean criteria6(String body) {
		nContinue = 0;

		char[] contents = body.toCharArray();

		Block b = Parser.Instance().parse(contents);

		b.accept(new ASTVisitor() {

			@Override
			public boolean visit(ContinueStatement c) {
				nContinue++;
				return true;
			}
		});

		if (nContinue == 0) {
			return true;
		}

		return false;
	}


	
	public boolean detectFilter(String body, SingleVariableDeclaration par){
		char[] contents = body.toCharArray();

		filter = false;
		
		Block b = Parser.Instance().parse(contents);

		b.accept(new ASTVisitor() {

			public boolean visit(IfStatement m){
				
				Expression e = m.getExpression();
				
//				System.out.println(body+"\n");
//				System.out.println("Par: "+par+"\n");
				
				if(e instanceof InfixExpression){
					InfixExpression infix = (InfixExpression)e;
					
//					System.out.println("Infix: "+infix.getLeftOperand()+"\n");
					
					if(infix.getLeftOperand().toString().contains(par.getName().toString())){
						filter = true;
					}
					
				}
				
				return true;
			}
		});
		
		return filter;
	}


}
