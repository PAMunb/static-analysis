package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import br.unb.cic.sa.model.Lock;
import br.unb.cic.sa.parser.Parser;

public class LockVisitor extends Visitor<Lock> {

	private boolean declareLock;
	private String type;
	private boolean callLock;
	private boolean releaseLock; 
	
	@Override
	public boolean visit(MethodDeclaration node) {
		if(node.getBody() == null) {
			return true; //do nothing!
		}
		
		Block b = Parser.Instance().parse(node.getBody().toString().toCharArray());
	
		b.accept(new ASTVisitor() {

		@Override
		public boolean visit(VariableDeclarationStatement node) {
				String t = node.getType().toString();
				if(t.equals("Lock") || t.equals("ReentrantLock") || t.equals("ReadLock") || t.equals("WriteLock")){
					declareLock = true;
					type = node.getType().toString();
				}
				return super.visit(node);
			}
			
		});
		
		if(declareLock) {
			Lock lock = new Lock(file, unit.getLineNumber(node.getStartPosition()),
				unit.getLineNumber(node.getStartPosition() + node.getLength()), type);
			
			b.accept(new ASTVisitor() {
				@Override
				public boolean visit(MethodInvocation node) {
					if(node.getName().toString().equals("lock")) {
						callLock = true;
						lock.setCallLock(true);
					}
					
					if(node.getName().toString().equals("unlock")) {
						releaseLock = true;
						lock.setCallUnlock(true);
					}
					return super.visit(node);
				}
			});
			collectedData.addValue(lock);
		}
		
		declareLock = false;
		callLock = false; 
		releaseLock = false;
		type = "-";
		
		return super.visit(node);
	}

	

	
}
