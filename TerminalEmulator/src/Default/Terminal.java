package Default;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Terminal {

	private String ruta;
	private String[] filesName;
	private File manegarFile;

	public Terminal(String ruta) {	
		this.manegarFile = new File(ruta);
		this.ruta = ruta;
		this.filesName = manegarFile.list();
	}
    
	
	public String lsCommando() {
		String result = "";		
		Arrays.sort(filesName);
		for (String file : filesName) {
			result += file + "\n";

		}
		return result;
	}
	
	public String lsDetallesCommando() {
		String result ="";
		Arrays.sort(filesName);
		for (String file : filesName) {
			result += fileDetails(file)+ "\n";
		}
		
		return result;

	}
	public String fileDetails(String fichero) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		File nuevaRuta = new File(ruta + "\\" + fichero);
		String tipo = "Carpeta";
		char read = '-';
		char write = '-';
		char execute = '-';
		
		if(nuevaRuta.isFile()) {
			tipo = "Archivo";
		}
		if (nuevaRuta.canRead()) {
			read = 'R';
		}
		if (nuevaRuta.canWrite()) {
			write = 'W';
		}
		if (nuevaRuta.canExecute()) {
			execute = 'X';
		}
		fichero = fichero +"  ("+ tipo+")  ("+ sdf.format(nuevaRuta.lastModified())+")  "+read + write + execute +"  ("+nuevaRuta.length()+") bytes";
		
		return fichero;
	}
	
	public int mkdirComando() throws IOException {
		int codigo =0;
		Path fecheroNumbre = Paths.get(ruta);
		try {
			Files.createDirectories(fecheroNumbre);
			
		} catch (Exception e) {
			codigo = -1;
		}
	
		return codigo;
		
		
	}
    
	public int catComando() {
		int codigo =0;
		Path fecheroNumbre = Paths.get(ruta);
		try {
			Files.createFile(fecheroNumbre);
			
			
		} catch (Exception e) {
			codigo = -1;
		}
	
		return codigo;
		
	}
	public int rmComando() {
		int codigo =0;
		Path fecheroNumbre = Paths.get(ruta);
		try {
			Files.delete(fecheroNumbre);
			
			
		} catch (Exception e) {
			codigo = -1;
		}
	
		return codigo;
		
	}
    
}
