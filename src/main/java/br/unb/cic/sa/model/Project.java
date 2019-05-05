package br.unb.cic.sa.model;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class represents an abstraction over 
 * Java Projects
 * 
 * @author Thiago Cavalcanti / Vinicius Correa
 */
public class Project {
	private String projectName;
	private int loc;

	public Project(String projectName, int loc){
		this.projectName = projectName;
		this.loc = loc;
	}
	
	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
