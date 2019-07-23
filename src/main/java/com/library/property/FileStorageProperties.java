package com.library.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "storage")
public class FileStorageProperties {

	private String fileUploadDir;

	public String getFileUploadDir() {
		return this.fileUploadDir;
	}

	public void setFileUploadDir(String fileUploadDir) {
		this.fileUploadDir = fileUploadDir;
	}

}
