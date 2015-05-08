package br.unb.cic.sa.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.unb.cic.sa.model.Project;

public class ReadCsv {

	private String pathCsv;
	
	public ReadCsv(String pathCsv){
		this.pathCsv = pathCsv;
	}
	
	public List<Project> readInput(){
		BufferedReader br = null;
		FileReader fileReader = null;
		List<Project> projects = new ArrayList<Project>();
		
		try {
			
			fileReader = new FileReader(pathCsv);
			br = new BufferedReader(fileReader);
			
			String line = "";
			while((line = br.readLine()) != null ){
				String[] lineSplit = line.split(",");
				projects.add(new Project(lineSplit[0], lineSplit[1], lineSplit[2]));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return projects;
		
		
	}
	
}