import java.util.ArrayList;

/**
 * En esta clase se generan los bloques de la memoria mediante el espacio seleccionado por es usuario, tambien esta clase genera ciclos
 * de reloj que actualizan la memoria disponible y la memoria en uso.
 * 
 * @author Sebastian Estrada Tuch
 * @since 18/09/2021
 * @version 1.0
 */
class DDR{
    private Archivo archivito = new Archivo("ProgramasPaRAM.csv"); // Lee el archivo donde estan los programas iniciales

    private int memoria;// Es un int que guarda la memoria que el usuario escoge
    private double memoriaEnUso;// Es es un int en donde se guarda que tanta memoria se esta usando
    private double memoriaRest; // Esta variable guarda la informacion de la memoria que esta disponible
    private int bloquesDeRAM; // Este int sirve para en un futuro establecer cuantos bloques estan disponibles


    private ArrayList<Programa> programasEnRAM = new ArrayList<Programa>(); // Se establece un arrayList en el que se almacenan los programas en uso
    private ArrayList<String> bloques = new ArrayList<String>();// Este array almacena la cantidad de bloques disponibles
    private ArrayList<Programa> colaDeEspera = new ArrayList<Programa>(); // Este ArrayList almacena los programas que estan en espera

    /**
     * Este metodo constructor necesita un espacio de memoria ingresado para poder inicializarla, en este metodo se establece el espacio
     * de los bloques disponibles, se ocupan algunos de estos bloques con programas pre establecidos (Se ocupa un GB) y posteriormente se 
     * establece la memoria restante.
     * @param mem
     */
    public DDR (){
        memoria = 4*1024; // Se convierten GB a mB
        bloquesDeRAM = memoria/64; 
        // Se establecen los bloques que deben estar disponibles

        agregarPrimerosProgram(); // Se leen los primeros programas y se almacenan
        calcBloques(bloquesDeRAM); // Se generan los nuevos bloques
        calcularRAMDisp(); // Asigna nuevos valores a memoria en uso y memoria restante
    }
    /**
     * Este metodo genera los bloques que estan disponibles y los que no en base a los programas que estan en la ram
     */
    private void calcBloques(int control){
        double x = 0; // Establece un parametro como cero
        // Este ciclo recorre el largo de bloques previamente preestablecido
        for (int i = 0; i<=control; i++){
            bloques.add("Vacio");
        }
        
        for (int i = 0; i<programasEnRAM.size(); i++){
            x = programasEnRAM.get(i).getEspacio();
            if (x>0){
                for (int j = 0; j<bloques.size(); j++){
                        if (bloques.get(j) == "Vacio"){
                            bloques.set(j, programasEnRAM.get(i).getNombre());
                        }
                        
                    }
                x = programasEnRAM.get(i).getEspacio() - 64;
            }
        }
    }
    /**
     * Este metodo agrega los primeros programas a programas en RAM
     */
    private void agregarPrimerosProgram(){
        programasEnRAM.add(archivito.getProgramas().get(0));
        programasEnRAM.add(archivito.getProgramas().get(1));
        programasEnRAM.add(archivito.getProgramas().get(2));
        programasEnRAM.add(archivito.getProgramas().get(3));
        programasEnRAM.add(archivito.getProgramas().get(4));
        programasEnRAM.add(archivito.getProgramas().get(5));
    }

    /**
     * Este metodo establece los primeros valores a la ram en uso y a la ram disponible para el uso de otros programas
     */
    private void calcularRAMDisp(){
        memoriaEnUso = 0;
        for (int i = 0; i<programasEnRAM.size(); i++){
            memoriaEnUso += programasEnRAM.get(i).getEspacio();
        }
        memoriaRest = memoria - memoriaEnUso;
    }
    /**
     * Este metodo toma como parametro un string y dos int, para generar un nuevo programa y añadirlo a la cola de espera
     * @param nom
     * @param esp
     * @param cicl
     */
    public void agregarACola (String nom, int esp, int cicl){
        Programa programita = new Programa(nom, esp, cicl);
        colaDeEspera.add(programita);
    }



