package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.MethodInvocation;

import br.unb.cic.sa.model.ScriptingEngineCall;


public class ScriptingVisitor extends Visitor<ScriptingEngineCall> {

//	@Override
//	public boolean visit(FieldDeclaration node) {
//		System.out.println(node.getType());
//		return super.visit(node);
//	}

	@Override
	public boolean visit(MethodInvocation node) {
		String method = node.getName().toString();
		if(method.equals("getEngineByName")) {
			if(node.arguments().size() == 1) {
				ScriptingEngineCall call = new ScriptingEngineCall(file, method, 0, 0);
				collectedData.addValue(call);
			}
		}
		else if(method.equals("eval")) {
			ScriptingEngineCall call = new ScriptingEngineCall(file, method, 0, 0);
			collectedData.addValue(call);
		}
		
		return super.visit(node);
	}

	

	
}
