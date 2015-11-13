package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.MarkerAnnotation;

public class ModifyHandler {

	public static String listAnnotations(List<IExtendedModifier> modifiers) {
		List<String> annotations = new ArrayList<>();
		
		for(IExtendedModifier a: modifiers) {
			if(a.isAnnotation()) {
				annotations.add(((Annotation)a).getTypeName().toString());
			}
		}
		return annotations.toString(); 
	}
	
	public static boolean isSynchronized(List<MarkerAnnotation> list){
		return list.toString().contains("synchronized");
	}
}
