package br.unb.cic.sa;

import java.util.List;

import org.springframework.context.ApplicationContext;

import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.util.CDI;
import br.unb.cic.sa.util.ReadCsv;

public class Main {
	 
	public static void main(String[] args) {
		
		try{
			
			String command = "python ClearOutput.py ";
			Process p = Runtime.getRuntime().exec(command, null);

	        p.waitFor();
			p.destroy();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		
		
		String pathCsv = "inputCassandra.csv";
		ReadCsv rcsv = new ReadCsv(pathCsv);

		List<String> errors = rcsv.getError();
		errors.forEach(e -> System.out.println("Error in "+e));
 
		ApplicationContext ctx = CDI.Instance().getContextCdi(); 
		
		ProjectAnalyser pa = ctx.getBean("pa", ProjectAnalyser.class);
		
		List<Project> projects = rcsv.readInput();
		
		try {		
			projects.stream().forEach(project -> pa.analyse(project));
		}catch(Exception t) {
			t.printStackTrace();
		}
		
//		Count total of lines of code in each project
		int totalLoc = projects.parallelStream().mapToInt(Project::getLoc).sum();
		
		System.out.println("TotalLoc: "+ totalLoc);
	}
}
