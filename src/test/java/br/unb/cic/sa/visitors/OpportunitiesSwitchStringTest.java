package br.unb.cic.sa.visitors;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unb.cic.sa.Parser;
import br.unb.cic.sa.model.CSVData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.model.SwitchStringOpportunities;

public class OpportunitiesSwitchStringTest {

	private Parser parser;
	private CompilationUnit unit;
	private IVisitor<SwitchStringOpportunities> opportunitiesSwitchStringVisitor;

	@Before
	public void Infra() {
		if(opportunitiesSwitchStringVisitor == null) {
			opportunitiesSwitchStringVisitor = new SwitchStringOpportunitiesVisitor();
		}
		
		String file = "src/test/java/br/unb/cic/sa/infra/IfInfra.java";
		parser = Parser.Instance();
		unit = parser.parse(new File(file));
	
		CSVData<SwitchStringOpportunities> data = new CSVData<>();
		data.setProject(new Project("teste", "000", "foo", 0));
		data.setFileName("opportunitiesSwitchString.csv");
		data.setOutDir("out-tests");
		
		opportunitiesSwitchStringVisitor.setUnit(unit);
		opportunitiesSwitchStringVisitor.setFile(file);
		unit.accept((ASTVisitor) opportunitiesSwitchStringVisitor);
	}

	@After
	public void tearDown() {
		opportunitiesSwitchStringVisitor.getCollectedData().clean();
	}
	
	@Test
	public void listIfs() {
		assertEquals(3, opportunitiesSwitchStringVisitor.getCollectedData().size());
		
	}

}
