
package Domini;

import java.util.Scanner;

public class DriverCronometre {
    private static void menu(){
        System.out.println("1 - Iniciar");
        System.out.println("2 - Stop");
        System.out.println("3 - Restart");
        System.out.println("4 - Show");
        System.out.println("Q - SORTIR");
    }
    public static void main(String[] args) {
        Scanner inout = new Scanner(System.in);
        String opt;
        Cronometre crono = new Cronometre();
        do{
            menu();
            opt = inout.nextLine();
            switch(opt){
                case "1":
                    crono.start();
                    break;
                case "2":
                    crono.stop();
                    break;
                case "3":
                    crono.restart();
                    break;
                case "4":
                    crono.showCurrentValue();
                    break;
                case "Q":
                    crono.end();
                    break;
            }
        }
        while(!opt.equals("Q"));
    }
}
