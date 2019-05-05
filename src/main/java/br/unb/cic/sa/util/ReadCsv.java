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
		List<Project> projects = new ArrayList<Project>();

		try(BufferedReader br = new BufferedReader(new FileReader(pathCsv))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] lineSplit = line.split(";");
				projects.add(new Project(lineSplit[0], new Integer(lineSplit[1])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projects;
	}

}