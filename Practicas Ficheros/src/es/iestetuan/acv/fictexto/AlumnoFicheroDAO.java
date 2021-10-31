package es.iestetuan.acv.fictexto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import es.iestetuan.acv.dao.IAlumno;
import es.iestetuan.acv.dao.vo.Alumno;

public class AlumnoFicheroDAO implements IAlumno {
	
	public Alumno getAlumno(long nia) {
		
		Alumno devolver = new Alumno();
		BufferedReader bfin = null;
		String linea;
		String[] lineaPartida;
		long niaComparacion;
		boolean primeraLinea=true;
		
		try {
			bfin=new BufferedReader(new FileReader("recursos/alumnos-dam2-nuevos.txt"));
			
			while((linea=bfin.readLine())!=null) {
				if(primeraLinea)
					primeraLinea=false;
				else {
					lineaPartida=linea.split(",");
					niaComparacion=Long.parseLong(lineaPartida[0]);
					
					if(niaComparacion==nia) {
						devolver.setNia(niaComparacion);
						devolver.setNombre(lineaPartida[1]);
						devolver.setApellido1(lineaPartida[2]);
						devolver.setApellido2(lineaPartida[3]);
						break;
					}
				}
			}
		}
		
		catch(IOException ioex){
			ioex.printStackTrace();
		}
		
		finally {
			
			try {
				if(bfin!=null)
					bfin.close();
			}
			
			catch(IOException ioex2) {
				ioex2.printStackTrace();
			}
			
		}
		return devolver;
	}
	public List<Alumno> getAlumnos(){
		
		Properties propiedades = new Properties();
		InputStream entrada = null;
		List<Alumno> devolver=new ArrayList<Alumno>();
		BufferedReader bfin = null;
		boolean primeraLinea=true;
		String linea;
		String[] lineaPartida;
		
		
		try{
		
		entrada = new FileInputStream("recursos/origen-destino.properties");
		propiedades.load(entrada);
		bfin=new BufferedReader(new FileReader(propiedades.getProperty("origenTXT")));
		
		while((linea=bfin.readLine())!=null) {
			if(primeraLinea)
				primeraLinea=false;
			else {
				Alumno alumno = new Alumno();
				lineaPartida=linea.split(",");
				alumno.setNia(Long.parseLong(lineaPartida[0]));
				alumno.setNombre(lineaPartida[1]);
				alumno.setApellido1(lineaPartida[2]);
				alumno.setApellido2(lineaPartida[3]);
				devolver.add(alumno);
			}
		}
		}
		
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return devolver;
	}
	public void guardarAlumnos(List<Alumno> alumnos) {
		
	}
	
	public void altaAlumno(Alumno alumno) {
		
	}
	
	public void borrarAlumno(long nia) {
		
	}
	
	public void modificarAlumno(Alumno alumno) {
		
	}
}
