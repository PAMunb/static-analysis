//package br.unb.cic.sa.visitors;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.File;
//
//import org.eclipse.jdt.core.dom.ASTVisitor;
//import org.eclipse.jdt.core.dom.CompilationUnit;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import br.unb.cic.sa.Parser;
//import br.unb.cic.sa.model.CollectedData;
//
//public class IfTest {
//
//	private Parser parser;
//	private CompilationUnit unit;
//	private CollectedData collection;
//	private IVisitor iFVisitor;
//
//	@Before
//	public void Infra() {
//		String file = "src-tests/br/unb/cic/sa/infra/IfInfra.java";
//		parser = Parser.Instance();
//		unit = parser.parse(new File(file));
//		collection = new CollectedData();
//		
//		iFVisitor = new IfVisitor(unit, file, collection);
//	}
//
//	@Before
//	public void acceptVisitor() {
//		unit.accept((ASTVisitor) iFVisitor);
//	}
//
//	@After
//	public void tearDown() {
//		collection.cleanData();
//	}
//	
//	@Test
//	public void listIfs() {
//		assertEquals(3, collection.getIfString().size());
//		
//	}
//
//}
