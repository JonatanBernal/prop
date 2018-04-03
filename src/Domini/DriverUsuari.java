package Domini;

import java.util.Scanner;

public class DriverUsuari {
    private static void menu(){
        System.out.println("MENU DE GESTIÓ D'USUARI");
        System.out.println("1 - CREAR USUARI");
        System.out.println("2 - MOSTRAR USUARI");
        System.out.println("3 - MOSTRAR PASSWORD");
        System.out.println("4 - MOSTRAR INFO COMPLETA");
        System.out.println("5 - EDITAR USUARI");
        System.out.println("6 - EDITAR PASSWORD");    
        System.out.println("Q - SORTIR");
    }
    
    public static void main(String[] args){
        Usuari user = null;
        Scanner input = new Scanner(System.in);
        String opt, auxUsername, auxPassword;
        do{
          menu();
          opt = input.nextLine();
          switch(opt){
            case "1":
                System.out.println("Introdueix el nom de l'usuari a crear:");
                auxUsername = input.nextLine();
                System.out.println("Introdueix el password de l'usuari:");
                auxPassword = input.nextLine();
                user = new Usuari(auxUsername,auxPassword);
                break;
            case "2":
                if(user == null) System.out.println("Usuari no creat");
                else System.out.println("Usuari: " + user.getUsername());
                break;
            case "3":
                if(user == null) System.out.println("Usuari no creat");
                else System.out.println("Password: " + user.getPassword());
                break;
            case "4":
                if(user == null)System.out.println("Usuari no creat");
                else{
                    System.out.println("USUARI: " + user.getUsername());
                    System.out.println("PASSWORD: " + user.getPassword());
                }
                break;
            case "5":
                System.out.println("Introdueix el nou nom d'usuari");
                auxUsername = input.nextLine();
                if(user.setUsername(auxUsername)) System.out.println("Usuari modificat correctament");
                break;
            case "6":
                System.out.println("Introdueix el nou password");
                auxPassword = input.nextLine();
                if(user.setPassword(auxPassword)) System.out.println("Password modificat correctament");
                break;
             
          }
        }
        while(!opt.equals("Q"));
    }
}
