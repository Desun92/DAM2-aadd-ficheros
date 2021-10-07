package es.iestetuan.acv.directorios_ficheros;

import java.io.File;
import java.io.IOException;

import es.iestetuan.acv.dao.IDirectoriosFicheros;

public class GestionDirectoriosFicheros implements IDirectoriosFicheros {
	
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

public boolean crearFichero(String ruta) throws IOException {
	
		File directorio = new File(ruta);
		
		if(!directorio.exists())
			if(directorio.createNewFile())
				return true;
			else
				return false;
		else
			return false;
}

}
