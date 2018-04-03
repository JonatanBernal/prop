package Domini;

import Persistencia.ControladorPersistencia;
import java.util.Scanner;

public class Main {
    private static void menuPrincipal(){
        System.out.println("####################################");
        System.out.println("#         MENU PRINCIPAL           #");
        System.out.println("####################################");
        System.out.println("Que vols fer?");
        System.out.println("1 - Validarme amb el meu usuari");
        System.out.println("2 - Crear un nou usuari");
        System.out.println("Q - SORTIR");
        System.out.println("Escull una opcio:");
    }
    public static void main(String[] args) {
        ControladorPersistencia cp = new ControladorPersistencia();
        cp.createMainDirectory();
        String opt, username,password;
        Scanner inout = new Scanner(System.in);
        System.out.println("####################################");
        System.out.println("BENVINGUT AL SISTEMA D'HIDATOS");
        System.out.println("####################################");
        do{
            menuPrincipal();
            opt = inout.nextLine();
            switch(opt){
                case "1":
                    System.out.println("Introdueix el teu nom d'usuari: ");
                    username = inout.nextLine();
                    System.out.println("Introdueix el teu password:");
                    password = inout.nextLine();
                    Usuari u = new Usuari(username,password);
                    if(cp.credencialsValides(u)){
                        System.out.println("VALIDAT CORRECTAMENT");
                        inout.nextLine();
                    }
                    else{
                        System.out.println("CREDENCIALS INCORRECTEES");
                    }
                    break;
                
                case "2":
                    System.out.println("Introdueix el teu NOU nom d'usuari: ");
                    username = inout.nextLine();
                    System.out.println("Introdueix el teu password:");
                    password = inout.nextLine();
                    Usuari newUser = new Usuari(username,password);
                    cp.crearUsuari(newUser);
                    break;
            }
        }
        while(!opt.equals("Q"));
    }
}
