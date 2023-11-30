
/**
 * <h1><strong>Programa Java para generar un HTML con imágenes</strong></h1>
 * <br>
 * <p>Cristian Varela Casas</p>
 * <br>
 * <p>Fecha: 04/11/2023</p>
 * <br>
 * <p>Versión 1.0</p>
 * <br>
 * <p> Más información en <a href="www.google.es">google</a>
 * <br>
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class HTMLGenerator {
	
	/**
	 * Método principal que ejecuta las instrucciones<br>
	 * Lee un fichero, lee las imágenes de un directorio y escribe otro fichero en formato .html<br>
	 * @param args: son los parámetros externo de la línea de comandos.
	 */
	
	public static void main(String[] args) {
		// Configuration variables:
		
		String nombre = "Cristian";
		presentaPrograma(nombre);

		final String USER_PATH_TO_SRC = "C:\\DAW\\Programación\\ActividadesJava\\HTMLGenerator\\src";
		final String READ_FILE = "\\origen.txt";
		// Global variable declaration:
		File originalTxt = new File(USER_PATH_TO_SRC + READ_FILE);
		final String TAB = "\t", JUMP = "\n", OPEN_TR = "<tr>", CLOSE_TR = "</tr>", OPEN_TD = "<td>",
				CLOSE_TD = "</td>";
		String[] imgNames = new File(USER_PATH_TO_SRC).list();
		int imgNamesLength = imgNames.length;
		String line;

		// Extraction of all lines from the document and concatenation into a single
		// string:
		try {
			FileWriter pageHTML = new FileWriter(USER_PATH_TO_SRC + "\\galeria.html");
			
			/**
			 * Instanciación de un Scanner para leer el fichero.
			 */
			
			Scanner sc = new Scanner(originalTxt);
			int counter = 0;
			while (counter < 12) {
				line = sc.nextLine();
				pageHTML.write(line + JUMP);
				counter++;
			}

			counter = 0;

			for (int i = 0; i < imgNamesLength; i++) {

				if (imgNames[i].endsWith(".jpg")) {
					if (counter % 2 == 0) {
						pageHTML.write(TAB + OPEN_TR + JUMP);
					}
					String src = imgNames[i];
					String img = "<img src=\"" + src + "\" width=\"200\" height=\"200\" />";
					pageHTML.write(TAB.repeat(2) + OPEN_TD + JUMP);
					pageHTML.write(TAB.repeat(3) + img + JUMP);
					pageHTML.write(TAB.repeat(2) + CLOSE_TD + JUMP);
					counter++;
					if (counter % 2 == 0) {
						pageHTML.write(TAB + CLOSE_TR + JUMP);
					}
				}
			}

			if (counter % 2 != 0) {
				pageHTML.write(TAB + CLOSE_TR + JUMP);
			}

			if (counter == 0) {
				pageHTML.write(TAB + OPEN_TR + JUMP);
				pageHTML.write(TAB.repeat(3) + "<p>No hay ninguna imagen para mostrar</p>" + JUMP);
				pageHTML.write(TAB + CLOSE_TR + JUMP);
			}

			counter = 13;
			while (counter < 16) {
				line = sc.nextLine();
				pageHTML.write(line + JUMP);
				counter++;
			}

			sc.close();
			pageHTML.close();

			final String READ_HTML = "\\galeria.html";
			File htmlFile = new File(USER_PATH_TO_SRC + READ_HTML);
			sc = new Scanner(htmlFile);
			
			Date date = new Date();
			despedidaPrograma(nombre, date);

			while (sc.hasNextLine()) {
				line = sc.nextLine();
				System.out.println(line);
			}

		} catch (Exception exc) {
			System.out.println("Error en la escritura del fichero: ".concat(exc.getMessage()));
		}
	}
	
	/**
	 * Método que presenta el programa antes de ejecutarse<br>
	 * @param nombre Nombre del usuario de la app.
	 */
	
	public static void presentaPrograma(String nombre) {
		System.out.println("Hola " + nombre);
		System.out.println("Este programa te pide unos datos y los presenta");
		System.out.println("===============================================");
		System.out.println("Pulsa una tecla para continuar");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		sc.close();
	}
	
	
	/**
	 * Método de despedida de nuestro programa que nos indica la fecha
	 * @param dia Fecha actual.
	 * @param nombre Nombre de usuario.
	 */
	public static void despedidaPrograma(String nombre, Date dia) {
		System.out.println("Adiós " + nombre);
		System.out.println("Espero que el programa te haya gustado");
		System.out.println("Abandonado el " + dia);
		System.out.println("Pulsa una tecla para salir");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		sc.close();
	}
	
}
