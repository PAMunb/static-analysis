package br.unb.cic.sa.visitors;

import java.io.File;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

import br.unb.cic.sa.Parser;
import br.unb.cic.sa.model.CollectedData;

public class ScriptingTest {

//	public static final String  PATH = "/home/static-analysis/Documentos" ;
//	ScriptEngineManager mgr;
//	ScriptEngine jsEngine;
//	
//	public void foo() {
//		  mgr = new ScriptEngineManager();
//		  jsEngine = mgr.getEngineByName("JavaScript");
//		  try {
//		    jsEngine.eval("print('Hello, world!')");
//		  } catch (ScriptException ex) {
//		      ex.printStackTrace();
//		  }    		
//	}
//	
//	@Test
//	public void testScriptingVisitor() {
//		CompilationUnit cu = Parser.Instance().parse(new File("src-tests/br/unb/cic/sa/visitors/ScriptingTest.java"), new String[] {PATH + "/static-analysis/lib"}, new String[] {"*.class", "*.jar"});
//		Visitor v = new ScriptingVisitor();
//		v.setUnit(cu);
//		v.setFile("src-tests/br/unb/cic/sa/visitors/ScriptingTest.java");
//		v.setColletion(new CollectedData());
//		cu.accept(v);
//	}
}
