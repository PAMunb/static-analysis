package br.unb.cic.sa.util;


public interface Constants {
	
	/**
	 * Csv Files Output
	 */
	String CSV_METHODS = "methods.csv";
	String CSV_METHOD_WITH_VARGS = "methodVargs.csv";
	String CSV_PARAM_METHODS = "parameterizedMethods.csv";
	String CSV_TRYS = "trys.csv";
	String CSV_TRY_WITH_SIMILAR_CATCH = "tryWithSimilarCatch.csv";
	String CSV_TYPE = "types.csv";
	String CSV_PARAM_TYPE = "parameterizedTypes.csv";
	String CSV_VARIABLES = "variables.csv";
	String CSV_PARAM_VARIABLES = "parameterizedVariables.csv";
	String CSV_SWITCH = "switch.csv";
	String CSV_SWITCH_WITH_STRING = "switchWithString.csv";
	String CSV_SCRIPTING_CALLS = "scriptingCalls.csv";
	String CSV_OUTPUT_DIT = "OutputCSV";
	String CSV_ERROR = "error.csv";
	
	String PROJECT_NAME = "Project Name";
	String VERSION_PROJECT = "Version Project";
	
	
	String EMPTY = "#";
	String COMMA_DELIMITER = ",";
	String NEW_LINE = "\n";
	String ERROR = "Error";
	
	String START_NUMEBER_LINE = "Start in line";
	String END_NUMEBER_LINE = "End in line";
	String NUMBER_TOTAL_LINE_IN_PROJECT = "Total lines in project";
	String NUMBER_TOTAL_OF_STATEMENTS = "Total Statements";
	String NUMBER_OF_TRYSTATEMENTS = "Total TryStatements";
	String NUMBER_OF_METHOD_DECLARATION = "Total Methods";
	String NUMBER_OF_TYPE_DECLARATION = "Total Types";
	String NUMBER_OF_PARAMETERIZED_TYPES = "Total Parameterized Types";
	String NUMBER_TOTAL_LINES_OF_CODE = "Total lines of code";
	
	String SUPERCLASS = "Super Class";
	String INTERFACES = "Interfaces";
	
	String PACKAGE = "Package";
	String CLASS = "Class";
	String FILE = "File";
	
	/**
	 * Statements
	 */
	String METHOD = "Method";
	String METHOD_DECLARATION = "Methods Declaration";
	String METHOD_DECLARATION_WITH_VARGS = "Methods with Vargs";
	String METHOD_PATAMETERS = "Parameters";


	
	String TRY_STATEMENT = "Try Statement";
	String TRY_STATEMENT_WITH_CATCH_SIMILARITY = "Catch Similarity in Try";
	String CATCH_STATEMENT = "Catch Statement";


	String TYPE = "Type";
	String TYPE_DECLARATION = "Types Declaration";
	String PARAMETERIZED_TYPE = "Parameterized Type";
	String PARAM_TYPE_DECLARATION = "Parameterized Types Declaration";
	
	
	String VARIABLE = "Variable";
	String TYPE_OF_VARIABLE = "Type of variable";
	

//	method Declatarion, start, end, try statement, start, end
	String HEADER_OUTPUT_METHODS_CSV = 
			Constants.METHOD + Constants.COMMA_DELIMITER +
			Constants.PACKAGE + Constants.COMMA_DELIMITER +
			Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.PROJECT_NAME + Constants.COMMA_DELIMITER +
			Constants.VERSION_PROJECT + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;

	String HEADER_OUTPUT_TYPES = 
			Constants.TYPE + Constants.COMMA_DELIMITER +
			Constants.FILE + Constants.COMMA_DELIMITER +
			Constants.SUPERCLASS + Constants.COMMA_DELIMITER +
			Constants.INTERFACES + Constants.COMMA_DELIMITER +
			Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.PROJECT_NAME + Constants.COMMA_DELIMITER +
			Constants.VERSION_PROJECT + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;
	
	String HEADER_OUTPUT_VARIABLES =
			Constants.VARIABLE + Constants.COMMA_DELIMITER +
			Constants.FILE + Constants.COMMA_DELIMITER +
			Constants.TYPE_OF_VARIABLE + Constants.COMMA_DELIMITER + 
			Constants.PROJECT_NAME + Constants.COMMA_DELIMITER +
			Constants.VERSION_PROJECT + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;
	
	String HEADER_OUTPUT_TRY = 
			Constants.EMPTY + Constants.COMMA_DELIMITER +
			Constants.FILE + Constants.COMMA_DELIMITER +
			Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.PROJECT_NAME + Constants.COMMA_DELIMITER +
			Constants.VERSION_PROJECT + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;
	
	
	String HEADER_OUTPUT_SWITCH = 
			Constants.EMPTY + Constants.COMMA_DELIMITER +
			Constants.FILE + Constants.COMMA_DELIMITER +
			Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.PROJECT_NAME + Constants.COMMA_DELIMITER +
			Constants.VERSION_PROJECT + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;
	
	String HEADER_ERROR = 
			Constants.ERROR + Constants.COMMA_DELIMITER +
			Constants.PROJECT_NAME + Constants.COMMA_DELIMITER + 
			Constants.NEW_LINE;
	String SUB_HEADER_OUTPUT_SCRIPTING_CALLS = "file, method, start, end";
	
//	Constants.TRY_STATEMENT_WITH_CATCH_SIMILARITY + Constants.COMMA_DELIMITER +
//	Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER+
//	Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER + 

}
