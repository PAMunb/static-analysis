package br.unb.cic.sa.model;

/**
 * This class captures the places in the 
 * source code where occur a call to getEngineByName or 
 * eval methos. 
 * 
 * @author rbonifacio
 */
public class ScriptingEngineCall {

	private String file;
	private int startLine;
	private int endLine; 
	private String method;

	public ScriptingEngineCall(String file, int startLine, int endLine, String method) {
		this.file = file;
		this.startLine = startLine;
		this.endLine = endLine;
		this.method = method;
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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
}
