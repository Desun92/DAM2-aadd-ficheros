package es.iestetuan.acv.dao.vo;

public abstract class Persona {
		
		private String nie;
		private String nombre;
		private String apellido1;
		private String apellido2;
		private String email;
		
		public Persona() {
			
		}
		
		public Persona(String nie, String nombre, String apellido1, String apellido2, String email) {
			this.nie = nie;
			this.nombre = nombre;
			this.apellido1 = apellido1;
			this.apellido2 = apellido2;
			this.email = email;
		}

		public String getNie() {
			return nie;
		}

		public void setNie(String nie) {
			this.nie = nie;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido1() {
			return apellido1;
		}

		public void setApellido1(String apellido1) {
			this.apellido1 = apellido1;
		}

		public String getApellido2() {
			return apellido2;
		}

		public void setApellido2(String apellido2) {
			this.apellido2 = apellido2;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
		
	}

