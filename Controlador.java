class Controlador{
    public static void main(String[] args) {
        int opcion = 0;
        int momentumMem = 0;
        int opcioncita = 0;
        int opcioncita1 = 0;
        Vista vistita = new Vista();
        while (opcion!=3){
            opcion = vistita.menu1();
            switch (opcion) {
                case 1:
                    momentumMem = vistita.getInfoSDR();
                    
                    SDR memoria = new SDR(momentumMem);
                    while (opcioncita1!=10){
                        opcioncita = vistita.menu2();

                        switch (opcioncita1) {
                            case 1:
                                String nom = vistita.nombrePrograma();
                                int esp = vistita.espacioDePrograma();
                                int cicl = vistita.ciclosDeReloj();
                                memoria.agregarACola(nom, esp, cicl);
                            break;
                            case 2:
                                memoria.getMemoriaTot();
                            break;
                            case 3:
                                memoria.getMemoriaEnUso();
                            break;
                            case 4:
                                memoria.getMemoriaRest();
                            break;
                            case 5:
                                memoria.mostrarProgramasEnRAM();
                            break;
                            case 6:
                                memoria.mostrarCola();
                            break;
                            case 7:
                                memoria.mostrarProgramasEnRAM();
                                int x = vistita.indeceProgram();
                                memoria.mostrarBloquesProgramaEsp(x);
                            break;
                            case 8:
                                memoria.mostrarBloques();
                            break;
                            case 9:
                                memoria.nuevoCicloDeReloj();
                            break;
                            case 10:
                                //Salida
                            break;
                    }
                }

                    
                    
                    break;
                case 2:
                    DDR memoria1 = new DDR();
                    while (opcioncita!=10){
                        opcioncita = vistita.menu2();

                        switch (opcioncita) {
                            case 1:
                                String nom = vistita.nombrePrograma();
                                int esp = vistita.espacioDePrograma();
                                int cicl = vistita.ciclosDeReloj();
                                memoria1.agregarACola(nom, esp, cicl);
                            break;
                            case 2:
                                memoria1.getMemoriaTot();
                            break;
                            case 3:
                                memoria1.getMemoriaEnUso();
                            break;
                            case 4:
                                memoria1.getMemoriaRest();
                            break;
                            case 5:
                                memoria1.mostrarProgramasEnRAM();
                            break;
                            case 6:
                                memoria1.mostrarCola();
                            break;
                            case 7:
                                memoria1.mostrarProgramasEnRAM();
                                int x = vistita.indeceProgram();
                                memoria1.mostrarBloquesProgramaEsp(x);
                            break;
                            case 8:
                                memoria1.mostrarBloques();
                            break;
                            case 9:
                                memoria1.nuevoCicloDeReloj();
                            break;
                            case 10:
                                //Salida
                            break;
                    }
                }
                

                

                    break;
                default:
                    break;
            }
        }

    }

}
