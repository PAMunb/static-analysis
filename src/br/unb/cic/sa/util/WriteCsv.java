package br.unb.cic.sa.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Method;
import br.unb.cic.sa.model.Try;
import br.unb.cic.sa.model.Type;

public class WriteCsv {

	public WriteCsv() {
	}

	public void writeCsv(CollectedData collectedData) {
		
		System.out.println("Generating output file...");

		File dir = this.createOutputDir("Output_"
				+ collectedData.getProject().getProjectName());
		
		if(collectedData.getNumberOfTypes() > 0) {
			this.writeType(collectedData.getTypeDeclarations(),
					dir.getAbsolutePath() + "/" + Constants.CSV_TYPE);
		}
		
		if(collectedData.getNumberOfParamTypes() > 0){
			this.writeType(collectedData.getParamTypes(),
					dir.getAbsolutePath() + "/" + Constants.CSV_PARAMTYPE);
		}

		if (collectedData.getNumberOfMethod() > 0) {
			this.writeMethodWithVargs(collectedData.getMethods(),
					dir.getAbsolutePath() + "/" + Constants.CSV_METHODS);
		}
		
		if (collectedData.getNumberOfMethodDeclarationWithVargs() > 0)
			this.writeMethodWithVargs(collectedData.getMethodWithVargs(),
					dir.getAbsolutePath() + "/"
							+ Constants.CSV_METHOD_WITH_VARGS);
		
		if (collectedData.getNumberOfTry() > 0) {
			this.writeTry(collectedData.getTrys(),
					dir.getAbsolutePath() + "/"
							+ Constants.CSV_TRYS);
		}
		
		if (collectedData.getNumberOfTryWithSimilartyCatch() > 0) {
			this.writeTry(collectedData.getTryWithSimilartyCatch(),
					dir.getAbsolutePath() + "/"
							+ Constants.CSV_TRY_WITH_SIMILAR_CATCH);
		}
		
		
		
		System.out.println("Finished!");

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
	
	private void writeType(List<Type> types, String nameCsv){
		FileWriter csv = null;
		String line;
		
		try{
			csv = new FileWriter(nameCsv);
			// Header to print Types
			csv.append(Constants.SUB_HEADER_OUTPUT_TYPES);
			
			for (Type ts : types) {
				line = (
						ts.getName() + Constants.COMMA_DELIMITER +
						ts.getFile() + Constants.COMMA_DELIMITER +
						ts.getStartLine() + Constants.COMMA_DELIMITER +
						ts.getEndLine() + Constants.COMMA_DELIMITER +
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

	private void writeTry(List<Try> trys, String nameCsv) {

		FileWriter csv = null;

		try {
			csv = new FileWriter(nameCsv);
			// Header to print methods
			csv.append(Constants.SUB_HEADER_OUTPUT_TRY);

			for (Try ts : trys) {

				String line = (ts.getFile() + Constants.COMMA_DELIMITER
						+ ts.getStartLine() + Constants.COMMA_DELIMITER
						+ ts.getEndLine() + Constants.COMMA_DELIMITER + Constants.NEW_LINE)
						.toString();

				csv.append(line);
			}

			csv.flush();
			csv.close();

		} catch (IOException e) {
			System.out.println("Erro to Writer CSV !!!");
			e.getStackTrace();
		}
	}
	
	
	

	private void writeMethodWithVargs(List<Method> methods, String nameCsv) {

		FileWriter csv = null;

		try {
			csv = new FileWriter(nameCsv);
			// Header to print methods
			csv.append(Constants.SUB_HEADER_OUTPUT_METHODS_CSV);

			for (Method m : methods) {

				String pkg = m.getFile();
				String line = (m.getName() + Constants.COMMA_DELIMITER + pkg
						+ Constants.COMMA_DELIMITER + m.getStartLine()
						+ Constants.COMMA_DELIMITER + m.getEndLine()
						+ Constants.COMMA_DELIMITER + Constants.NEW_LINE)
						.toString();

				csv.append(line);
			}

			csv.flush();
			csv.close();
			
			
			System.out.println("Write " + nameCsv + " with Success!");

		} catch (IOException e) {
			System.out.println("Erro to Writer CSV !!!");
			e.getStackTrace();
		}

	}

}