    /**
     * Este metodo Mustra en consola los indices y el nombre de todos los programas que estan en uso
     */
    public void mostrarProgramasEnRAM(){
        for (int i = 0; i<programasEnRAM.size(); i++){
            System.out.println("[" + i + "] " + programasEnRAM.get(i).getNombre() + "\n");
        }
    }
    /**
     * Este metodo muestra en consola los indices y el nombre de todos los programas que estan en cola de espera
     */
    public void mostrarCola(){
        for (int i = 0; i<colaDeEspera.size(); i++){
            System.out.println("[" + i + "] " + colaDeEspera.get(i).getNombre() + "\n");
        }
    }
    /**
     * Este metodo muestra todos los bloques que tiene la SDR
     */
    public void mostrarBloques(){
        for (int i = 0; i<=bloques.size(); i++){
            System.out.println(" | " + bloques.get(i)+ "|");
        }
    }

    /**
     * Este metodo muestra todos los bloques que utiliza un programa seleccionado espepecifico y como parametro tiene
     * in entero que es un indice seleccionado previamente.
     * @param indice
     */
    public void mostrarBloquesProgramaEsp(int indice){
        int cont = 0;
        for (int i = 0; i < bloques.size(); i++){
            if ( programasEnRAM.get(indice).getNombre() == bloques.get(i) ){
                cont = cont + 1;
            }
        }
        
        System.out.println("El programa " + programasEnRAM.get(indice).getNombre() + " cuenta con " + cont + " bloques");
        
    }
    
    /**
     * Este metodo genera un nuevo ciclo de reloj, por lo que se actualiza todo el programa. Genera que a todos los programas en RAM 
     * se les reste un ciclo de reloj de vida y si estos ciclos de reloj llegan a cero entonces se eliminan todos los bloques 
     * en relacion a este programa, actualiza la memoria en uso y la memoria disponible y por ultimo remueve el programa de 
     * programa en ram.
     * 
     * Tra hacer esta actualizacion, verifica en cada programa de la cola de espera si cabe en programas en RAM en base a la memoria
     * asignada por el usuario y posteriormente actualiza la memoria en uso y la disponible.
     */
    public void nuevoCicloDeReloj(){
        for (int i = 0; i<programasEnRAM.size();i++){
            int x = programasEnRAM.get(i).getCiclos() - 1;
            programasEnRAM.get(i).setCiclos(x);
            if (programasEnRAM.get(i).getCiclos() == 0){
                for (int j = 0; j< bloques.size(); j++){
                    if (programasEnRAM.get(i).getNombre() == bloques.get(j)){
                        bloques.set(j, "Vacio");
                    }
                }
                memoriaEnUso = memoriaEnUso - programasEnRAM.get(i).getEspacio();
                memoriaRest = memoriaRest + programasEnRAM.get(i).getEspacio();

                programasEnRAM.remove(i);
            }
        }
        for (int i = 0; i < colaDeEspera.size(); i++ ){
            
            programasEnRAM.add(colaDeEspera.get(i));
            memoriaEnUso = memoriaEnUso + colaDeEspera.get(i).getEspacio();
            memoriaRest = memoriaRest - colaDeEspera.get(i).getEspacio();

            colaDeEspera.remove(i);

            if (4 < memoriaEnUso && memoriaEnUso <= 8){
                memoria = 8*1024;
                bloquesDeRAM = memoria/64;
                calcBloques(bloquesDeRAM);
                memoriaRest = memoria - memoriaEnUso;
            }else if(8 < memoriaEnUso && memoriaEnUso <= 12){
                memoria = 12*1024;
                bloquesDeRAM = memoria/64;
                calcBloques(bloquesDeRAM);
                memoriaRest = memoria - memoriaEnUso;
                
            }else if(12 < memoriaEnUso && memoriaEnUso <= 16){
                memoria = 16*1024;
                bloquesDeRAM = memoria/64;
                calcBloques(bloquesDeRAM);
                memoriaRest = memoria - memoriaEnUso;
            }else if(16 < memoriaEnUso && memoriaEnUso <= 32){
                memoria = 32*1024;
                bloquesDeRAM = memoria/64;
                calcBloques(bloquesDeRAM);
                memoriaRest = memoria - memoriaEnUso;
                
            }else if(32 < memoriaEnUso && memoriaEnUso <= 64){
                memoria = 64*1024;
                bloquesDeRAM = memoria/64;
                calcBloques(bloquesDeRAM);
                memoriaRest = memoria - memoriaEnUso;
                
            }

            
        }
    }
    public void getMemoriaTot(){
        System.out.println("La memoria total es: " + memoria);
    }
    public void getMemoriaRest(){
        System.out.println("La memoria retante es es: " + memoriaRest);
    }
    public void getMemoriaEnUso(){
        System.out.println("La memoria en uso es: " + memoriaEnUso);
    }
}