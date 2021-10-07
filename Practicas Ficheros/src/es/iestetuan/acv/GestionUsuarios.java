package es.iestetuan.acv;

import java.util.List;

import es.iestetuan.acv.dao.IUsuario;
import es.iestetuan.acv.dao.vo.Alumno;
import es.iestetuan.acv.fictexto.UsuarioFicheroDAO;

public class GestionUsuarios {

	public static void main(String[] args) {
		
		
		//Leer un usuario específico
		/*
			Alumno alumno = new Alumno();
			IUsuario leer = new UsuarioFicheroDAO();
			
			alumno=leer.getAlumno(318);
			System.out.println(alumno.getNombre()+"\n");
			
		*/
		
		//Leer todos
		
			IUsuario leer = new UsuarioFicheroDAO();
			List<Alumno> lista = leer.getAlumnos();
			
			for(Alumno indice : lista) {
				System.out.println(indice.getNombre());
			}
		
	
	}

}
