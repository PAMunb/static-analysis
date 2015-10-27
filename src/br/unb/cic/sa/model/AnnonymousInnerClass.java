package br.unb.cic.sa.model;

public class AnnonymousInnerClass {

	private String file;
	private int startLine;
	private int endLine;
	private boolean pInterface;
	private boolean pSinglMethod;
	private boolean pNoReferenceToThisOrSuper;
	private boolean pNoRecursiveCall; 
	
	public AnnonymousInnerClass(String file, int startLine, int endLine) {
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

	public boolean ispInterface() {
		return pInterface;
	}

	public void setpInterface(boolean pInterface) {
		this.pInterface = pInterface;
	}

	public boolean ispSinglMethod() {
		return pSinglMethod;
	}

	public void setpSinglMethod(boolean pSinglMethod) {
		this.pSinglMethod = pSinglMethod;
	}

	public boolean ispNoReferenceToThisOrSuper() {
		return pNoReferenceToThisOrSuper;
	}

	public void setpNoReferenceToThisOrSuper(boolean pNoReferenceToThisOrSuper) {
		this.pNoReferenceToThisOrSuper = pNoReferenceToThisOrSuper;
	}

	public boolean ispNoRecursiveCall() {
		return pNoRecursiveCall;
	}

	public void setpNoRecursiveCall(boolean pNoRecursiveCall) {
		this.pNoRecursiveCall = pNoRecursiveCall;
	}
	
	

}
