import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * En esta clase se lee un archivo especifico que contiene todas las propiedades de exactemente 6 programas
 * y las guarda en un array para retornarlo y poder utilizar estos programas en la RAM.
 * 
 * @author Sebastian Estrada
 * @since 16/09/2021
 * @version 1.0
 */
class Archivo{
    private BufferedReader lector; // Esta propiedad es la que lee el archivo csv
    private String linea; // Es un string que guardara linea por linea lo que dice el archivo csv
    private String[] partes = new String[3]; // Es un array que se para por partes de cada linea
    private ArrayList<Programa> programas = new ArrayList<Programa>(); // Guarda los 6 programas para el posterior uso

    /**
     * Este metodo es el que lee por completo el archivo y settea el array de programas, y para esto utiliza como parametro 
     * un string con la ruta del archivo
     * @param ruta
     */
    public Archivo(String ruta){
        try {
            lector = new BufferedReader(new FileReader(ruta));
            for (int i = 0; i<=5; i++){
                if ((linea = lector.readLine()) != null){
                    partes = linea.split(";");
                    programas.add(new Programa(partes[0],Integer.parseInt(partes[1]), Integer.parseInt(partes[2])));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * Este metodo es un getter que retorna el array de programas
     * @return retorna un array de tipo Programa
     */
    public ArrayList<Programa> getProgramas(){
        return programas;
    }
}