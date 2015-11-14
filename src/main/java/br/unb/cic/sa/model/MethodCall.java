package br.unb.cic.sa.model;

public class MethodCall {

	private String file;
	private String name;
	private String call;
	private int start;
	private int end;

	public MethodCall(String file, String name, String call, int start, int end) {
		this.file = file;
		this.name = name;
		this.call = call;
		this.start = start;
		this.end = end;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCall() {
		return call;
	}

	public void setType(String call) {
		this.call = call;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
