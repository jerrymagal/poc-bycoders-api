package br.com.bycoders.service;

import static java.nio.file.Files.createDirectory;
import static java.nio.file.Files.exists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.bycoders.config.StorageProperties;
import br.com.bycoders.entities.Cnab;
import br.com.bycoders.exception.StorageException;
import br.com.bycoders.repository.CnabRepository;

@Service
public class FileUploadService implements StorageService {
	
	private final Path rootLocation;
	
	@Autowired
	private CnabRepository cnabRepository;
	
	@Autowired
	public FileUploadService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	@PostConstruct
	public void init() {
		try {
			if(!exists(rootLocation)) {
				createDirectory(rootLocation);
			}
		} catch (IOException e) {
			throw new StorageException("Could not initialize storage", e);
		}
	}

	@Override
	public void store(MultipartFile file) {
		try {
			
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
			}
			
			Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
			
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
			
			BufferedReader reader = Files.newBufferedReader(destinationFile);
			reader.lines().forEach(line -> cnabRepository.save(Cnab.build(line)));
			
			Files.deleteIfExists(destinationFile);
			
		} catch (IOException e) {
			throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
		}
	}
}
