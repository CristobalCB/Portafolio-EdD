package dci.ed.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class AdministradorArchivo {
    private static final String ruta = "Guitarras.csv";

    /**
     * Método que lee un archivo .csv lo divide por líneas y cada línea la divide por comas.
     * @return ArrayList<String[]> ArrayList que contiene las caracteristicas de cada guitarra.
     */
    public static ArrayList<String[]> leerArchivo() {
        ArrayList<String[]> lineas = new ArrayList<String[]>();
        String linea = "";
        int numLineas = 0;
        try {
            FileReader fileReader = new FileReader(new File(ruta));
            BufferedReader buffer = new BufferedReader(fileReader);
            while ((linea = buffer.readLine()) != null) {
                numLineas++;
                if (numLineas > 1) {
                    lineas.add(linea.split(","));
                }
            }
            buffer.close();
            fileReader.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return lineas;
    }

    public static void escribirArchivo(){
        //Método no necesario por el momento.
    }
}
