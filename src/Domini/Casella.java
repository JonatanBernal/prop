package Domini;

import java.awt.Point;
import java.util.ArrayList;


public class Casella {
    private int valor;
    private boolean plantilla;
    private Point posicio;
    
    public Casella(){
        this.posicio = null;
    }
    
    public Casella(int x, int y){
        this.posicio = new Point(x,y);
    }
    
    public Casella(int x, int y,int val, boolean plant){
        posicio = new Point(x,y);
        this.valor = val;
        this.plantilla = plant;
    }
    
    //Getters
    public int getX(){
        return (int)this.posicio.getX();
    }
    
    public int getY(){
        return (int)this.posicio.getY();
    }
    
    public Point getPosition(){
        return this.posicio;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public boolean getPlantilla(){
        return this.plantilla;
    }
    
    
    //Setters
    public void setValue(int val){this.valor = val;}
    
    //Methods
    
    public ArrayList<Point> obtePosAdjacents(String adj, int limitFila, int limitCol){
        return null;
    }
    
    public void showCoords(){
        System.out.println("("+this.posicio.x+","+this.posicio.y+")");
    }
}
