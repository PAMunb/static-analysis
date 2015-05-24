package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class ContentProject {
	private CompilationUnit compilationUnit;
	private String pathFile;
	private List<CollectedData> listCollectedData;
	
	public ContentProject(){
		this.listCollectedData = new ArrayList<CollectedData>();
	}
	
	public ContentProject(CompilationUnit compilationUnit, String pathFile) {
		this.compilationUnit = compilationUnit;
		this.pathFile = pathFile;
		this.listCollectedData = new ArrayList<CollectedData>();
	}


	public List<CollectedData> getListCollectedData() {
		return listCollectedData;
	}


	public void setListCollectedData(List<CollectedData> listCollectedData) {
		this.listCollectedData = listCollectedData;
	}


	public CompilationUnit getCompilationUnit() {
		return compilationUnit;
	}


	public void setCompilationUnit(CompilationUnit compilationUnit) {
		this.compilationUnit = compilationUnit;
	}


	public String getPathFile() {
		return pathFile;
	}


	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
}
