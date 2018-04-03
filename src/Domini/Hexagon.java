package Domini;

import java.awt.Point;
import java.util.ArrayList;

public class Hexagon extends Casella {
    private final int costat;
    private final double apotema;
    
    public Hexagon(){
        super();
        this.costat = 5;
        this.apotema = 4.33;
    }
    
    
    public Hexagon(int x, int y){
        super(x,y);
        this.costat = 5;
        this.apotema = 4.33;
    }
    
    /**
    * Constructor base de la classe Hexagon
    * @param  x  Coordenada x del punt (x,y)
    * @param y Coordenada y del punt (x,y)
    * @param val Valor assignat a la casella.
    * @param plant Definir si aquella casella forma part del tauler inicial o
    * ha estat omplert posteriorment per l'usuari.
    */
    public Hexagon(int x, int y, int val, boolean plant) {
        super(x, y, val, plant);
        this.costat = 5;
        this.apotema = 4.33;
    }
    
    
    
    /**
    * Donat un tipus d'adjacencia, el qual pot ser per costats ("C") o per
     * costats+angles ("CA"), retorna totes les posicions candidates a ser adjacents.
     * @param  adj  String que indica el tipus d'adjacència que estem buscant ("CA" o "C)
     * @param limitFila
     * @param limitCol
     * @return      Un ArrayList de punts (x,y) amb totes les posicions candidates a ser adjacents,
     * sense tenir en compte les dimensions i limitacions del tauler.
    */
    @Override
    public ArrayList<Point> obtePosAdjacents(String adj, int limitFila, int limitCol){
        ArrayList<Point> cjt = new ArrayList<>();
        cjt.add(new Point(this.getX()-1,this.getY()-1));
        cjt.add(new Point(this.getX()+1,this.getY()-1));
        cjt.add(new Point(this.getX()+1,this.getY()));
        cjt.add(new Point(this.getX()+1,this.getY()+1));
        cjt.add(new Point(this.getX()-1,this.getY()+1));
        cjt.add(new Point(this.getX()-1,this.getY()));  
        return cjt;
    }
    
    public double getApotema(){
        return this.apotema;
    }
    
    public int getCostat(){
        return this.costat;
    }
}
