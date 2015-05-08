package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

public class CollectedData {

	private Project project;
	private int numberOfStatements;
	private int numberOfTryStatements;
	private int numberOfTryWithSimilartyCatch;
	private int numberOfMethod;
	private int numberOfMethodWithVargs;
	private List<String> analysisError;
	private List<Try> trys;
	private List<Try> tryWithSimilarityCatch;

	private List<Method> methods;
	private List<Method> methodWithVargs;
	private List<String> nameFile;

	public CollectedData() {
		this.analysisError = new ArrayList<String>();
		
		this.trys = new ArrayList<Try>();
		this.tryWithSimilarityCatch = new ArrayList<Try>();
		
		this.methods = new ArrayList<Method>();
		this.methodWithVargs = new ArrayList<Method>();
		
		this.nameFile = new ArrayList<String>();
		this.numberOfStatements = 0;
		this.numberOfTryStatements = 0;
		this.numberOfTryWithSimilartyCatch = 0;
		this.numberOfMethod = 0;
		this.numberOfMethodWithVargs = 0;
	}

	public CollectedData(String projectName, String projectRevision,
			String filePath) {
		this();// call the default construct
		this.project = new Project(projectName, projectRevision, filePath);
	}

	public void addNameFile(String nameFile) {
		this.nameFile.add(nameFile);
	}

	public String getNameFile(int position) {
		return this.nameFile.get(position);
	}

	public Project getProject() {
		return project;
	}


//	############################ TryStatment Block ################################
	public void addTry(Try t){
		this.trys.add(t);
		this.numberOfTryStatements++;
	}
	
	public List<Try> getTrys(){
		return this.trys;
	}
	
	public void addTryWithSimilartyCatch(Try tryWithSimilarityCatch) {
		this.tryWithSimilarityCatch.add(tryWithSimilarityCatch);
		//incremente number of trystatement
		this.numberOfTryWithSimilartyCatch++;
	}
	public List<Try> getTryWithSimilartyCatch() {
		return this.tryWithSimilarityCatch;
	}
	
	public int getNumberOfTry() {
		return this.numberOfTryStatements;
	}

	public int getNumberOfTryWithSimilartyCatch() {
		return this.numberOfTryWithSimilartyCatch;
	}
	
	
//	######################## MethodDeclaration ############################
	
	public void addMethods(Method method){
		this.methods.add(method);
		this.numberOfMethod++;
	}
	
	public List<Method> getMethods(){
		return this.methods;
	}
	
	public void addMethodWithVargs(Method method){
		this.methodWithVargs.add(method);
		this.numberOfMethodWithVargs++;
	}
	
	public List<Method> getMethodWithVargs(){
		return this.methodWithVargs;
	}
	
	public int getNumberOfMethod(){
		return this.numberOfMethod;
	}
	
	public int getNumberOfMethodDeclarationWithVargs(){
		return this.numberOfMethodWithVargs;
	}
	
	
	
	
//	############### Statements ####################
	public int getNumberOfStatements() {
		return this.numberOfStatements;
	}
	
	public void addError(String e) {
		analysisError.add(e);
	}

	public List<String> getError() {
		return analysisError;
	}
}
