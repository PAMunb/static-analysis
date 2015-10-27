//<<<<<<< HEAD:src/br/unb/cic/sa/visitors/IfVisitor.java
////package br.unb.cic.sa.visitors;
////
////import org.eclipse.jdt.core.dom.CompilationUnit;
////import org.eclipse.jdt.core.dom.Expression;
////import org.eclipse.jdt.core.dom.IfStatement;
////import org.eclipse.jdt.core.dom.InfixExpression;
////import org.eclipse.jdt.core.dom.StringLiteral;
////
////import br.unb.cic.sa.model.CollectedData;
////import br.unb.cic.sa.model.If;
////
////
////public class IfVisitor extends Visitor{
////	
////	InfixExpression infix;
//////	PrefixExpression prefix;
////	
////	
////	public IfVisitor(CompilationUnit unit, String file, CollectedData collection) {
////		super(unit, file, collection);
////		
////		
////	}
////	
////
////	@Override
////	public boolean visit(IfStatement node){
////
////		infix = null;
//////		prefix = null;
////		
////		Expression expression = node.getExpression();
////				
////		if(expression instanceof InfixExpression){
////			infix = (InfixExpression) node.getExpression();
////			
////			ProcessInfix(infix, node);
////		}
////
////		return super.visit(node);
////	}
////	
////	
////	public void ProcessInfix(InfixExpression infix, IfStatement node){
////		
////		if(
////			(infix.getLeftOperand() instanceof StringLiteral) ||
////			(infix.getRightOperand() instanceof StringLiteral)){
//////			System.out.println("StringLiteral");
//////			System.out.println("In "+this.file + " Line: "+ unit
//////					.getLineNumber(node.getStartPosition()));
////			
////			System.out.println("## "+infix.getLeftOperand()+" "+infix.getRightOperand());
////			System.out.println();
////
////			
////			this.collection.addIfString(new If(this.file,
////					unit.getLineNumber(node.getStartPosition()),
////					unit.getLineNumber(node.getStartPosition()+node.getLength())));
////		}
////		
////	}
////	
////	
////	/**
////	 * ---- Ignore at the moment ----
////	 * 
////	 * PrefixExpression Model 
////	 * !checkVersion(jvmVersion,args)
////	 * !extractor.supportsOperation(referenceDialect)
////	 * !nullable
////	 */
//////	public void ProcessPrefix(PrefixExpression prefix){
//////		
//////		System.out.println("Prefix " + prefix.getOperand());
//////		if((prefix.getOperand() instanceof StringLiteral) || (prefix.getRightOperand() instanceof StringLiteral)){
//////			System.out.prinln("StringLiteral");
//////		}
//////	}
////	
////}
//=======
//package br.unb.cic.sa.visitors;
//
//import org.eclipse.jdt.core.dom.CompilationUnit;
//import org.eclipse.jdt.core.dom.Expression;
//import org.eclipse.jdt.core.dom.IfStatement;
//import org.eclipse.jdt.core.dom.InfixExpression;
//import org.eclipse.jdt.core.dom.StringLiteral;
//
//import br.unb.cic.sa.model.CollectedData;
//
//public class IfVisitor extends Visitor {
//	InfixExpression infix;
////	PrefixExpression prefix;
//	
//	
//	public IfVisitor(CompilationUnit unit, String file, CollectedData collection) {
//		super(unit, file, collection);
//	}
//	
//
//	@Override
//	public boolean visit(IfStatement node) {
//
//		node.structuralPropertiesForType();
//		Expression e = node.getExpression();
//
//		node.getElseStatement().getNodeType();
//		node.getThenStatement();
//		System.out.println("Expression:" + node.getExpression());
//
//		InfixExpression infix = null;
//		
//		Expression expression = node.getExpression();
//				
//		if(expression instanceof InfixExpression){
//			infix = (InfixExpression) node.getExpression();
//			
//			ProcessInfix(infix, node);
//		}
//
//		return super.visit(node);
//	}
//	
//	
//	public void ProcessInfix(InfixExpression infix, IfStatement node){
//		if(
//			(infix.getLeftOperand() instanceof StringLiteral) ||
//			(infix.getRightOperand() instanceof StringLiteral)){
////			System.out.println("StringLiteral");
////			System.out.println("In "+this.file + " Line: "+ unit
////					.getLineNumber(node.getStartPosition()));
//			
//			System.out.println("## "+infix.getLeftOperand()+" "+infix.getRightOperand());
//			System.out.println();
//
//			
////			this.collection.addIfString(new If(this.file,
////					unit.getLineNumber(node.getStartPosition()),
////					unit.getLineNumber(node.getStartPosition()+node.getLength())));
//		}
//		
//	}
//	
//}
//>>>>>>> de1c6d26f66eaa0a06a957427317a5d281c4ca3f:src/main/java/br/unb/cic/sa/visitors/IfVisitor.java
