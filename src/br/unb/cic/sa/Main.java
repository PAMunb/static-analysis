package br.unb.cic.sa;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.model.CatchSimilarityInTryBlock;
import br.unb.cic.sa.model.VarArgsInMethod;
import br.unb.cic.sa.util.Constants;

public class Main {
	
	static CompilationUnit cu;

	public static void main(String[] args) {

//		String pathProject = "/home/thiago/git/static-analysis/src";
//		String pathProject = "/home/thiago/ProjetosUnb/MMAndroid/src";
		String pathProject = "/home/thiago/workspaceOld/Faces/src/br/com/thiago/servlet";
		Project project = new Project("MMAndroid", "1.0.01", pathProject);

		ProjectAnalyser pa = new ProjectAnalyser(project);
		CollectedData collectedData = new CollectedData();

		try {
			collectedData = pa.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		CatchSimilarityInTryBlock cs = new CatchSimilarityInTryBlock();
		cs.check(collectedData.getTryStatement());
		
		VarArgsInMethod vargs = new VarArgsInMethod();
		vargs.checkVarArgs(collectedData.getMethodDeclaration());
		
		System.out.println(pa.getProject().getProjectName());
		
		System.out.println(Constants.NUMBER_TOTAL_OF_STATEMENTS+collectedData.getNumberOfStatements());
		System.out.println(Constants.NUMBER_OF_TRYSTATEMENTS+collectedData.getNumberOfTryStatements());
		System.out.println(Constants.NUMBER_OF_METHOD_DECLARATION+collectedData.getNumberOfMethodDeclaritionStatements());
		
		

	}

}
