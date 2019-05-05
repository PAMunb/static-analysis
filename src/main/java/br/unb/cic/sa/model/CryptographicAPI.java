package br.unb.cic.sa.model;

public class CryptographicAPI {

	private String file; 
	private String api; 
	private String detail; 
	
	public CryptographicAPI(String file, String api, String detail) {
		this.file = file; 
		this.api = api; 
		this.detail = detail;
	}

	public String getFile() {
		return file;
	}

	public String getApi() {
		return api;
	}
	
	public String getDetail() {
		return detail;
	}
	
}
