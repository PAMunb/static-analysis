package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

public class CollectedData {

	private Project project;
	private int numberOfStatements;
	private int numberOfSwitchStatement;
	private int numberOfSwitchWithString;
	private int numberOfTryStatements;
	private int numberOfTryWithSimilartyCatch;
	private int numberOfMethod;
	private int numberOfMethodWithVargs;
	private int numberOfTypes;
	private int numberOfParamTypes;

	private List<String> analysisError;
	private List<Switch> switchs;
	private List<Switch> switchWithString;
	private List<Try> trys;
	private List<Try> tryWithSimilarityCatch;
	
	

	private List<Method> methods;
	private List<Method> methodWithVargs;
	private List<Type> types;
	private List<Type> paramTypes;
	
	private List<String> nameFile;

	public CollectedData() {
		this.analysisError = new ArrayList<String>();
		
		this.switchs = new ArrayList<>();
		this.switchWithString = new ArrayList<>();
		this.trys = new ArrayList<Try>();
		this.tryWithSimilarityCatch = new ArrayList<Try>();
		
		this.methods = new ArrayList<Method>();
		this.methodWithVargs = new ArrayList<Method>();
		
		this.types = new ArrayList<Type>();
		this.paramTypes = new ArrayList<Type>();
		
		this.nameFile = new ArrayList<String>();
		this.numberOfSwitchStatement = 0;
		this.numberOfSwitchWithString = 0;
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

	
	public void setProject(Project project){
		this.project = project;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void addNameFile(String nameFile) {
		this.nameFile.add(nameFile);
	}

	public String getNameFile(int position) {
		return this.nameFile.get(position);
	}

	
//	############################## Switch Block ###################################
	public void addSwitch(Switch  s){
		this.switchs.add(s);
		this.numberOfSwitchStatement++;
	}
	
	public void addSwichWithString(Switch s){
		this.switchWithString.add(s);
		this.numberOfSwitchWithString++;
	}

	public List<Switch> getSwitch(){
		return this.switchs;
	}
	
	public List<Switch> getSwitchWithString(){
		return this.switchWithString;
	}
	
	public int getNumberOfSwitch(){
		return this.numberOfSwitchStatement;
	}
	
	public int getNumberOfSwitchWithString(){
		return this.numberOfSwitchWithString;
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
	
	
	// ############### TypeDeclarations ####################
		public void addType(Type type){
			this.types.add(type);
			this.numberOfTypes++;
		}
		
		public void addParameterizedType(Type type){
			this.paramTypes.add(type);
			this.numberOfParamTypes++;
		}
		
		public List<Type> getTypeDeclarations(){
			return this.types;
		}
		
		public List<Type> getParamTypes(){
			return this.paramTypes;
		}
		
		public int getNumberOfTypes(){
			return this.numberOfTypes;
		}
		
		public int getNumberOfParamTypes(){
			return this.numberOfParamTypes;
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

// ################ Clear ########################
	public void cleanData(){
		this.numberOfSwitchStatement = 0;
		this.numberOfSwitchWithString = 0;
		this.numberOfStatements = 0;
		this.numberOfTryStatements = 0;
		this.numberOfTryWithSimilartyCatch = 0;
		this.numberOfMethod = 0;
		this.numberOfMethodWithVargs = 0;
		this.numberOfTypes = 0;
		this.numberOfParamTypes = 0;
		this.analysisError.clear();
		this.trys.clear();
		this.tryWithSimilarityCatch.clear();

		this.methods.clear();
		this.methodWithVargs.clear();
		this.types.clear();
		this.paramTypes.clear();
		this.switchs.clear();
		this.switchWithString.clear();
	}

}
