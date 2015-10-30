package br.unb.cic.sa.visitors;

import java.util.List;

import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.unb.cic.sa.model.AnonymousInnerClass;


/**
 * This visitor class collects relevant data about the use of 
 * Anonymous Inner Classes.
 * 
 * @author rbonifacio
 */
public class AICVisitor extends Visitor<AnonymousInnerClass> {

	static int total = 0;
	static int validos = 0;
	@Override
	public boolean visit(AnonymousClassDeclaration node) {
		List<BodyDeclaration> declarations = node.bodyDeclarations();
		
		boolean criteria[] = new boolean[]{true, true, true, true};
		
		//isInterface. TODO: resolveBinding not correctly solved in our parser.
		criteria[0] = node.resolveBinding() != null ? node.resolveBinding().isInterface() : false;
		
		//singleMethodDeclaration
		if(declarations.size() > 0) {
			for(BodyDeclaration b: declarations) {
				if(!(b instanceof MethodDeclaration)) {
					criteria[1] = false;
					break;
				} 
			}
		}else {
			criteria[1] = false;
		}

		//no reference to this or super
		if(criteria[1]) {
			MethodDeclaration m = (MethodDeclaration)declarations.get(0);
			
			ThisExpressionVisitor v = new ThisExpressionVisitor();
			m.accept(v);
			
			criteria[2] = !v.found();
		}
		else { 
			criteria[2] = false;
		}
		
		AnonymousInnerClass aic = new AnonymousInnerClass(file, unit.getLineNumber(node.getStartPosition()), unit.getLineNumber(node.getStartPosition() + node.getLength()));
		
		collectedData.addValue(aic);
		
		return true;
	}
}
