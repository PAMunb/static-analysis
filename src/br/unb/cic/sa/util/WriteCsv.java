package br.unb.cic.sa.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.unb.cic.sa.model.ClassDeclaration;
import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.LambdaExp;
import br.unb.cic.sa.model.Method;
import br.unb.cic.sa.model.OpportunitieSwitchString;
import br.unb.cic.sa.model.OpportunitiesLambdaExp;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.model.ScriptingEngineCall;
import br.unb.cic.sa.model.Switch;
import br.unb.cic.sa.model.Try;
import br.unb.cic.sa.model.Variable;

public class WriteCsv {

	private File dir;
	private FileWriter csvIfString;
	private FileWriter csvLambdaExpression;
	private FileWriter csvMethods;
	private FileWriter csvMethodsVargs;
	private FileWriter csvParamMethods;
	private FileWriter csvTry;
	private FileWriter csvTryResource;
	private FileWriter csvTysSimilarCatch;
	private FileWriter csvTypes;
	private FileWriter csvParamtypes;
	private FileWriter csvVariables;
	private FileWriter csvParamVariables;
	private FileWriter csvSwitch;
	private FileWriter csvSwithWithString;
	private FileWriter csvOpportunitiesLambdaExp;
	private FileWriter csvError;
	private FileWriter csvAnnonymousInnerClasses;

	public WriteCsv() {

		dir = this.createOutputDir(Constants.CSV_OUTPUT_DIT);

		try {
			
			csvIfString = new FileWriter(dir + "/" + Constants.CSV_OPPORTUNITIES_SWITCH_STRING);
			csvIfString.append(Constants.HEADER_OUTPUT_OPPORTUNITIES_SWITCH_STRING);
			csvIfString.flush();
			
			csvLambdaExpression = new FileWriter(dir + "/" + Constants.CSV_LAMBDA_EXPRESSION);
			csvLambdaExpression.append(Constants.HEADER_OUTPUT_LAMBDA_EXPRESSION);
			csvLambdaExpression.flush();

			csvMethods = new FileWriter(dir + "/" + Constants.CSV_METHODS);
			csvMethods.append(Constants.HEADER_OUTPUT_METHODS_CSV);
			csvMethods.flush();

			csvMethodsVargs = new FileWriter(dir + "/"
					+ Constants.CSV_METHOD_WITH_VARGS);
			csvMethodsVargs.append(Constants.HEADER_OUTPUT_METHODS_CSV);
			csvMethodsVargs.flush();
			
			csvParamMethods = new FileWriter(dir + "/"
					+ Constants.CSV_PARAM_METHODS);
			csvParamMethods.append(Constants.HEADER_OUTPUT_METHODS_CSV);
			csvParamMethods.flush();

			csvTry = new FileWriter(dir + "/" + Constants.CSV_TRYS);
			csvTry.append(Constants.HEADER_OUTPUT_TRY);
			csvTry.flush();
			
			csvTryResource = new FileWriter(dir + "/" + Constants.CSV_TRY_RESOURCE);
			csvTryResource.append(Constants.HEADER_OUTPUT_TRY);
			csvTryResource.flush();

			csvTysSimilarCatch = new FileWriter(dir + "/"
					+ Constants.CSV_TRY_WITH_SIMILAR_CATCH);
			csvTysSimilarCatch.append(Constants.HEADER_OUTPUT_TRY);
			csvTysSimilarCatch.flush();

			csvTypes = new FileWriter(dir + "/" + Constants.CSV_TYPE);
			csvTypes.append(Constants.HEADER_OUTPUT_TYPES);
			csvTypes.flush();

			csvParamtypes = new FileWriter(dir + "/" + Constants.CSV_PARAM_TYPE);
			csvParamtypes.append(Constants.HEADER_OUTPUT_TYPES);
			csvParamtypes.flush();
			
			csvVariables = new FileWriter(dir + "/" + Constants.CSV_VARIABLES);
			csvVariables.append(Constants.HEADER_OUTPUT_VARIABLES);
			csvVariables.flush();
			
			csvParamVariables = new FileWriter(dir + "/" 
					+ Constants.CSV_PARAM_VARIABLES);
			csvParamVariables.append(Constants.HEADER_OUTPUT_VARIABLES);
			csvParamVariables.flush();

			csvSwitch = new FileWriter(dir + "/" + Constants.CSV_SWITCH);
			csvSwitch.append(Constants.HEADER_OUTPUT_SWITCH);
			csvSwitch.flush();

			csvSwithWithString = new FileWriter(dir + "/"
					+ Constants.CSV_SWITCH_WITH_STRING);
			csvSwithWithString.append(Constants.HEADER_OUTPUT_SWITCH);
			csvSwithWithString.flush();
			
			csvAnnonymousInnerClasses = new FileWriter(dir + "/" + Constants.AIC_FILE);
			
			
			csvOpportunitiesLambdaExp = new FileWriter(dir + "/" + Constants.CSV_OUTPUT_OPPORTUNITIES_LAMBDA_EXP);
			csvOpportunitiesLambdaExp.append(Constants.HEADER_OUTPUT_OPPORTUNITIES_LAMBDA_EXP);
			csvOpportunitiesLambdaExp.flush();

			csvError = new FileWriter(dir + "/" + Constants.CSV_ERROR);
			csvError.append(Constants.HEADER_ERROR);
			csvError.flush();

		} catch (IOException e) {
			System.out.println("Erro to Writer CSV !!!");
			e.getStackTrace();
		}

	}

