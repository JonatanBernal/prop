package Domini;


public class Partida {
    private Cronometre puntuacio;
    private Usuari user;
    private Tauler tauler;
    //FALTA DATA
    
    public Partida(Usuari user){
        puntuacio = new Cronometre();
        this.user = user;
        tauler = new Tauler();        
    }
}
