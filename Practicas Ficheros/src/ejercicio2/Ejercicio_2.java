package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ejercicio_2 {

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			Ejercicio_2 cuaderno = new Ejercicio_2();
			String frase;
			
			System.out.println("Añade linea...");
			frase=sc.nextLine();
			
			//cuaderno.AñadirLinea(frase);
			
			if(cuaderno.AñadirLinea2(frase))
				System.out.println("Operación realizada con éxito");
			else
				System.out.println("No se pudo completar la operación");
			
			if(sc!=null)
				sc.close();
		}
		
		public void AñadirLinea(String frase) {
			
			BufferedWriter escribir = null;
			
			try {
				escribir = new BufferedWriter(new FileWriter("C:\\Users\\alumnoA\\Desktop\\Eclipse Workspace\\Leer fichero json\\info_fichero.txt",true));
				escribir.append(frase);
				escribir.newLine();	
			}
			
			catch(IOException ioex) {
				ioex.printStackTrace();
			}
			
			finally {
				try {
					if(escribir!=null)
						escribir.close();
				}
				catch(IOException ioex2) {
					ioex2.printStackTrace();
				}
			}
			
		}
		
		public boolean AñadirLinea2(String frase) {
			
			boolean operacionRealizada=false;
			PrintStream oute = null;
			FileOutputStream escribir = null;
			PrintStream sdout = System.out;
			
			try {
				
				escribir = new FileOutputStream("C:\\Users\\alumnoA\\Desktop\\Eclipse Workspace\\Practicas Ficheros\\info_fichero.txt",true);
				oute = new PrintStream(escribir);
				System.setOut(oute);
				System.out.println(frase);
				operacionRealizada=true;
				System.setOut(sdout);
				
			}
			
			catch(FileNotFoundException fnf) {
				fnf.printStackTrace();
			}
			
			finally {
				try {
					if(escribir!=null)
						escribir.close();
					if(oute!=null)
						oute.close();
				}
				catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
			
			return operacionRealizada;
		}

	}

	

