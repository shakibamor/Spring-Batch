package com.mhoveidafar.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mhoveidafar.batch.fileservice.FileStorageService;

@RestController
public class EmployeeController {

	@Autowired
	FileStorageService fileStorageService;

	@Autowired
	Job job;

	@Autowired
	JobLauncher jobLauncher;

	@PostMapping("/uploadFileEmployee")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

		String fileName = fileStorageService.storeFile(file);

		JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, params);
		return "CSV data are saved in DB Successfully";
	}
}
