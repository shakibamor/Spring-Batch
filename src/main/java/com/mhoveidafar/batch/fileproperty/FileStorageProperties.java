package com.mhoveidafar.batch.fileproperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// It says go to application properties, and use value of the line that starts with file
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}	
	

}
