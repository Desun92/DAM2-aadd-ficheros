package es.iestetuan.acv.dao;

import java.util.List;

import es.iestetuan.acv.dao.vo.*;

public interface IAlumno {
	
	public Alumno getAlumno(long nia);
	public List<Alumno> getAlumnos();

}