	public void writeCsv(CollectedData collectedData) {

		System.out.println("Generating output file project "
				+ collectedData.getProject().getProjectName() + " Version "
				+ collectedData.getProject().getProjectRevision()+ " ...");
		
		System.out.println("LOC: "+collectedData.getProject().getLoc());

		if(collectedData.getOpportunitieSwichString().size() > 0){
			this.write(
					this.ifs(collectedData.getOpportunitieSwichString(),
										collectedData.getProject()), csvIfString);
		}
		
		if(collectedData.getLambdaExp().size() > 0){
			this.write(
					this.lambadaExpression(collectedData.getLambdaExp(), 
											collectedData.getProject()), csvLambdaExpression);
		}
		
		if (collectedData.getTypeDeclarations().size() > 0) {
			this.write(
					types(collectedData.getTypeDeclarations(),
							collectedData.getProject()), csvTypes);
		}

		if (collectedData.getParamTypes().size() > 0) {
			this.write(
					types(collectedData.getParamTypes(),
							collectedData.getProject()), csvParamtypes);
		}

		if (collectedData.getMethods().size() > 0) {
			this.write(
					methods(collectedData.getMethods(),
							collectedData.getProject()), csvMethods);
		}

		if (collectedData.getMethodWithVargs().size() > 0) {
			this.write(
					methods(collectedData.getMethodWithVargs(),
							collectedData.getProject()), csvMethodsVargs);
		}
		
		if (collectedData.getParameterizedMethods().size() > 0) {
			this.write(
					methods(collectedData.getParameterizedMethods(),
							collectedData.getProject()), csvParamMethods);
		}
		
		if (collectedData.getVariablesDeclarations().size() > 0) {
			this.write(
					variables(collectedData.getVariablesDeclarations(),
							collectedData.getProject()), csvVariables);
		}
		
		if (collectedData.getParamVariables().size() > 0) {
			this.write(
					variables(collectedData.getParamVariables(),
							collectedData.getProject()), csvParamVariables);
		}

		if (collectedData.getTrys().size() > 0) {
			this.write(
					trys(collectedData.getTrys(), collectedData.getProject()),
					csvTry);
		}
		
		if (collectedData.getTrysResource().size() > 0) {
			this.write(
					trys(collectedData.getTrysResource(), collectedData.getProject()),
					csvTryResource);
		}

		if (collectedData.getTryWithSimilartyCatch().size() > 0) {
			this.write(
					trys(collectedData.getTryWithSimilartyCatch(),
							collectedData.getProject()), csvTysSimilarCatch);
		}

		if (collectedData.getSwitch().size() > 0) {
			this.write(
					switchs(collectedData.getSwitch(),
							collectedData.getProject()), csvSwitch);
		}

		if (collectedData.getSwitchWithString().size() > 0) {
			this.write(
					switchs(collectedData.getSwitchWithString(),
							collectedData.getProject()), csvSwithWithString);
		}

		if (collectedData.getError().size() > 0) {
			this.write(
					error(collectedData.getError(), collectedData.getProject()),
					csvError);
		}
		
		if(collectedData.getScriptEngineCalls().size() > 0) {
			this.writeScriptingCalls(collectedData.getScriptEngineCalls(), dir.getAbsoluteFile() + "/" + Constants.CSV_SCRIPTING_CALLS);
		}
		
		
		if (collectedData.getOpportunitiesLambdaExp().size() > 0) {
			this.write(
					opportunitiesLambdaExp(collectedData.getOpportunitiesLambdaExp(), collectedData.getProject()),
					csvOpportunitiesLambdaExp);
		}

		
		
		System.out.println("Finished!\n");

	}

	private void writeScriptingCalls(
			List<ScriptingEngineCall> scriptEngineCalls, String string) {
		
		FileWriter csv = null;
		String line;
		
		try{
			csv = new FileWriter(string);
			// Header to print Types
			csv.append(Constants.SUB_HEADER_OUTPUT_SCRIPTING_CALLS);
			
			for (ScriptingEngineCall call : scriptEngineCalls) {
				line = (
						call.getFile() + Constants.COMMA_DELIMITER +
						call.getMethod() + Constants.COMMA_DELIMITER +
						call.getStartLine() + Constants.COMMA_DELIMITER + 
						call.getEndLine() + Constants.COMMA_DELIMITER +
						Constants.NEW_LINE
						).toString();
				
				csv.append(line);
			}
			
			csv.flush();
			csv.close();
			
		}catch(IOException e){
			System.out.println("Erro to Writer CSV !!!");
			e.getStackTrace();
		}
	}

