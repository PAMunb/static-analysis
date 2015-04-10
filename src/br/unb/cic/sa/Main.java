package br.unb.cic.sa;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;

public class Main{

	
	public static void main(String[] args) {

		String pathProject = "/home/thiago/ProjetosUnb/MMAndroid/src";
		
		Project project = new Project("LBS", "1.0.01", pathProject);
		
		ProjectAnalyser pa = new ProjectAnalyser(project);
		CollectedData collectedData = new CollectedData();
		
		try {
			collectedData = pa.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pa.getProject().getProjectName());
		System.out.println("N° TryStatements: "+collectedData.getTryStatement().size());
		System.out.println("N° Statements: "+collectedData.getNumberOfStatements());
		

	}
}
