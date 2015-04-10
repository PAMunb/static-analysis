package br.unb.cic.sa.model;

public class Project {
	private String projectName;
	private String projectRevision;
	private String filePath;

	
	public Project(String projectName, String projectRevision, String filePath) {
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


	public void setPath(String filePath) {
		this.filePath = filePath;
	}




}
