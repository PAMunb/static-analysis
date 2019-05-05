package br.unb.cic.sa.visitors;

import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import br.unb.cic.sa.model.CryptographicAPI;

public class CryptographicAPIVisitor extends Visitor<CryptographicAPI>{
	
	@Override
	public boolean visit(ImportDeclaration node) {
		String res = mineAPI(node.getName().toString()); 
		if(! res.equals("None")) {
			collectedData.addValue(new CryptographicAPI(file, res, node.toString()));
			return false;
		}
		return true; 
	}
	
	
	
	@Override
	public boolean visit(VariableDeclarationStatement node) {
		String res = mineAPI(node.getType().toString());
		if(! res.equals("None")) {
			collectedData.addValue(new CryptographicAPI(file, res, node.toString().replace(";", "")));
			return false;
		}
		return true; 
	}



	private String mineAPI(String s) {
		if(s.contains("javax.crypto") || s.contains("java.security")) {
			return "JCA/JCE";
		}
		else if(s.contains("com.google.crypto.tink")) {
			return "Google Tink";
		}
		else if(s.contains("org.bouncycastle.crypto")) {
			return "BouncyCastle";
		}
		else if(s.contains("org.keyczar")) {
			return "Keyczar";
		}
		else if(s.contains("org.jasypt")) {
			return "Jasypt";
		}
		else if(s.contains("gnu.crypto")) {
			return "Gnu Crypto";
		}
		else if(s.contains("spongycastle")) {
			return "SpongyCastle";
		}
		else if(s.contains("org.apache.commons.crypto")) {
			return "Apache Commons Crypto";
		}
		return "None";
	}
}
