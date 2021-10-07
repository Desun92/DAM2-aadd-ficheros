package es.iestetuan.acv.dao;

import java.io.IOException;

public interface IDirectoriosFicheros {
	
	public boolean crearDirectorio(String ruta);
	public boolean crearFichero(String ruta) throws IOException;

}
