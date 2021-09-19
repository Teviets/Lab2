import java.util.Scanner;

/**
 * En esta clase se imprimen en consola cada parte relevante para el programa y permitir al usuario navegar
 * en el programa
 * 
 * @author Sebastian Estrada
 * @since 18/09/2021
 * @version 1.0
 */
class Vista{
    private int num;// Este es un int que guarda todos los ints que el usuario desee ingresar
    private String txt;// Este es un String que guarda todo lo que el usuario desea ingresar en forma de String
    private Scanner scan;// Esta variable es tipo scanner y es la que permite guardar la informacion en las otras dos varibles

    /**
     * Este metodo constructor solo establece que scan es un nuevo scanner que lee
     */
    public Vista(){
        scan = new Scanner(System.in);
    }
    /**
     * En este metodo se pone al usuario a escoger que tipo de memoria quiere utilizar
     * @return retorna un int con su eleccion
     */
    public int menu1(){
        System.out.println("\nSeleccione el inidice de la memoria deseada\n"+
                           "1. Memoria SDR\n" +
                           "2. Memoria DDR\n");
        scan = new Scanner(System.in);
        num = scan.nextInt();
        return num;
    }
    /**
     * Este metodo establece la cantidad de memoria que va a poseer la SDR si es la opcion que desea el usuario
     * @return retorna un int con la cantidad de GB que el usuario desea
     */
    public int getInfoSDR(){
        System.out.println("\nSeleccione la cantidad GB que desea que su memoria posea (Solo 4, 8, 12, 16, 32 o 64)\n");
        scan = new Scanner(System.in);
        num = scan.nextInt();
        return num;
    }

    public int indeceProgram(){
        System.out.println("\nSeleccione el indice del programa deseado\n");
        scan = new Scanner(System.in);
        num = scan.nextInt();
        return num;
    }

    /**
     * Este menu muestra todas las posibles acciones para ambos tipos de memoria RAM
     * @return retorna un int con la accion que el usuario desea
     */
    public int menu2 (){
        System.out.println("\nSeleccione el indice de las opciones que puede realizar con su memoria\n"+
                           "1. Nuevo programa\n"+
                           "2. Ver la cantidad de memoria RAM total\n" +
                           "3. Ver la cantidad de memoria RAM disponible para uso\n" +
                           "4. Ver la cantidad de memoria RAM en uso\n"+
                           "5. Ver los programas en ejecucion\n"+
                           "6. Ver los programas en cola de espera\n"+
                           "7. Ver los espacios que ocupa un programas (En bloques)\n"+
                           "8. Ver el estado de la memoria (Muestra los bloques libre y los ocupados)\n"+
                           "9. Nuevo ciclo de reloj (Actualiza toda la informacion de la memoria)\n"+
                           "10. Reinicio de la memoria\n");
        scan = new  Scanner(System.in);
        num = scan.nextInt();
        return num;
    }

    /**
     * Este es un metodo en el que el usuario crea un nuevo programa y establece el nombre del mismo
     * @return retorna un String con el nombre del programa
     */
    public String nombrePrograma(){
        System.out.println("\nIngrese el nombre del programa que desea abrir\n");
        scan = new Scanner(System.in);
        txt = scan.nextLine();
        return txt;
    }
    /**
     * En este metodo se crea un programa nuevo y se establece el espacio del programa
     * @return retorna un int con el espacio que el programa ocupa en la RAM
     */
    public int espacioDePrograma (){
        System.out.println("\nIngrese la cantidad de megas que utiliza este programa\n");
        scan = new Scanner(System.in);
        num = scan.nextInt();
        return num;
    }
    /**
     * Este es un metodo en el que se crea un nuevo programa y establece la cantidad de ciclos de vida que tiene este programa
     * @return retorna un int con la cantidad de ciclos que va a tener este programa
     */
    public int  ciclosDeReloj(){
        System.out.println("\nIngrese la cantidad de ciclos que va estar activo este programa\n");
        scan = new Scanner(System.in);
        num = scan.nextInt();
        return num;
    }
}