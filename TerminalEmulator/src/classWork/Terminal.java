package classWork;

import java.io.File;

public class Terminal {

	private String ruta;
	private String[] filesName;
	private File manegarFile;

	public Terminal(String ruta) {
		this.ruta = ruta;
		this.manegarFile = new File(ruta);
	}
    
	
	public String lsCommando() {
		String result = "";
		filesName = manegarFile.list();
		for(String file : filesName) {
			result += file +"\n"; 
			
		}
		return result;
		
	}
}
