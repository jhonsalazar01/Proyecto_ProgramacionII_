package co.edu.uptc.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Esta clase se encarga de la persistencia
 * @author dilan
 *
 */
public class Archivo {

	/**
	 * Este metodo nos sobreescribe la informacion
	 * @param rutaArchivo
	 * @param texto
	 * @return
	 */
public boolean SobreEscribirArchivo(String rutaArchivo, String texto) {
		
		File archivo = new File("Puntajes/"+rutaArchivo);
		boolean existe = false;
		BufferedWriter bw;

		try {
			if (archivo.exists()) {

				bw = new BufferedWriter(new FileWriter(archivo));
				bw.write(texto + ";\n");
				existe = true;
			} else {
				bw = new BufferedWriter(new FileWriter(archivo));
				bw.write(texto);
				existe = false;

			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return existe;

	}

/**
 * Este metodo nos agrega informacion al archivo plano
 * @param rutaArchivo
 * @param info
 */
	public void AgregarContenidoArchivo(String rutaArchivo, String info) {
		String ruta = "Puntajes/" + rutaArchivo;
		File archivo = new File(ruta);

		try {
			FileWriter fstream = new FileWriter(archivo, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(info + "\n");
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Este metodo nos retorna la informacion y se especifica la ruta del archivo
	 * @param nombreArchivo
	 * @return
	 */
	public ArrayList<String> GetInfoContenido(String nombreArchivo) {
		String ruta = "Recursos/" + nombreArchivo;
		// Convierte archivo en objeto
		File archivo = new File(ruta);
		ArrayList<String> Datos = new ArrayList<String>();

		try {

			String fila = null;

			FileReader f = new FileReader(archivo);
			BufferedReader b = new BufferedReader(f);

			while ((fila = b.readLine()) != null) {
				Datos.add(fila);
			}

			b.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Datos;

	}

}
