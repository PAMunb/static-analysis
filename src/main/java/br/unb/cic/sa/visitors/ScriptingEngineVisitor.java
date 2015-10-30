package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.MethodInvocation;

import br.unb.cic.sa.model.ScriptingEngineCall;


/**
 * This visitor class collects relevant data about the use of the ScriptEngine
 * API.
 * 
 * @author Rodrigo Bonifacio
 */
public class ScriptingEngineVisitor extends Visitor<ScriptingEngineCall> {

	@Override
	public boolean visit(MethodInvocation node) {
		String method = node.getName().toString();
		if(method.equals("getEngineByName")) {
			if(node.arguments().size() == 1) {
				ScriptingEngineCall call = createScriptEngine(node, method);
				collectedData.addValue(call);
			}
		}
		else if(method.equals("eval")) {
			ScriptingEngineCall call = createScriptEngine(node, method);
			collectedData.addValue(call);
		}
		
		return super.visit(node);
	}

	private ScriptingEngineCall createScriptEngine(MethodInvocation node, String method) {
		return new ScriptingEngineCall(file, unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition() + node.getLength()), method);
	}
	
}
