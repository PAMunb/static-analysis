package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

public class CollectedData {

	private Project project;
	private int numberOfStatements;

	private List<String> analysisError;
	private List<Switch> switchs;
	private List<Switch> switchWithString;
	private List<Try> trys;
	private List<Try> tryWithSimilarityCatch;
	private List<ScriptingEngineCall> scriptingEngineCalls;
	
	private List<Method> methods;
	private List<Method> methodWithVargs;
	private List<Method> paramMethods;
	private List<Type> types;
	private List<Type> paramTypes;
	private List<Variable> variables;
	private List<Variable> paramVariables;

	private List<String> nameFile;
	
	private List<AnnonymousInnerClass> aics;

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
		
		this.scriptingEngineCalls = new ArrayList<ScriptingEngineCall>();
		
		this.nameFile = new ArrayList<String>();
		this.tryWithSimilarityCatch = new ArrayList<>();
		this.methods = new ArrayList<>();
		this.methodWithVargs = new ArrayList<>();
		this.paramMethods = new ArrayList<>();
		this.types = new ArrayList<>();
		this.paramTypes = new ArrayList<>();
		this.variables = new ArrayList<>();
		this.paramVariables = new ArrayList<>();
		this.nameFile = new ArrayList<>();

		this.numberOfStatements = 0;
		
		aics = new ArrayList<>();

	}

	public CollectedData(String projectName, String projectRevision,
			String filePath) {
		this();// call the default construct
		this.project = new Project(projectName, projectRevision, filePath);
	}

	public void setProject(Project project) {
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

	// ############################## Switch Block  ###################################
	public void addSwitch(Switch s) {
		this.switchs.add(s);
	}

	public void addSwichWithString(Switch s) {
		this.switchWithString.add(s);
	}

	public List<Switch> getSwitch() {
		return this.switchs;
	}

	public List<Switch> getSwitchWithString() {
		return this.switchWithString;
	}

	// ############################ TryStatment Block ################################
	public void addTry(Try t) {
		this.trys.add(t);
	}

	public List<Try> getTrys() {
		return this.trys;
	}

	public void addTryWithSimilartyCatch(Try tryWithSimilarityCatch) {
		this.tryWithSimilarityCatch.add(tryWithSimilarityCatch);
	}

	public List<Try> getTryWithSimilartyCatch() {
		return this.tryWithSimilarityCatch;
	}
	
	// Annonymous Inner Classes 
	
	public void addAnnonymousInnerClass(AnnonymousInnerClass aic) {
		aics.add(aic);
	}
	
	public List<AnnonymousInnerClass> getAICS() {
		return aics;
	}

	// ######################## MethodDeclaration ############################

	public void addMethods(Method method) {
		this.methods.add(method);
	}

	public List<Method> getMethods() {
		return this.methods;
	}

	public void addMethodWithVargs(Method method) {
		this.methodWithVargs.add(method);
	}

	public List<Method> getMethodWithVargs() {
		return this.methodWithVargs;
	}
	
	public void addParameterizedMethod(Method method){
		this.paramMethods.add(method);
	}
	
	public List<Method> getParameterizedMethods(){
		return this.paramMethods;
	}

	// ############### TypeDeclarations ####################
	public void addType(Type type) {
		this.types.add(type);
	}

	public List<Type> getTypeDeclarations() {
		return this.types;
	}

	public void addParameterizedType(Type type) {
		this.paramTypes.add(type);
	}

	public List<Type> getParamTypes() {
		return this.paramTypes;
	}
	
	// ############### Variable Declarations ####################
	public void addVariable(Variable var){
		this.variables.add(var);
	}
		
	public List<Variable> getVariablesDeclarations() {
		return this.variables;
	}

	public void addParameterizedVariable(Variable var){
		this.paramVariables.add(var);
	}

	public List<Variable> getParamVariables() {
		return this.paramVariables;
	}

	// ############### Statements ####################
	public int getNumberOfStatements() {
		return this.numberOfStatements;
	}

	public void addError(List<String> e){
		analysisError.addAll(e);
	}
	
	public void addError(String e) {
		analysisError.add(e);
	}

	public List<String> getError() {
		return analysisError;
	}
	
	public void addScriptingEngineCall(ScriptingEngineCall s) {
		this.scriptingEngineCalls.add(s);
	}
	
	public List<ScriptingEngineCall> getScriptEngineCalls() {
		return scriptingEngineCalls;
	}

	// ################ Clear ########################
	public void cleanData() {
		this.numberOfStatements = 0;
		this.analysisError.clear();
		this.trys.clear();
		this.tryWithSimilarityCatch.clear();

		this.methods.clear();
		this.methodWithVargs.clear();
		this.types.clear();
		this.paramTypes.clear();
		this.switchs.clear();
		this.switchWithString.clear();
		this.scriptingEngineCalls.clear();
		this.aics.clear();
	}

}
