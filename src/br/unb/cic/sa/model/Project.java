package br.unb.cic.sa.model;

import java.io.File;
import java.io.FileNotFoundException;

public class Project {
	private String projectName;
	private String projectRevision;
	private String filePath;

	
	public Project(String projectName, String projectRevision, String filePath){
		this.projectName = projectName;
		this.projectRevision = projectRevision;
		this.filePath = filePath;
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
