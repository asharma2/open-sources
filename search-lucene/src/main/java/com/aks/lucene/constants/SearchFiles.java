package com.aks.lucene.constants;

public enum SearchFiles {

	TXT("txt");

	private String extn;

	private SearchFiles(String extn) {
		this.extn = extn;
	}

	public String getExtn() {
		return extn;
	}

}
