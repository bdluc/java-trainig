package com.tma.RestApiConnectDB.Service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tma.RestApiConnectDB.Model.FileDB;
import com.tma.RestApiConnectDB.Repository.FileDBRepository;

@Service
public class FileStorageService {
	
	@Autowired
	  private FileDBRepository fileDBRepository;

	  

}
