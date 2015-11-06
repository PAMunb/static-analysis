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
	private String projectRevision;
	private String filePath;
	private String typeOfProject;
	private String before; //To set true if project is before 2004 or set false if is after
	private int loc;

	public Project(String typeOfProject, String before, String projectName, String projectRevision, String filePath, int loc){
		this.typeOfProject = typeOfProject;
		this.before = before;
		this.projectName = projectName;
		this.projectRevision = projectRevision;
		this.filePath = filePath;
		this.loc = loc;
	}
	
	public String getTypeOfProject() {
		return typeOfProject;
	}

	public void setTypeOfProject(String typeOfProject) {
		this.typeOfProject = typeOfProject;
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
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


	public String getProjectRevision() {
		return projectRevision;
	}


	public void setProjectRevision(String projectRevision) {
		this.projectRevision = projectRevision;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setPath(String filePath){
		try{
			File f = new File(filePath);
			
			if(!f.isDirectory()){
				String e = "Project " + this.projectName +
						  " path " + filePath + " not is valid!";
				throw new FileNotFoundException(e);
			}
			this.filePath = filePath;
		}catch(FileNotFoundException e){
			e.getStackTrace();
		}
	}
}
