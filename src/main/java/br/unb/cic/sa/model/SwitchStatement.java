package br.unb.cic.sa.model;

/**
 * This class captures relevant data about 
 * the use of Switch Statements.
 * 
 * @author rbonifacio
 */
public class SwitchStatement {

	private String file;
	private int startLine;
	private int endLine;
	private boolean switchString;
	
	public SwitchStatement(String file, int startLine, int endLine) {
		this.file = file;
		this.startLine = startLine;
		this.endLine = endLine;
	}
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public int getStartLine() {
		return startLine;
	}
	
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	
	public int getEndLine() {
		return endLine;
	}
	
	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public boolean isSwitchString() {
		return switchString;
	}

	public void setSwitchString(boolean switchString) {
		this.switchString = switchString;
	}
		
}
