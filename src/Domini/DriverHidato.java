
package Domini;

import java.util.Scanner;

public class DriverHidato {
    public static void menu(){
        System.out.println("1 - CARREGAR HIDATO DE FITXER");
        System.out.println("2 - MOSTRAR HIDATO PER PANTALLA");
        System.out.println("3 - MOSTRAR CASELLES TOTALS");
        System.out.println("4 - MOSTRAR CASELLES OMPLERTES");
        System.out.println("5 - MOSTRAR DIMENSIONS HIDATO");
        System.out.println("6 - DEFINIR HIDATO MANUALMENT");
        System.out.println("Q - SORTIR");
    }
    public static void main(String[] args) {
        Hidato hidato = new Hidato();
        String opt;
        Scanner inout = new Scanner(System.in);
        do{
            menu();
            opt = inout.nextLine();
            switch(opt){
                case "1":
                    System.out.println("Introdueix la ruta del Hidato");
                    String path = inout.nextLine();
                    hidato.readFromFile(path);
                    break;
                case"2":
                    String opt2;
                    System.out.println("Com vols veure l'Hidato?");
                    System.out.println("1 - Format Integer");
                    System.out.println("2 - Format Caracter + Integer");
                    opt2 = inout.nextLine();
                    switch (opt2){
                        case "1":
                            hidato.printHidato(false);
                            break;
                        case "2":
                            hidato.printHidato(true);
                            break;
                        default:
                            System.out.println("Opcio incorrecta");
                            break;
                    }
                    break;
                case"3":
                    System.out.println("CASELLES TOTALS: "+hidato.getCasellesTotals());
                    break;
                case"4":
                    System.out.println("CASELLES OMPLERTES: "+ hidato.getCasellesOmplertes());
                    break;
                case "5":
                    System.out.println("DIMENSIONS: " + hidato.getFilesTotals()+"X"+ hidato.getColumnesTotals());
                    break;
                case "6":
                    System.out.println("Introdueix el nombre de files");
                    int nfiles = Integer.parseInt(inout.nextLine());
                    System.out.println("Introdueix el nombre de columnes");
                    int ncols = Integer.parseInt(inout.nextLine());
                    System.out.println("Quin tipus de casella el formara: (Q/H/T)");
                    String tipus = inout.nextLine();
                    System.out.println("Quin tipus d'adjacencia sera valid? (C/CA)");
                    String adj = inout.nextLine();
                    if(hidato.defineHidatoBase(nfiles, ncols, tipus, adj)){
                        hidato.printHidato(false);
                    }
                    
                    break;
                    
            }
        }
        while(!opt.equals("Q"));
    }
}
