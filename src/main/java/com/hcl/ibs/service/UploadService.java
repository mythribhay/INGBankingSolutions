package com.hcl.ibs.service;


import org.springframework.web.multipart.MultipartFile;

import com.hcl.ibs.dto.UploadFileResponseDto;



public interface UploadService {
	
	public UploadFileResponseDto uploadFile(MultipartFile file);

}
