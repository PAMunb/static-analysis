package br.unb.cic.sa.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.TypeParameter;

import br.unb.cic.sa.model.TypeDeclaration;

/**
 * This visitor class collects relevant data about Type Declarations declarations.
 * 
 * @author Thiago Cavalcanti / Vinicius Correa
 */
public class TypeDeclarationVisitor extends Visitor<TypeDeclaration> {

	@Override
	public boolean visit(org.eclipse.jdt.core.dom.TypeDeclaration node) {
		TypeDeclaration t = new TypeDeclaration(this.file, node.getName().toString(), node.getSuperclassType(),
				node.superInterfaceTypes(), unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition() + node.getLength()));

		t.setTypeParameters(node.typeParameters().size());

		List<String> modifiers = new ArrayList<>();
		
		
		for(Object o : node.typeParameters()) {
			TypeParameter tp = (TypeParameter)o;
			modifiers.add(node.typeParameters().toString());
		}
		t.setTypeParameterModifiers(modifiers);
		t.setSuperClass(node.getSuperclassType());
		t.setAnnotations(Annotations(node.modifiers()));
		collectedData.addValue(t);
		
		return super.visit(node);
	}
	
	private String Annotations(List<MarkerAnnotation> list) {
		
		String annotations;
		if(list.toString().contains("@")) annotations = list.toString();
		else annotations = "[]";
		return annotations; 
		
	}
}
