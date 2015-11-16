package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.MethodInvocation;

import br.unb.cic.sa.model.MethodCall;

public class MethodCallVisitor extends Visitor<MethodCall> {

	@Override
	public boolean visit(MethodInvocation node) {
		//System.out.println(node.getName().toString());
		if (node.getName().toString().equals("stream")) {
			MethodCall mc = new MethodCall(file, node.getName().toString(), "-",
					unit.getLineNumber(node.getStartPosition()),
					unit.getLineNumber(node.getStartPosition() + node.getLength()));
			collectedData.addValue(mc);
		}
		return true;
	}

}
