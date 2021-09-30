package es.iestetuan.acv.dao.vo;

public class Profesor extends Persona {
		
		private String departamento;
		
		public Profesor() {
			
		}
		
		public Profesor(String nie, String nombre, String apellido1, String apellido2, String email, String dpto) {
			super(nie,nombre,apellido1,apellido2,email);
			this.departamento = dpto;
		}

		public String getDepartamento() {
			return departamento;
		}

		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}
		
	}
