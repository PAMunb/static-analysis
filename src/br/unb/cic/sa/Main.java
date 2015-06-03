package br.unb.cic.sa;

import java.util.List;

import org.springframework.context.ApplicationContext;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.util.CDI;
import br.unb.cic.sa.util.ReadCsv;
import br.unb.cic.sa.util.WriteCsv;

public class Main {

	

	public static void main(String[] args) {
		
		String pathCsv = "input.csv";
		ReadCsv rcsv = new ReadCsv(pathCsv);
		WriteCsv writer = new WriteCsv();
		
		List<String> errors = rcsv.getError();
		errors.forEach(e -> System.out.println("Error in "+e));
						
		ApplicationContext ctx = CDI.Instance().getContextCdi(); 
		
		ProjectAnalyser pa = ctx.getBean("pa", ProjectAnalyser.class);
		
		List<Project> projects = rcsv.readInput();
		
		projects.forEach(project -> execute(pa, project, writer)); 
			
		writer.close();
		
	}

	private static void execute(ProjectAnalyser pa, Project project, WriteCsv writer){
//		analysis each project
		pa.setProject(project);

		try {
			CollectedData data = pa.call();
			writer.writeCsv(data);
			data.cleanData();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
