package br.unb.cic.sa.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.unb.cic.sa.model.Project;
public class ReadCsv {

	private String pathCsv;
	private List<String> error;

	public ReadCsv(String pathCsv) {
		this.pathCsv = pathCsv;
		this.error = new ArrayList<>();
	}

	public List<String> getError() {
		return error;
	}

	public List<Project> readInput() {
		BufferedReader br = null;
		FileReader fileReader = null;
		List<Project> projects = new ArrayList<Project>();

		try {

			fileReader = new FileReader(pathCsv);
			br = new BufferedReader(fileReader);

			String line = "";
			while ((line = br.readLine()) != null) {
//				ProjectName, Version, Path, Files,Language,Blank,Comment,Code
				String[] lineSplit = line.split(Constants.COMMA_DELIMITER);
				projects.add(new Project(lineSplit[0], lineSplit[1],lineSplit[2], new Integer(lineSplit[3])));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null)
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