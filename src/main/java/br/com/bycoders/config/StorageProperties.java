package br.com.bycoders.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("storage")
public class StorageProperties {
	
	private String location = "upload-dir";
}
