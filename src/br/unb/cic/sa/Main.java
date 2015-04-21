package br.unb.cic.sa;

import org.eclipse.jdt.core.dom.CompilationUnit;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.model.CatchSimilarity;

public class Main {
	
	static CompilationUnit cu;

	public static void main(String[] args) {

		String pathProject = "/home/thiago/ProjetosUnb/MMAndroid/src";
//		String pathProject = "/home/thiago/workspaceOld/Faces/src/br/com/thiago/servlet";
		Project project = new Project("MMAndroid", "1.0.01", pathProject);

		ProjectAnalyser pa = new ProjectAnalyser(project);
		CollectedData collectedData = new CollectedData();

		try {
			collectedData = pa.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CatchSimilarity threatCatchSimilarity = new CatchSimilarity(collectedData);
		threatCatchSimilarity.check();
		
		
		System.out.println(pa.getProject().getProjectName());
		System.out.println("N° TryStatements: "
				+ collectedData.getTryStatement().size());
		System.out.println("N° Statements: "
				+ collectedData.getNumberOfStatements());

	}

}
