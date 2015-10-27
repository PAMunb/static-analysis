package br.unb.cic.sa.model;

import java.util.ArrayList;
import java.util.List;

public class CollectedData {

	private Project project;
	
	private int numberOfStatements;

	private List<OpportunitieSwitchString> opportunitiesSwichString;
	private List<String> analysisError;
	private List<LambdaExp> lbdexps;
	private List<Switch> switchs;
	private List<Switch> switchWithString;
	private List<Try> trys;
	private List<Try> trysResource;
	private List<Try> tryWithSimilarityCatch;
	private List<ScriptingEngineCall> scriptingEngineCalls;
	
	private List<Method> methods;
	private List<Method> methodWithVargs;
	private List<Method> paramMethods;
	private List<ClassDeclaration> types;
	private List<ClassDeclaration> paramTypes;
	private List<Variable> variables;
	private List<Variable> paramVariables;
	
	private List<OpportunitiesLambdaExp> opportunitesLambdaExp;

	private List<String> nameFile;
	
	private List<AnnonymousInnerClass> aics;

	public CollectedData() {
		this.analysisError = new ArrayList<String>();

		this.lbdexps = new ArrayList<>();
		this.switchs = new ArrayList<>();
		this.switchWithString = new ArrayList<>();
		
		this.opportunitiesSwichString = new ArrayList<>();
		
		this.trys = new ArrayList<Try>();
		this.trysResource = new ArrayList<>();
		this.tryWithSimilarityCatch = new ArrayList<Try>();
		
		this.methods = new ArrayList<Method>();
		this.methodWithVargs = new ArrayList<Method>();
		
		this.types = new ArrayList<ClassDeclaration>();
		this.paramTypes = new ArrayList<ClassDeclaration>();
		
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
		
		this.opportunitesLambdaExp = new ArrayList<>();

		this.numberOfStatements = 0;
		
		aics = new ArrayList<>();

	}

	public CollectedData(String projectName, String projectRevision,
			String filePath, int totalLineCode) {
		this();// call the default construct
		this.project = new Project(projectName, projectRevision, filePath, totalLineCode);
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
	
	
	// ############################## If String Block  ###################################
	public void addOpportunitieSwichString(OpportunitieSwitchString i){
		this.opportunitiesSwichString.add(i);
	}
	
	public List<OpportunitieSwitchString> getOpportunitieSwichString(){
		return this.opportunitiesSwichString;
	}
	
	

	// ############################## Lambda Exp Block  ###################################
	public void addLambdaExp(LambdaExp l) {
		this.lbdexps.add(l);
	}

	public List<LambdaExp> getLambdaExp() {
		return this.lbdexps;
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
	
	public void addTryResource(Try t) {
		this.trysResource.add(t);
	}

	public List<Try> getTrysResource() {
		return this.trysResource;
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
	public void addType(ClassDeclaration type) {
		this.types.add(type);
	}

	public List<ClassDeclaration> getTypeDeclarations() {
		return this.types;
	}

	public void addParameterizedType(ClassDeclaration type) {
		this.paramTypes.add(type);
	}

	public List<ClassDeclaration> getParamTypes() {
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

	
	
	// ############### Opportunities Lambda Expressions ####################
	public void addOpportunitiesLambdaExp(OpportunitiesLambdaExp o){
		this.opportunitesLambdaExp.add(o);
	}
	
	public List<OpportunitiesLambdaExp> getOpportunitiesLambdaExp(){
		return this.opportunitesLambdaExp;
	}
	
	
	// ################ Clear ########################
	public void cleanData() {
		this.numberOfStatements = 0;
		this.analysisError.clear();
		this.opportunitiesSwichString.clear();
		this.lbdexps.clear();
		this.trys.clear();
		this.trysResource.clear();
		this.switchs.clear();
		this.switchWithString.clear();
		this.scriptingEngineCalls.clear();
		this.nameFile.clear();;
		this.tryWithSimilarityCatch.clear();
		this.methods.clear();
		this.methodWithVargs.clear();
		this.paramMethods.clear();
		this.types.clear();
		this.paramTypes.clear();
		this.switchs.clear();
		this.switchWithString.clear();
		this.scriptingEngineCalls.clear();
		this.aics.clear();
		this.variables.clear();
		this.paramVariables.clear();
		this.opportunitesLambdaExp.clear();
	}

}
