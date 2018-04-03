package Domini;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverCasella {
    public static void menu(){
        System.out.println("DRIVER CASELLA");
        System.out.println("1 - CREAR CASELLA");
        System.out.println("2 - CONSULTAR ADJACENCIES");
        System.out.println("3 - CONSULTAR COORDENADES");
        System.out.println("4 - CONSULTAR X");
        System.out.println("5 - CONSULTAR Y");
        System.out.println("6 - DEFINIR VALOR");
        System.out.println("7 - CONSULTAR VALOR");
        System.out.println("Q - SORTIR");
    }
    
    public static void main(String[] args) {
        Casella c = new Casella();
        Scanner inout = new Scanner(System.in);
        
        
        String opt;
        do{
            menu();
            opt = inout.nextLine();
            switch(opt){
                case "1":
                    System.out.println("Quin tipus de casella vols crear?");
                    System.out.println("1 - QUADRAT");
                    System.out.println("2 - HEXAGON");
                    System.out.println("3 - TRIANGLE");
                    String type = inout.nextLine();

                    System.out.println("Introdueix la coordenada X");
                    int x = inout.nextInt();
                    System.out.println("Introdueix la coordenada Y");
                    int y = inout.nextInt();
                    switch (type){
                        case "1":
                            c = new Quadrat(x,y);
                            break;
                        case "2":
                            c = new Hexagon(x,y);
                            break;
                        case "3":
                            c = new Triangle(x,y);
                            break;
                    }
                    break;
                case "2":
                    System.out.println("QUIN TIPUS D'ADJACENCIA TE LA CASELLA");
                    System.out.println("1 - COSTATS");
                    System.out.println("2 - COSTATS + ANGLES");
                    String adj = inout.nextLine();
                    switch(adj){
                        case "1":
                            adj = "C";
                            break;
                        case "2":
                            adj = "CA";
                            break;
                    }
                    ArrayList<Point> cjt = c.obtePosAdjacents(adj, 0, 0);
                    for(int i = 0; i < cjt.size();++i){
                        System.out.println("("+cjt.get(i).x+","+cjt.get(i).y+")");
                    }
                    break;
                case "3":
                    c.showCoords();
                    break;
                case "4":
                    System.out.println(c.getX());
                    break;
                case "5":
                    System.out.println(c.getY());
                    break;
                case "6":
                    System.out.println("Introdueix el valor de la casella");
                    int newVal = inout.nextInt();
                    c.setValue(newVal);
                    break;
                case "7":
                    System.out.println("Valor: "+c.getValor());
                    break;
            }
        }
        while(!opt.equals("Q"));
    }
}
