package br.unb.cic.sa.visitors;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unb.cic.sa.Parser;
import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Try;

public class TryStatementsTest {

	private Parser parser;
	private CompilationUnit unit;
	private CollectedData collection;
	private IVisitor tsVisitor;

	@Before
	public void Infra() {
		String file = "src-tests/br/unb/cic/sa/infra/TrysInfra.java";
		parser = Parser.Instance();
		unit = parser.parse(new File(file));
		collection = new CollectedData();
		
		tsVisitor.setColletion(collection);
		tsVisitor.setFile(file);
		tsVisitor.setUnit(unit);
	}

	@Before
	public void acceptVisitor() {
		unit.accept((ASTVisitor) tsVisitor);
	}

	@After
	public void tearDown() {
		collection.cleanData();
	}

	@Test
	public void listTrys() {
		assertEquals(3, collection.getTrys().size());
		assertEquals(2, collection.getTryWithSimilartyCatch().size());
		assertEquals(3, collection.getTrys().size());
		assertEquals(2, collection.getTryWithSimilartyCatch().size());
	}
	
	@Test
	public void listTryWithSimilarCatch(){
		List<Try> trys = collection.getTryWithSimilartyCatch();
		assertEquals(2, trys.size());
	}
	

}
