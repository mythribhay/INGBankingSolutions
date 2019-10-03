package com.hcl.ibs.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.ibs.dto.UploadFileResponseDto;
import com.hcl.ibs.util.ExcelImportToDB;



@Service
public class UploadSeviceImpl implements UploadService {

	@Autowired
	private ExcelImportToDB excelImport;

	@Override
	public UploadFileResponseDto uploadFile(MultipartFile file) {

		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		return excelImport.loadDataToDB(file);
	}

}
