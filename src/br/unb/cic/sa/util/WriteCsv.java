package br.unb.cic.sa.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Method;
import br.unb.cic.sa.model.ScriptingEngineCall;
import br.unb.cic.sa.model.Project;
import br.unb.cic.sa.model.Switch;
import br.unb.cic.sa.model.Try;
import br.unb.cic.sa.model.Type;

public class WriteCsv {

	private File dir;
	private FileWriter csvMethods;
	private FileWriter csvParamMethods;
	private FileWriter csvMethodsVargs;
	private FileWriter csvTry;
	private FileWriter csvTysSimilarCatch;
	private FileWriter csvType;
	private FileWriter csvParamtype;
	private FileWriter csvSwitch;
	private FileWriter csvSwithWithString;
	private FileWriter csvError;

	public WriteCsv() {

		dir = this.createOutputDir(Constants.CSV_OUTPUT_DIT);

		try {

			csvMethods = new FileWriter(dir + "/" + Constants.CSV_METHODS);
			csvMethods.append(Constants.HEADER_OUTPUT_METHODS_CSV);
			csvMethods.flush();

			csvMethodsVargs = new FileWriter(dir + "/"
					+ Constants.CSV_METHOD_WITH_VARGS);
			csvMethodsVargs.append(Constants.HEADER_OUTPUT_METHODS_CSV);
			csvMethodsVargs.flush();

			csvTry = new FileWriter(dir + "/" + Constants.CSV_TRYS);
			csvTry.append(Constants.HEADER_OUTPUT_TRY);
			csvTry.flush();

			csvTysSimilarCatch = new FileWriter(dir + "/"
					+ Constants.CSV_TRY_WITH_SIMILAR_CATCH);
			csvTysSimilarCatch.append(Constants.HEADER_OUTPUT_TRY);
			csvTysSimilarCatch.flush();

			csvType = new FileWriter(dir + "/" + Constants.CSV_TYPE);
			csvType.append(Constants.HEADER_OUTPUT_TYPES);
			csvType.flush();

			csvParamtype = new FileWriter(dir + "/" + Constants.CSV_PARAMTYPE);
			csvParamtype.append(Constants.HEADER_OUTPUT_TYPES);
			csvParamtype.flush();

			csvSwitch = new FileWriter(dir + "/" + Constants.CSV_SWITCH);
			csvSwitch.append(Constants.HEADER_OUTPUT_SWITCH);
			csvSwitch.flush();

			csvSwithWithString = new FileWriter(dir + "/"
					+ Constants.CSV_SWITCH_WITH_STRING);
			csvSwithWithString.append(Constants.HEADER_OUTPUT_SWITCH);
			csvSwithWithString.flush();

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

		if (collectedData.getTypeDeclarations().size() > 0) {
			this.write(
					types(collectedData.getTypeDeclarations(),
							collectedData.getProject()), csvType);
		}

		if (collectedData.getParamTypes().size() > 0) {
			this.write(
					types(collectedData.getParamTypes(),
							collectedData.getProject()), csvParamtype);
		}

		if (collectedData.getMethods().size() > 0) {
			this.write(
					methods(collectedData.getMethods(),
							collectedData.getProject()), csvMethods);
		}

		if (collectedData.getMethodWithVargs().size() > 0)
			this.write(
					methods(collectedData.getMethodWithVargs(),
							collectedData.getProject()), csvMethodsVargs);

		if (collectedData.getTrys().size() > 0) {
			this.write(
					trys(collectedData.getTrys(), collectedData.getProject()),
					csvTry);
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
		
		
		System.out.println("Finished!");

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

	private StringBuilder types(List<Type> types, Project project) {
		StringBuilder sb = new StringBuilder();

		types.forEach(ts -> sb.append(ts.getName() + Constants.COMMA_DELIMITER
				+ ts.getFile() + Constants.COMMA_DELIMITER + ts.getStartLine()
				+ Constants.COMMA_DELIMITER + ts.getEndLine()
				+ Constants.COMMA_DELIMITER + project.getProjectName()
				+ Constants.COMMA_DELIMITER + project.getProjectRevision()
				+ Constants.COMMA_DELIMITER + Constants.NEW_LINE));

		return sb;
	}

	private StringBuilder trys(List<Try> trys, Project project) {
		StringBuilder sb = new StringBuilder();

		trys.forEach(t -> sb.append(Constants.EMPTY + Constants.COMMA_DELIMITER
				+ t.getFile() + Constants.COMMA_DELIMITER + t.getStartLine()
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
			csvTry.close();
			csvTysSimilarCatch.close();
			csvType.close();
			csvParamtype.close();
			csvSwitch.close();
			csvSwithWithString.close();
			csvError.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
