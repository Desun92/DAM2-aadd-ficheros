package es.iestetuan.acv.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import es.iestetuan.acv.dao.IAlumno;
import es.iestetuan.acv.dao.vo.Alumno;

public class AlumnoFicheroXML implements IAlumno {

	public Alumno getAlumno(long nia) {
		
		Alumno devolver = new Alumno();
		
		try {
		
			File fichero = new File("recursos/alumnos-dam2-nuevos.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fichero);
			doc.getDocumentElement().normalize();
			NodeList listaAlumnos = doc.getElementsByTagName("alumno");
			
			for(int i=0; i<listaAlumnos.getLength(); i++) {
				
				Node nodoAlumno = listaAlumnos.item(i);
				Element alumno = (Element) nodoAlumno;
					
					String id = alumno.getAttribute("id");
					long niaComparar=Long.parseLong(id);
					
					if(niaComparar == nia) {
						NodeList contenidoNombre = alumno.getElementsByTagName("nombre");
						String nombreAlumno = contenidoNombre.item(0).getTextContent();
						
						NodeList contenidoApellido1 = alumno.getElementsByTagName("apellido1");
						String apellido1Alumno = contenidoApellido1.item(0).getTextContent();
						
						NodeList contenidoApellido2 = alumno.getElementsByTagName("apellido2");
						String apellido2Alumno = contenidoApellido2.item(0).getTextContent();
						
						devolver.setNombre(nombreAlumno);
						devolver.setApellido1(apellido1Alumno);
						devolver.setApellido2(apellido2Alumno);
						
						break;
					}
					
				
			}
		
		}
		
		catch(ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		catch(SAXException e) {
			e.printStackTrace();
		}
		
		return devolver;
	}
	public List<Alumno> getAlumnos(){
		
		Properties propiedades = new Properties();
		InputStream entrada = null;
		ArrayList<Alumno> listaAlumnosDevolver = new ArrayList<Alumno>();
		
		try {
			
				entrada = new FileInputStream("recursos/origen-destino.properties");
				propiedades.load(entrada);
				File fichero = new File(propiedades.getProperty("destino"));
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fichero);
				doc.getDocumentElement().normalize();
				NodeList listaAlumnos = doc.getElementsByTagName("alumno");
				
				for(int i=0; i<listaAlumnos.getLength(); i++) {
					
					Alumno alumnoAnyadir = new Alumno();
					
					Node nodoAlumno = listaAlumnos.item(i);
					Element alumno = (Element) nodoAlumno;
					
					String id = alumno.getAttribute("nia");
					long nia = Long.parseLong(id);
					
					NodeList contenidoNombre = alumno.getElementsByTagName("nombre");
					String nombre = contenidoNombre.item(0).getTextContent();
					
					NodeList contenidoApellido1 = alumno.getElementsByTagName("apellido1");
					String apellido1 = contenidoApellido1.item(0).getTextContent();
					
					NodeList contenidoApellido2 = alumno.getElementsByTagName("apellido2");
					String apellido2 = contenidoApellido2.item(0).getTextContent();
					
					alumnoAnyadir.setNia(nia);
					alumnoAnyadir.setNombre(nombre);
					alumnoAnyadir.setApellido1(apellido1);
					alumnoAnyadir.setApellido2(apellido2);
					
					listaAlumnosDevolver.add(alumnoAnyadir);
					
				}
			}	
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaAlumnosDevolver;
	}
	public void guardarAlumnos(List<Alumno> alumnos) {
		
		Properties propiedades = new Properties();
		InputStream entrada = null;
		Document documento = null;
		
		try {
			
			entrada = new FileInputStream("recursos/origen-destino.properties");
			propiedades.load(entrada);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			DOMImplementation domImpl = dBuilder.getDOMImplementation();
			documento = domImpl.createDocument(null, "alumnos", null);
			
			//Crear nodo raiz
		//	Element raiz = documento.createElement("alumno");
		//	documento.getDocumentElement().appendChild(raiz);
			
			//Informacion nodos internos
			Element nodoAlumno = null;
			Element nodoDatos = null;
			Text texto = null;
			Attr atributo = null;
			
			for(Alumno alumno : alumnos) {
				
				//Creo la cabecera
				nodoAlumno = documento.createElement("alumno");
				atributo = documento.createAttribute("nia");
				documento.getDocumentElement().appendChild(nodoAlumno);
				
				//Le asigno valor al atributo y lo asigno al elemento cabecera
				atributo.setValue(String.valueOf(alumno.getNia()));
				nodoAlumno.setAttribute(atributo.getName(), atributo.getValue());;
				
				nodoDatos = documento.createElement("nie");
				nodoAlumno.appendChild(nodoDatos);
				texto=documento.createTextNode(alumno.getNie());
				nodoDatos.appendChild(texto);
				
				//Creo un elemento hijo y lo añado al padre
				nodoDatos = documento.createElement("nombre");
				nodoAlumno.appendChild(nodoDatos);
				//Le asigno valor
				texto=documento.createTextNode(alumno.getNombre());
				nodoDatos.appendChild(texto);
				
				// Y así con todos los restantes
				nodoDatos = documento.createElement("apellido1");
				nodoAlumno.appendChild(nodoDatos);
				texto=documento.createTextNode(alumno.getApellido1());
				nodoDatos.appendChild(texto);
				
				nodoDatos = documento.createElement("apellido2");
				nodoAlumno.appendChild(nodoDatos);
				texto=documento.createTextNode(alumno.getApellido2());
				nodoDatos.appendChild(texto);
				
				nodoDatos = documento.createElement("email");
				nodoAlumno.appendChild(nodoDatos);
				texto=documento.createTextNode(alumno.getEmail());
				nodoDatos.appendChild(texto);
				
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(documento);
			StreamResult result = new StreamResult(new File(propiedades.getProperty("destino")));
			transformer.transform(source, result);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void altaAlumno(Alumno alumno) {
		
		AlumnoFicheroXML alumnoFicheroXML = new AlumnoFicheroXML();
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		listaAlumnos = alumnoFicheroXML.getAlumnos();
		boolean esta = false;
		
		for(Alumno alumnito : listaAlumnos) {
			if(alumnito.getNia() == alumno.getNia()) {
				esta = true;
				break;
			}
		}
		
		if(!esta) {
			listaAlumnos.add(alumno);
			listaAlumnos.sort(new Comparator<Alumno>() {
				public int compare(Alumno a, Alumno b) {
					return a.getApellido1().compareTo(b.getApellido1());
				}
			});
			alumnoFicheroXML.guardarAlumnos(listaAlumnos);
		}		
	}
	public void borrarAlumno(long nia) {
		
		AlumnoFicheroXML alumnosXML = new AlumnoFicheroXML();
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		listaAlumnos = getAlumnos();
		int indice = 0;
		boolean esta = false;
		
		for(Alumno alumno : listaAlumnos) {
			if(alumno.getNia() == nia) {
				esta = true;
				break;
			}
			indice++;
		}
		
		if(esta) {
			listaAlumnos.remove(indice);
			alumnosXML.guardarAlumnos(listaAlumnos);
		}
	}
	public void modificarAlumno(Alumno alumno) {
		
		AlumnoFicheroXML lista = new AlumnoFicheroXML();
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		listaAlumnos = lista.getAlumnos();
		boolean esta = false;
		int indice = 0;
		
		for(Alumno alumnito : listaAlumnos) {
			if(alumnito.getNia() == alumno.getNia()) {
				esta = true;
				break;
			}
			indice++;
		}
		
		if(esta) {
			listaAlumnos.set(indice, alumno);
			listaAlumnos.sort((Alumno a, Alumno b) -> a.getApellido1().compareTo(b.getApellido1()));
			lista.guardarAlumnos(listaAlumnos);
		}
		
	}
}