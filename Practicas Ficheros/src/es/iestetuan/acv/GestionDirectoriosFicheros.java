package es.iestetuan.acv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import es.iestetuan.acv.directorios_ficheros.CreacionDirectoriosFicheros;

public class GestionDirectoriosFicheros {
	
	public static void main(String[] args) {

		Properties confi = new Properties();
		InputStream in = null;
		CreacionDirectoriosFicheros directorio = new CreacionDirectoriosFicheros();
		JsonObject propiedadesJson = null;
		
		try {
			BufferedReader leer =new BufferedReader(new FileReader("C:\\Users\\alumnoA\\git\\repository2(practicas_ficheros)\\Practicas Ficheros\\recursos\\info-configuracion.json"));
			String json="";
			String linea="";
			
			while((linea=leer.readLine())!=null){
				json+=linea;
			}
			
			propiedadesJson = JsonParser.parseString(json).getAsJsonObject();
			
			
			//Implementacion de properties
			//in = new FileInputStream("D:\\Clase\\Repositorios\\Eclipse\\DAM2-aadd-ficheros\\Practicas Ficheros\\recursos\\info-configuracion.properties");
			//confi.load(in);
		}
		catch(IOException ioex) {
			System.err.println("No se ha podido encontrar el archivo de configuraci�n");
			ioex.printStackTrace();
		}
		
		//Creacion directorios
		for(int i=1;i<=8;i++) {
			//Properties
			//directorio.crearDirectorio(confi.getProperty("ruta"+i));
			//JSON
			//directorio.crearDirectorio(propiedadesJson.get("ruta"+i).getAsString());
		}
		
		//Creacion ficheros vacios
		//Properties
		//directorio.crearFicheroNombre(confi.getProperty("ruta0"), "info-temporal.txt");
		//JSON
		//directorio.crearFicheroNombre(propiedadesJson.get("ruta0").getAsString(), "info-temporal.txt");
		
		//Borrado ficheros
		//Properties
		//directorio.borrar(confi.getProperty("ruta0"));
		//JSON
		//directorio.borrar(propiedadesJson.get("ruta0").getAsString());
	
}
	
}
