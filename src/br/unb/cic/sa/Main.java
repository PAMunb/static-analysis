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
		
		
//		final String projectsDir = System.getenv("PROJECTS");
//		System.out.println(projectsDir);
//		try{
//			
//			String command = "python Cloc.py "+ projectsDir;
//			Process p = Runtime.getRuntime().exec(command, null);
//
//	        p.waitFor();
//			p.destroy();
//			
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//			e.getStackTrace();
//		}

		String pathCsv = "input.csv";
		ReadCsv rcsv = new ReadCsv(pathCsv);
		WriteCsv writer = new WriteCsv();


		List<String> errors = rcsv.getError();
		errors.forEach(e -> System.out.println("Error in "+e));
 
		ApplicationContext ctx = CDI.Instance().getContextCdi(); 
		
		ProjectAnalyser pa = ctx.getBean("pa", ProjectAnalyser.class);
		
		List<Project> projects = rcsv.readInput();
		
		projects.stream().forEach(project -> execute(pa, project, writer)); 
		
//		Count total of lines of code in each project
		int totalLoc = projects.parallelStream().mapToInt(Project::getLoc).sum();
		
		writer.close();
		
		System.out.println("TotalLoc: "+ totalLoc);
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
