package Domini;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Hidato {
    private Casella[][] table;
    
    private int casellesTotals;
    private int casellesOmplertes;
    private int casellesNules;
    private int filesTotals;
    private int columnesTotals;
    
    private String tipusCasella;
    private String tipusAdjacencia;
    
    /**
     * Inicialitza un Hidato amb les seves caracteristiques buides.
     */
    public Hidato(){
        this.casellesTotals = -1;
        this.casellesOmplertes = -1;
        this.columnesTotals = -1;
        this.filesTotals = -1;
        this.casellesNules = -1;
        this.table = null;
    }
    
    public Hidato(int files, int columnes, String tipus, String adjacencia){
        this.defineHidatoBase(files, columnes, tipus, adjacencia);
        this.table = null;
    }
    
    
    /**
     * Getter que retorna el nombre de caselles total que formen el tauler
     * (caselles que son "candidates" a contenir un valor). Un hidato valid 
     * i solucionat amb "n" caselles l'han de formar "n" caselles entre [1,n].
     * 
     * @return Retorna el nombre de caselles totals del tauler en cas d'estar 
     * inicialitzat. Altrament retorna 0.
     */
    public int getCasellesTotals(){return this.casellesTotals;}
    
    /**
     * Getter que retorna el nombre de caselles a les quals s'ha assignat un 
     * valor vàlid.
     * 
     * @return Retorna el nombre de caselles del tauler amb un valor assignat.
     */
    public int getCasellesOmplertes(){return this.casellesOmplertes;}
    
    /**
     * Getter que retorna el nombre de caselles dins de l'hidato que són 
     * nul·les i per tant no són vàlides per a establir un valor a la casella.
     * 
     * @return Retorna el nombre de caselles nul·les del tauler a les quals 
     * no s'hi pot assignar valor.
     */
    public int getCasellesNules(){return this.casellesNules;}
    
    
    /**Getter que retorna el nombre de files que formen l'Hidato.
     * 
     * @return Retorna el nombre de files que formen l'Hidato, en cas de no 
     * haver estat inicialitzat retorna -1.
     */
    public int getFilesTotals(){return this.filesTotals;}
    
    /**
     * Getter que retorna el nombre de columnes que formen l'Hidato.
     * 
     * @return Retorna el nombre de columnes que formen l'Hidato, en cas de no
     * haver estat inicialitzat retorna -1.
     */
    public int getColumnesTotals(){return this.columnesTotals;}
    
    /**
     * Getter del tipus de casella que marcarà la topologia i resolució de 
     * l'Hidato. Els tipus predefinits són:
     * - "Q" -> Quadrat
     * - "T" -> Triangle
     * - "H" -> Hexagon
     * @return Retorna el tipus de les caselles que formen l'Hidato segons s'ha
     * predefinit en l'Hidato seguint la nomenclatura de la descripció.
     */
    public String getTipusCasella(){return this.tipusCasella;}
    
    /**
     * Getter del tipus d'adjacència que es contempla en l'Hidato instanciat.
     * Els tipus predefinits són:
     * - "C"  -> Adjacencia només per costats
     * - "CA" -> Adjacencia per costats i per angles.
     * 
     * @return Retorna el tipus d'adjacència contemplat en l'Hidato instanciat
     * seguint la nomenclatura de la descripció.
     */
    public String getTipusAdjacencia(){return this.tipusAdjacencia;}
    
    /**
     * Consulta si el tauler de l'Hidato ha estat inicialitzat
     * 
     * @return En cas de que l'Hidato hagi estat iniciat correctament (la seva
     * inicialització no implica que estigui omplert) retorna true. Altrament
     * retorna false;
     */
    public boolean inicialitzat(){
        return this.table == null;
    }
    
    /** Mostra mitjançant el canal stàndard l'Hidato en un determinat format
     * depenent dels paràmetres.
     * 
     * @param formatted Indica si volem veure l'Hidato en format enter (sense
     * codificar) o volem veure l'Hidato amb les caselles formatades en funció
     * del seu valor
     */
    public void printHidato(boolean formatted){
        if(formatted){
            for (Casella[] table1 : table) {
                for (int j = 0; j < table[0].length; ++j) {
                    if(j==0) System.out.print(table1[j].getValor());
                    else System.out.print(" "+table1[j].getValor());
                }
                System.out.println();
            }
        }
        else{
            for (Casella[] table1 : table) {
                for (int j = 0; j < table[0].length; ++j) {
                    int aux = table1[j].getValor();
                    String out;
                    switch(aux){
                        case -1:
                            out = "#";
                            break;

                        case -2:
                            out = "?";
                            break;
                        case -3:
                            out = "*";
                            break;
                        default:
                            out = Integer.toString(aux);
                            break;
                    }
                    if(j==0) System.out.print(out);
                    else System.out.print(" "+out);
                }
                System.out.println();
            }
        }
    }
    
    /**
     * Llegir un Hidato guardat en una ubicacio per a ser carregat dins de la
     * instància concreta. El format correcte d'un Hidato és:
     * Linia1: TipusCela,TipusAdjacencia,Files,Columnes
     * Linia 2: Fila 0
     * ...
     * ...
     * Linia n+2: Fila n
     * IMPORTANT: Separació dels valors utilitzant el caràcter (',')
     * @param path Ruta vàlida d'un Hidato en un format correcte.
     */
    public void readFromFile(String path){
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            String dades[] = line.split(",");
            tipusCasella = dades[0];
            tipusAdjacencia = dades[1];
            filesTotals = Integer.parseInt(dades[2]);
            columnesTotals = Integer.parseInt(dades[3]);
            System.out.println(filesTotals + "X" + columnesTotals);
            table = new Casella[filesTotals][columnesTotals];
            for(int i = 0; i < filesTotals; ++i){
                line = br.readLine();
                dades = line.split(",");
                for(int j = 0; j < dades.length; ++j){
                    String toParse = dades[j];
                    int parsed;
                    switch (toParse) {
                        case "#":
                            parsed = -1;
                            break;
                        case "?":
                            parsed = -2;
                            this.casellesTotals++;
                            break;
                        case "*":
                            parsed = -3;
                            this.casellesNules++;
                            break;
                        default:
                            parsed = Integer.parseInt(toParse);
                            this.casellesOmplertes++;
                            this.casellesTotals++;
                            break;
                    }
                    table[i][j] = new Casella(j,i,parsed,false);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    
    /**
     * 
     * @param files
     * @param columnes
     * @param tipus
     * @param adjacencia
     * @return 
     */
    public boolean defineHidatoBase(int files, int columnes, String tipus, String adjacencia){
        if(files >= 0){
            if(columnes >= 0){
                if(adjacencia.equals("C") || adjacencia.equals("CA")){
                    if(tipus.equals("Q")||tipus.equals("H")||tipus.equals("T")){
                        this.filesTotals = files;
                        this.columnesTotals = columnes;
                        this.tipusAdjacencia = adjacencia;
                        this.tipusCasella = tipus;
                        this.table = new Casella[this.filesTotals][this.columnesTotals];
                        this.cleanHidato(-1);
                        System.out.println("DIMENSIONS I TIPUS DEFINITS");
                        return true;
                    }
                    else System.out.println("Error en parametre [tipus], hidato no definit");
                }
                else System.out.println("Error en parametre [adjacencia], hidato no definit");
            }
            else System.out.println("Error en parametre [columnes], hidato no definit");
        }
        else System.out.println("Error en parametre [files], hidato no definit");
        return false;
    }
    
    /**
     * 
     * 
     * @param value
     */
    public void cleanHidato(int value){
        System.out.println(table.length);
        for(int i = 0; i < table.length; ++i){
            for(int j = 0; j < table[0].length; ++j){
                table[i][j] = new Casella(j,i,value,false);
            }
        }
    }    
    
}
