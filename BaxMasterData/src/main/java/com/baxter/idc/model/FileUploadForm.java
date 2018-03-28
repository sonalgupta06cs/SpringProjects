package com.baxter.idc.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadForm {
	
	
	private CommonsMultipartFile  file;
	
	private String fileName;

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
