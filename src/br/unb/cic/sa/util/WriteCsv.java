package br.unb.cic.sa.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.unb.cic.sa.model.CollectedData;
import br.unb.cic.sa.model.Method;
import br.unb.cic.sa.model.Switch;
import br.unb.cic.sa.model.Try;

public class WriteCsv {

	public WriteCsv() {
	}

	public void writeCsv(CollectedData collectedData) {

		File dir = this.createOutputDir("Output_"
				+ collectedData.getProject().getProjectName());

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
		
		
		if(collectedData.getNumberOfSwitch() > 0){
			this.writeSwitch(collectedData.getSwitch(), 
					dir.getAbsolutePath() + "/" + Constants.CSV_SWITCH);
		}
		
		
		if(collectedData.getNumberOfSwitchWithString() > 0){
			this.writeSwitch(collectedData.getSwitchWithString(), 
					dir.getAbsolutePath() + "/" + Constants.CSV_SWITCH_WITH_STRING);
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

			System.out.println("Write " + nameCsv + " with Success!");

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

	private void writeSwitch(List<Switch> sws, String nameCsv) {

		FileWriter csv = null;

		try {
			csv = new FileWriter(nameCsv);
			// Header to print methods
			csv.append(Constants.SUB_HEADER_OUTPUT_TRY);

			for (Switch sw : sws) {

				String line = (sw.getFile() + Constants.COMMA_DELIMITER
						+ sw.getStartLine() + Constants.COMMA_DELIMITER
						+ sw.getEndLine() + Constants.COMMA_DELIMITER + Constants.NEW_LINE)
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
