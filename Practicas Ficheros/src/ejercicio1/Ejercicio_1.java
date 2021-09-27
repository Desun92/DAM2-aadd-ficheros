package ejercicio1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.*;

public class Ejercicio_1 {
	
		
		Scanner sc = null;

		public static void main(String[] args) {
			
			/*
			FileInputStream in = null;
			String copiaIn;
			
			try {
				in = new FileInputStream("C:/xampp/htdocs/aadd/recursos/infoinstitutodam2.json");
				System.setIn(in);
				copiaIn=in.toString();
				System.out.println(copiaIn);
			}
			
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			
			finally {
				try {
					if(in!=null)
						in.close();
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
			*/
			
			Ejercicio_1 a = new Ejercicio_1();
			
			String ruta="C:/xampp/htdocs/aadd/recursos/infoinstitutodam2.json";
			String contenido;
			
			contenido=a.leerFichero(ruta);
			
			System.out.println(contenido);
		}
		
		public String leerFichero(String ruta) {
			
			String devolver="";
			BufferedReader leer=null;
			String otra="";
			
			try {
				leer = new BufferedReader(new FileReader(ruta));
				
				while((devolver=leer.readLine())!=null) {
					otra+=devolver;
				}
			}
			
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			
			catch(IOException ex) {
				ex.printStackTrace();
			}
			
			finally {
				try {
					if(leer!=null)
						leer.close();
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
			}
			
			if(sc!=null)
				sc.close();
			
			return otra;
		}

	}
