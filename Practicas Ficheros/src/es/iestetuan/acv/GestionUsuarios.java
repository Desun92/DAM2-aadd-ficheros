package es.iestetuan.acv;

import java.util.ArrayList;
import java.util.List;

import es.iestetuan.acv.dao.IAlumno;
import es.iestetuan.acv.dao.vo.Alumno;
import es.iestetuan.acv.fictexto.AlumnoFicheroDAO;
import es.iestetuan.acv.xml.*;

public class GestionUsuarios {

	public static void main(String[] args) {
		
		
		/*LEER UN USUARIO TXT
		
			Alumno alumno = new Alumno();
			IAlumno leer = new AlumnoFicheroDAO();
			
			alumno=leer.getAlumno(318);
			System.out.println(alumno.getNombre()+"\n");
			
		*/
		
		/*LEER TODOS DESDE TXT (ARCHIVO TIPO PROPERTIES)
		
			IAlumno leer = new AlumnoFicheroDAO();
			List<Alumno> lista = leer.getAlumnos();
			IAlumno fichero = new AlumnoFicheroXML();
			
			fichero.guardarAlumnos(lista);
			
		*/
		
		//-----------------------------------------------
		
		/*LEER UN USUARIO XML
		 
			Alumno alumno = new Alumno();
			IAlumno leer = new AlumnoFicheroXML();
			
			alumno=leer.getAlumno(171);
			System.out.println(alumno.getNombre());
		
		*/
		
		//LISTA USUARIOS XML
		/*  
			IAlumno leer = new AlumnoFicheroXML();
			List<Alumno> listaAlumnos = new ArrayList<Alumno>();
			listaAlumnos = leer.getAlumnos();
			
			for(Alumno alumno : listaAlumnos) {
				System.out.println(alumno.getNombre()+" "+alumno.getNia());
			}
		*/	
		
		
		//DAR DE ALTA A LOS NUEVOS ALUMNOS (JULIA, FRANCISCO Y VALERY)
		
		IAlumno leer = new AlumnoFicheroDAO();
		List<Alumno> lista = leer.getAlumnos();
		IAlumno guardar = new AlumnoFicheroXML();
		
		for(Alumno alumno : lista) {
			guardar.altaAlumno(alumno);
		}
		
		
	}

}
