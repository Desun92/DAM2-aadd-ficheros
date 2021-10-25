package es.iestetuan.acv;

import java.util.List;

import es.iestetuan.acv.dao.IAlumno;
import es.iestetuan.acv.dao.vo.Alumno;
import es.iestetuan.acv.fictexto.AlumnoFicheroDAO;
import es.iestetuan.acv.xml.*;

public class GestionUsuarios {

	public static void main(String[] args) {
		
		
		/*Leer un usuario TXT
		
			Alumno alumno = new Alumno();
			IAlumno leer = new AlumnoFicheroDAO();
			
			alumno=leer.getAlumno(318);
			System.out.println(alumno.getNombre()+"\n");
			
		*/
		
		//Leer todos TXT
		
			IAlumno leer = new AlumnoFicheroXML();
			List<Alumno> lista = leer.getAlumnos();
			IAlumno fichero = new AlumnoFicheroXML();
			
			fichero.guardarAlumnos(lista);
			
		
		
		//-----------------------------------------------
		
		/*Leer un usuario XML
		 
			Alumno alumno = new Alumno();
			IAlumno leer = new AlumnoFicheroXML();
			
			alumno=leer.getAlumno(171);
			System.out.println(alumno.getNombre());
		
		*/
		
		/*Lista usuarios XML
		  
			IAlumno leer = new AlumnoFicheroXML();
			List<Alumno> listaAlumnos = new ArrayList<Alumno>();
			listaAlumnos = leer.getAlumnos();
			
			for(Alumno alumno : listaAlumnos) {
				System.out.println(alumno.getNombre()+" "+alumno.getNia());
			}
			
		*/
		
		//Transformacion a XML
	}

}
