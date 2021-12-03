package com.tma.RestApiConnectDB.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tma.RestApiConnectDB.Model.FileDB;
import com.tma.RestApiConnectDB.Model.ResponseFile;
import com.tma.RestApiConnectDB.Model.ResponseMessage;
import com.tma.RestApiConnectDB.Service.FileStorageService;

@Controller
@RequestMapping("/api")
public class FileController {
	
	private static Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private FileStorageService storageService;
	
	@PostMapping("/upload")
	public ResponseEntity<FileDB> uploadFile(@RequestParam("file") MultipartFile file) {
		
		
		try {
			FileDB files = storageService.store(file);
			
			logger.info("upload thành công");

			return new ResponseEntity<>(files, HttpStatus.CREATED);
		} catch (Exception e) {
			
			logger.error("faild");

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		
		List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/files/").path(dbFile.getId()).toUriString();
			
			return new ResponseFile(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
		}).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		
		FileDB fileDB = storageService.getFile(id);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}

}
