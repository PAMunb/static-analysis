package br.unb.cic.sa.model;

/**
 * This class captures the places in the 
 * source code that occurs a call to getEngineByName or 
 * eval. 
 * 
 * @author rbonifacio
 */
public class ScriptingEngineCall extends AbsStatementModel {

	
	public ScriptingEngineCall(String file, String method, int startLine,
			int endLine) {
	
		this.setFile(file);
		this.setStartLine(startLine);
		this.setEndLine(endLine);
		this.setMethod(method);
	
	}



}
