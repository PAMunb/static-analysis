package br.unb.cic.sa.model;

public class Lock {

	private String file;
	private int startLine;
	private int endLine;
	private String type; 
	private boolean callLock;
	private boolean callUnlock;
	
	public Lock(String file, int startLine, int endLine, String type) {
		this.file = file;
		this.startLine = startLine;
		this.endLine = endLine;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCallLock() {
		return callLock;
	}

	public void setCallLock(boolean callLock) {
		this.callLock = callLock;
	}

	public boolean isCallUnlock() {
		return callUnlock;
	}

	public void setCallUnlock(boolean callUnlock) {
		this.callUnlock = callUnlock;
	}
	
	
}
