package es.iestetuan.acv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonObject;

import es.iestetuan.acv.directorios_ficheros.CreacionDirectoriosFicheros;

public class GestionDirectoriosFicheros {
	
	public static void main(String[] args) {

		Properties confi = new Properties();
		InputStream in = null;
		CreacionDirectoriosFicheros directorio = new CreacionDirectoriosFicheros();
		JsonObject propiedadesJson = null;
		File ficheroXML;
		BufferedReader leer;
		FileInputStream leerXML;
		Document doc = null;
		NodeList nList = null;
		NodeList nListHijo = null;
		
		try {
	
			ficheroXML = new File("recursos/info-configuracion.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(ficheroXML);
			doc.getDocumentElement().normalize();
			nList = doc.getElementsByTagName("rutas");
			nListHijo = nList.item(0).getChildNodes();
			
		/*	for(int i=0;i<nListHijo.getLength();i++) {
				Node nNode = nListHijo.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Node nodoValor = eElement.getChildNodes().item(0);
					String clave = ((Node) eElement).getNodeName();
					System.out.println(nodoValor.getTextContent());
				}
			}
			
			*/
			
			/*IMPLEMENTACION DE JSON
			leer =new BufferedReader(new FileReader("C:\\Users\\alumnoA\\git\\repository2(practicas_ficheros)\\Practicas Ficheros\\recursos\\info-configuracion.json"));
			String json="";
			String linea="";
			
			while((linea=leer.readLine())!=null){
				json+=linea;
			}
			
			propiedadesJson = JsonParser.parseString(json).getAsJsonObject();
			*/
			
			//IMPLEMENTACION DE PROPERTIES
			//in = new FileInputStream("D:\\Clase\\Repositorios\\Eclipse\\DAM2-aadd-ficheros\\Practicas Ficheros\\recursos\\info-configuracion.properties");
			//confi.load(in);
		}
		catch(IOException ioex) {
			System.err.println("No se ha podido encontrar el archivo de configuraci�n");
			ioex.printStackTrace();
		}
		catch(org.xml.sax.SAXException saxe) {
			saxe.printStackTrace();
		}
		catch(ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		//Creacion directorios
		for(int i=1;i<=8;i++) {
			//Properties
			//directorio.crearDirectorio(confi.getProperty("ruta"+i));
			//JSON
			//directorio.crearDirectorio(propiedadesJson.get("ruta"+i).getAsString());
		}
		
		//Creacion directorios XML
		for(int i=0;i<nListHijo.getLength();i++) {
			Node nNode = nListHijo.item(i);
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				Node nodoValor = eElement.getChildNodes().item(0);
				directorio.crearDirectorio(nodoValor.getTextContent());
			}
		}
		
		//Creacion ficheros vacios
		//Properties
		//directorio.crearFicheroNombre(confi.getProperty("ruta0"), "info-temporal.txt");
		//JSON
		//directorio.crearFicheroNombre(propiedadesJson.get("ruta0").getAsString(), "info-temporal.txt");
		//XML
		Node nNode = nListHijo.item(1);
		Element eElement = (Element) nNode;
		Node nodoValor = eElement.getChildNodes().item(0);
		directorio.crearFicheroNombre(eElement.getTextContent(), "info-temporal.txt");
		
		
		//Borrado ficheros
		//Properties
		//directorio.borrar(confi.getProperty("ruta0"));
		//JSON
		//directorio.borrar(propiedadesJson.get("ruta0").getAsString());
		//XML
		directorio.borrar(eElement.getTextContent());
}
	
}
