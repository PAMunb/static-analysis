package br.unb.cic.sa.visitors;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unb.cic.sa.Parser;
import br.unb.cic.sa.model.CollectedData;

public class SwitchStringTest {

	private Parser parser;
	private CompilationUnit unit;
	private CollectedData collection;
	private IVisitor SwitchString;

	@Before
	public void Infra() {
		String file = "src-tests/br/unb/cic/sa/infra/Switch.java";
		parser = Parser.Instance();
		unit = parser.parse(new File(file));
		collection = new CollectedData();
		
		SwitchString.setUnit(unit);
		SwitchString.setFile(file);
		SwitchString.setColletion(collection);
	}

	@Before
	public void acceptVisitor() {
		unit.accept((ASTVisitor) SwitchString);
	}

	@After
	public void tearDown() {
		collection.cleanData();
	}
	
	@Test
	public void ListSwitchs() {
		assertEquals(3, collection.getSwitch().size());
	}
	
	@Test
	public void ListSwitchString(){
		assertEquals(2, collection.getSwitchWithString().size());
	}

}
