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
	private int loc;

	public Project(String projectName, String projectRevision, String filePath, int loc){
		this.projectName = projectName;
		this.projectRevision = projectRevision;
		this.filePath = filePath;
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