	private File createOutputDir(String nameDir) {
		// create a dir from csv project
		File outputDir = new File(nameDir);

		if (!outputDir.exists()) {
			if (outputDir.mkdir()) {
				return outputDir;
			}
		}

		return outputDir;

	}
	
	
	private StringBuilder ifs(List<OpportunitieSwitchString> i, Project project) {
		StringBuilder sb = new StringBuilder();

		i.forEach(t -> sb.append(t.getFile() + Constants.COMMA_DELIMITER + t.getStartLine()
				+ Constants.COMMA_DELIMITER + t.getEndLine()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));

		return sb;
	}

	private StringBuilder methods(List<Method> methods, Project project) {
		StringBuilder sb = new StringBuilder();

		methods.forEach(m -> sb.append(m.getName() + Constants.COMMA_DELIMITER
				+ m.getFile() + Constants.COMMA_DELIMITER + m.getStartLine()
				+ Constants.COMMA_DELIMITER + m.getEndLine()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));

		return sb;
	}

	private StringBuilder types(List<ClassDeclaration> types, Project project) {
		StringBuilder sb = new StringBuilder();

		types.forEach(ts -> sb.append(ts.getName() 
				+ Constants.COMMA_DELIMITER + ts.getFile()
				+ Constants.COMMA_DELIMITER + ts.getSuperClass()
				+ Constants.COMMA_DELIMITER + ts.getIntefaces()
				+ Constants.COMMA_DELIMITER + ts.getStartLine()
				+ Constants.COMMA_DELIMITER + ts.getEndLine()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));

		return sb;
	}
	
	private StringBuilder variables(List<Variable> variables, Project project) {
		StringBuilder sb = new StringBuilder();
		
		variables.forEach(ts -> sb.append(ts.getName() + Constants.COMMA_DELIMITER
				+ ts.getFile() + Constants.COMMA_DELIMITER + ts.getType()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));
		
		return sb;
	}

	private StringBuilder lambadaExpression(List<LambdaExp> lambdaExp, Project project) {
		StringBuilder sb = new StringBuilder();

		lambdaExp.forEach(l -> sb.append(
				l.getFile() + Constants.COMMA_DELIMITER + l.getStartLine()
				+ Constants.COMMA_DELIMITER + l.getEndLine()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));

		return sb;
	}
	
	private StringBuilder trys(List<Try> trys, Project project) {
		StringBuilder sb = new StringBuilder();

		trys.forEach(t -> sb.append(t.getFile() + Constants.COMMA_DELIMITER + t.getStartLine()
				+ Constants.COMMA_DELIMITER + t.getEndLine()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));

		return sb;
	}

	
	private StringBuilder opportunitiesLambdaExp(List<OpportunitiesLambdaExp> op, Project project) {
		StringBuilder sb = new StringBuilder();

		op.forEach(t -> sb.append(t.getFile() + Constants.COMMA_DELIMITER + t.getStartLine()
				+ Constants.COMMA_DELIMITER + t.getEndLine()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));

		return sb;
	}
	
	
	private StringBuilder switchs(List<Switch> switchs, Project project) {
		StringBuilder sb = new StringBuilder();

		switchs.forEach(s -> sb.append(Constants.EMPTY
				+ Constants.COMMA_DELIMITER + s.getFile()
				+ Constants.COMMA_DELIMITER + s.getStartLine()
				+ Constants.COMMA_DELIMITER + s.getEndLine()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));

		return sb;
	}

	private StringBuilder error(List<String> errors, Project project) {
		StringBuilder sb = new StringBuilder();
		errors.forEach(e -> sb.append(Constants.COMMA_DELIMITER
				+ project.getProjectName() + Constants.COMMA_DELIMITER
				+ Constants.NEW_LINE));

		return sb;
	}

	private void write(StringBuilder sb, FileWriter csv) {
		try {
			csv.append(sb);
			csv.flush();
		} catch (IOException e) {
			System.out.println("Erro write " + csv.toString() + "!!!");
			e.getStackTrace();
		}
	}

	public void close() {
		try {
			csvMethods.close();
			csvMethodsVargs.close();
			csvParamMethods.close();
			csvTry.close();
			csvTysSimilarCatch.close();
			csvTypes.close();
			csvParamtypes.close();
			csvVariables.close();
			csvParamVariables.close();
			csvSwitch.close();
			csvSwithWithString.close();
			csvOpportunitiesLambdaExp.close();
			csvError.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
