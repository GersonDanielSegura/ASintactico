package al;

import asintactico.EJECUTADOR;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivo {
    String[] lineas;
    File archivo;
    String ruta = "src/datos/codigo.txt";

    public void abrirArchivo() throws FileNotFoundException, IOException {
        /*archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("No se encontro el archivo en la ruta especificada, seleccione un archivo...");
            JFileChooser promptFile = new JFileChooser();
            promptFile.setFileFilter(new FileNameExtensionFilter("Documentos", "txt"));
            int option = promptFile.showDialog(null, "Seleccionar");
            //System.out.println(option);
            System.out.println("Nueva ruta: "+promptFile.getSelectedFile().toString());
            System.out.println("");
            archivo = new File(promptFile.getSelectedFile().toString());
        }*/
              archivo =new File ("archivo.txt");
        PrintWriter escribir;
        try {
            escribir =new PrintWriter(archivo);
            escribir.print(EJECUTADOR.codigo.getText());
            escribir.close();
        } catch (Exception e) {
        }
                try {
              BufferedReader reader = new BufferedReader (new FileReader("archivo.txt"));
        } catch (Exception e) {
        }
    }

    private void contarLineas() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        int i = 0;

        while (br.readLine() != null) {
            i++;
        }
        lineas = new String[i];
    }
  public void eliminarArchivo(){
          boolean estatus = archivo.delete();
    }
    public String[] leerArchivo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String cadena;
            int i = 0;
            contarLineas();

            while ((cadena = br.readLine()) != null) {
                lineas[i] = cadena;
                i++;
                //System.out.println(cadena);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return lineas;
    }
    
}