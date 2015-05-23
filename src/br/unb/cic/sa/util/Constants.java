package br.unb.cic.sa.util;

public interface Constants {
	
	/**
	 * Csv Files Output
	 */
	String CSV_METHODS = "methods.csv";
	String CSV_METHOD_WITH_VARGS = "methodVargs.csv";
	String CSV_TRYS = "trys.csv";
	String CSV_TRY_WITH_SIMILAR_CATCH = "tryWithSimilarCatch.csv";
	String CSV_TYPE = "types.csv";
	String CSV_PARAMTYPE = "parameterizedTypes.csv";
	
	String PROJECT_NAME = "Project Name";
	String VERSION_PROJECT = "Version Project";
	

	String COMMA_DELIMITER = ",";
	String NEW_LINE = "\n";
	
	String START_NUMEBER_LINE = "Start in line";
	String END_NUMEBER_LINE = "End in line";
	String NUMBER_TOTAL_LINE_IN_PROJECT = "Total lines in project";
	String NUMBER_TOTAL_OF_STATEMENTS = "Total Statements";
	String NUMBER_OF_TRYSTATEMENTS = "Total TryStatements";
	String NUMBER_OF_METHOD_DECLARATION = "Total Methods";
	String NUMBER_OF_TYPE_DECLARATION = "Total Types";
	String NUMBER_OF_PARAMETERIZED_TYPES = "Total Parameterized Types";
	String NUMBER_TOTAL_LINES_OF_CODE = "Total lines of code";
	
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
	
	
	String HEADER_OUTPUT_CSV = 
			Constants.PROJECT_NAME + Constants.COMMA_DELIMITER +
			Constants.VERSION_PROJECT + Constants.COMMA_DELIMITER +
			Constants.NUMBER_OF_METHOD_DECLARATION + Constants.COMMA_DELIMITER +
			Constants.NUMBER_OF_TRYSTATEMENTS + Constants.COMMA_DELIMITER +
			Constants.NUMBER_OF_TYPE_DECLARATION + Constants.COMMA_DELIMITER +
			Constants.NUMBER_OF_PARAMETERIZED_TYPES + Constants.COMMA_DELIMITER +
			Constants.NUMBER_TOTAL_OF_STATEMENTS + Constants.COMMA_DELIMITER +
			Constants.NUMBER_TOTAL_LINES_OF_CODE + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;
	
//	method Declatarion, start, end, try statement, start, end
	String SUB_HEADER_OUTPUT_METHODS_CSV = 
			Constants.METHOD + Constants.COMMA_DELIMITER +
			Constants.PACKAGE + Constants.COMMA_DELIMITER +
			Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;

	String SUB_HEADER_OUTPUT_TYPES = 
			Constants.TYPE + Constants.COMMA_DELIMITER +
			Constants.PACKAGE + Constants.COMMA_DELIMITER +
			Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;
	
	String SUB_HEADER_OUTPUT_TRY = 
			Constants.FILE + Constants.COMMA_DELIMITER +
			Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER +
			Constants.NEW_LINE;

	
//	Constants.TRY_STATEMENT_WITH_CATCH_SIMILARITY + Constants.COMMA_DELIMITER +
//	Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER+
//	Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER + 

}