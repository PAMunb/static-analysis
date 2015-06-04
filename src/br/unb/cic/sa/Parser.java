package br.unb.cic.sa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * Singleton Class of parser
 * @author thiago
 *
 */

public class Parser {
	
	private static Parser instance;
	private Parser() {}

	private BufferedReader br;

	
	public static Parser Instance(){
		if(instance == null)
			instance =  new Parser();
		
		return instance;
	}
	
	
	public char[] readFileToString(File file) throws IOException {
		char[] contents = null;
		br = new BufferedReader(new FileReader(file));

		StringBuffer sb = new StringBuffer();
		String line = "";

		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		contents = new char[sb.length()];
		sb.getChars(0, sb.length() - 1, contents, 0);

		return contents;
	}

	public CompilationUnit parse(File file) {

		char[] contents = null;

		try {
			contents = this.readFileToString(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(contents);
	
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		return cu;
	}
	
	public CompilationUnit parse(File file, String[] classpath, String[] sourcepath) {

		char[] contents = null;

		try {
			contents = this.readFileToString(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setResolveBindings(true);
		parser.setEnvironment(classpath, sourcepath, new String[] { "UTF-8" }, true);
		parser.setSource(contents);
	
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		return cu;
	}

}
