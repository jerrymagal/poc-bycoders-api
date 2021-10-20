package br.com.bycoders;

public interface Constants {
	
	interface CONTROLLER {
		
		String VERSION = "v1";
		String PATH_SEPARATOR = "/";
		
		interface FILE {
			
			String NAME = "file";
			String PATH = PATH_SEPARATOR + VERSION + PATH_SEPARATOR + NAME;
		}
		
		interface CNAB {
			
			String NAME = "cnab";
			String PATH = PATH_SEPARATOR + VERSION + PATH_SEPARATOR + NAME;
		}
	}
}
