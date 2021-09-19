/**
 * En esta clase se establece que es un programa y que se necesita que tenga para que exista en una memoria RAM
 * 
 * @author Sebastian Estrada
 * @since 16/09/2021
 * @version 1.0
 */
class Programa{
    private String nombre; // Guarda un String con el nombre del programa
    private int espacio;// Guarda un int con el espacio que ocupa el programa en la RAM
    private int ciclos; // Guarda un int que contiene la cantidad de ciclos de reloj va a estar este programa

    /**
     * En este metodo se setean las 3 propiedades de lo que es un programa especifico. Como parametros tenemos un string
     * que para el nombre, y dos ints, uno para los ciclos y otro para el espacio que ocupa
     * @param nom
     * @param esp
     * @param cicl
     */
    public Programa (String nom, int esp, int cicl){
        nombre = nom;
        espacio = esp;
        ciclos = cicl;
    }
    /**
     * Este metodo es un setter de los ciclos, este metodo permite actualizar los ciclos que tiene un programa especifico
     * como parametro tiene un int que actualiza a los ciclos.
     * @param cicl
     */
    public void setCiclos(int cicl){
        ciclos = cicl;
    }
    /**
     * Este es un metodo getter en el que se retorna el nombre del programa
     * @return retorna un String
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Este es un metodo getter para el espacio que ocupa un programa
     * @return retorna un double
     */
    public double getEspacio(){
        return espacio;
    }
    /**
     * Este es un metodo getter para la cantidad de ciclos de reloj
     * @return retorna un int
     */
    public int getCiclos(){
        return ciclos;
    }
}