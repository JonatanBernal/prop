package Domini;

import java.awt.Point;
import java.util.ArrayList;

public class Quadrat extends Casella {
    
    public Quadrat(){
        super();
    }
    
    
    public Quadrat(int x, int y){
        super(x,y);
    }
    
    
    /**
    * Constructor base de la classe Quadrat
    * @param  x  Coordenada x del punt (x,y)
    * @param y Coordenada y del punt (x,y)
    * @param val Valor assignat a la casella.
    * @param plant Definir si aquella casella forma part del tauler inicial o
    * ha estat omplert posteriorment per l'usuari.
    */
    public Quadrat(int x, int y, int val, boolean plant) {
        super(x, y, val, plant);
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
        cjt.add(new Point(this.getX(),this.getY()-1));
        cjt.add(new Point(this.getX()+1,this.getY()));
        cjt.add(new Point(this.getX(),this.getY()+1));
        cjt.add(new Point(this.getX()-1,this.getY()));
        if(adj.equals("CA")){
            cjt.add(new Point(this.getX()+1,this.getY()-1));
            cjt.add(new Point(this.getX()+1,this.getY()+1));
            cjt.add(new Point(this.getX()-1,this.getY()+1));
            cjt.add(new Point(this.getX()-1,this.getY()-1));
        }
        return cjt;
    }
}
