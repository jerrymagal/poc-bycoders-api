package br.com.bycoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.bycoders.Constants;
import br.com.bycoders.exception.StorageException;
import br.com.bycoders.service.StorageService;

@RestController
@RequestMapping(path = Constants.CONTROLLER.FILE.PATH)
public class FileUploadController {
	
	@Autowired
	private StorageService storageService;
	
	@PostMapping
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@ExceptionHandler(StorageException.class)
	public ResponseEntity<?> handleStorageException(StorageException exc) {
		return ResponseEntity.badRequest().body(exc.getMessage());
	}

}
