package es.iestetuan.acv.dao.vo;

public class Alumno extends Persona {
	
	private long nia;
	
	public Alumno() {
		
	}
	
	public Alumno(String nie, String nombre, String apellido1, String apellido2, String email, long nia) {
		super(nie,nombre,apellido1,apellido2,email);
		this.nia = nia;
	}

	public long getNia() {
		return nia;
	}

	public void setNia(long nia) {
		this.nia = nia;
	}

}

