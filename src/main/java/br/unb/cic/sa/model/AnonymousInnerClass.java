package br.unb.cic.sa.model;

/**
 * This class maintains relevant information about 
 * anonymous inner classes. 
 * 
 * @author rbonifacio
 */
public class AnonymousInnerClass {
	private String file;
	private int startLine;
	private int endLine;
	private boolean predInterface;
	private boolean predSingleMethod;
	private boolean predNoReferenceToThisOrSuper;
	private boolean predNoRecursiveCall; 
	
	public AnonymousInnerClass(String file, int startLine, int endLine) {
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

	public boolean isPredInterface() {
		return predInterface;
	}

	public void setPredInterface(boolean predInterface) {
		this.predInterface = predInterface;
	}

	public boolean isPredSingleMethod() {
		return predSingleMethod;
	}

	public void setPredSingleMethod(boolean predSingleMethod) {
		this.predSingleMethod = predSingleMethod;
	}

	public boolean isPredNoReferenceToThisOrSuper() {
		return predNoReferenceToThisOrSuper;
	}

	public void setPredNoReferenceToThisOrSuper(boolean predNoReferenceToThisOrSuper) {
		this.predNoReferenceToThisOrSuper = predNoReferenceToThisOrSuper;
	}

	public boolean isPredNoRecursiveCall() {
		return predNoRecursiveCall;
	}

	public void setPredNoRecursiveCall(boolean predNoRecursiveCall) {
		this.predNoRecursiveCall = predNoRecursiveCall;
	}

		

}
