package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_3 {

	public static void main(String[] args) {

		BufferedReader in = null;
		BufferedWriter out = null;
		String leer;
		String[] escribir;
		boolean primeraLinea=true;
		
		try {
			
			in = new BufferedReader(new FileReader("C:\\xampp\\htdocs\\aadd\\recursos\\alumnos-dam2-nuevos.txt"));
			out = new BufferedWriter(new FileWriter("C:\\Users\\alumnoA\\Desktop\\Eclipse Workspace\\Practicas Ficheros\\info_fichero.txt",true));
			
			while((leer=in.readLine())!=null) {
				
				if(!primeraLinea) {
					
					escribir=leer.split(",");
					out.write("\n");
					
					if(escribir.length>3) {
						String nombre=escribir[1];
						String apellido1=escribir[2];
						String apellido2=escribir[3];
						out.write(nombre+","+apellido1+apellido2);
					}
					
					else {
						String nombre=escribir[1];
						String apellido1=escribir[2];
						out.write(nombre+","+apellido1);
					}
				}
				primeraLinea=false;
			}
			
		}
		
		catch(IOException ioex) {
			ioex.printStackTrace();
		}
		
		finally {
			
			try {
				if(in!=null) 
					in.close();
				if(out!=null) 
					out.close();
			}
			catch(IOException ioex2) {
				ioex2.printStackTrace();
			}
			
		}

	}

}
