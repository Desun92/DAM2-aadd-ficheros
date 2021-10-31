package es.iestetuan.acv.directorios_ficheros;

import java.io.File;
import java.io.IOException;

import es.iestetuan.acv.dao.IDirectoriosFicheros;

public class CreacionDirectoriosFicheros implements IDirectoriosFicheros {
	
	public CreacionDirectoriosFicheros() {
		
	}
	
public boolean crearDirectorio(String ruta) {
		
		File directorio = new File(ruta);
		
		if(!directorio.exists())
			if(directorio.mkdirs()) 
				return true;
			else 
				return false;
		else
			return false;
	}

public boolean crearFichero(String ruta) {
	
		File directorio = new File(ruta);
		
		try {
			if(!directorio.exists())
				if(directorio.createNewFile())
					return true;
				else
					return false;
			else
				return false;
		}
		catch(IOException ioex) {
			ioex.printStackTrace();
			return false;
		}
}

public void borrar(String ruta) {
	
	File directorio = new File(ruta);
	
	if(directorio.exists() && directorio.isDirectory()) {
		
		for(File fichero : directorio.listFiles()) {
			
			if(fichero.isDirectory()) {
				CreacionDirectoriosFicheros otro = new CreacionDirectoriosFicheros();
				otro.borrar(fichero.getPath());
				fichero.delete();
			}
			
			else
				fichero.delete();
				
		}
		directorio.delete();
	}
	
	else if(directorio.exists())
		directorio.delete();
	
}

public void crearFicheroNombre(String ruta, String nombre) {
	
	File directorio = new File(ruta);
	
	try{
	
		if(directorio.exists()) {
			
			for(File fichero : directorio.listFiles()){
				
				if(fichero.isDirectory()) {
					CreacionDirectoriosFicheros otro = new CreacionDirectoriosFicheros();
					otro.crearFicheroNombre(fichero.getPath(), nombre);
				}
				
			}
			File nueva = new File(directorio.getPath()+"\\"+nombre);
			nueva.createNewFile();
		}
		
		else
			directorio.createNewFile();
		
	}
	
	catch(IOException ex) {
		ex.printStackTrace();
	}
	
}

}
