package br.unb.cic.sa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.util.ReadCsv;
import br.unb.cic.sa.util.WriteCsv;

public class Main {

	private static ApplicationContext ctx;

	public static void main(String[] args) {

		String pathCsv = "input.csv";
		
		//Read inputs in Csv
		ReadCsv rcsv = new ReadCsv(pathCsv);
		//list of all projects contents in csv file
		List<Project> projects = rcsv.readInput();
				
		ctx = new ClassPathXmlApplicationContext("Beans.xml");
		
		ProjectAnalyser pa = ctx.getBean("pa", ProjectAnalyser.class);
		
		for (Project project : projects) {
			//analysis each project
			pa.setProject(project);
		
			try {
				
				CollectedData data = pa.call();
				
				new WriteCsv().writeCsv(data);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
