package br.unb.cic.sa.model;

/**
 * This class captures the places in the 
 * source code that occurs a call to getEngineByName or 
 * eval. 
 * 
 * @author rbonifacio
 */
public class ScriptingEngineCall {

	private String file;
	private String method;
	private int startLine;
	private int endLine;

	
	public ScriptingEngineCall(String file, String method, int startLine,
			int endLine) {
		this.file = file;
		this.method = method;
		this.startLine = startLine;
		this.endLine = endLine;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
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

}
