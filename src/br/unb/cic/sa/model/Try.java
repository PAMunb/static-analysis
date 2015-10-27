package br.unb.cic.sa.model;

public class Try extends AbsStatementModel {

//	Constants.FILE + Constants.COMMA_DELIMITER +
//	Constants.START_NUMEBER_LINE + Constants.COMMA_DELIMITER +
//	Constants.END_NUMEBER_LINE + Constants.COMMA_DELIMITER +
//	Constants.LOC_TOTAL + Constants.COMMA_DELIMITER +
//	Constants.LOC_BEFORE_REFACTORING + Constants.COMMA_DELIMITER +
//	Constants.LOC_AFTER_REFACTORING + Constants.COMMA_DELIMITER +
//	Constants.PROJECT_NAME + Constants.COMMA_DELIMITER +
//	Constants.VERSION_PROJECT + Constants.COMMA_DELIMITER +
//	Constants.NEW_LINE;
	
	private int LocBeforeRefactoring;
	private int LocAfterRefactoring;
	
	public Try(String file, int startLine, int endLine, int locBeforeRefactoring, int locAfterrefactoring){
		this.setFile(file);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
		
		this.setLocBeforeRefactoring(locBeforeRefactoring);
		this.setLocAfterRefactoring(locAfterrefactoring);
		
	}
	

	public int getLocBeforeRefactoring() {
		return LocBeforeRefactoring;
	}

	public void setLocBeforeRefactoring(int locBeforeRefactoring) {
		LocBeforeRefactoring = locBeforeRefactoring;
	}

	public int getLocAfterRefactoring() {
		return LocAfterRefactoring;
	}

	public void setLocAfterRefactoring(int locAfterRefactoring) {
		LocAfterRefactoring = locAfterRefactoring;
	}


	
	
	
	
}
