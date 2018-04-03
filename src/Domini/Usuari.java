package Domini;

public class Usuari {
    private String username;
    private String password;
    private boolean tePartidaGuardada;
    
    public Usuari(String username, String password, boolean pg){
        this.username = username;
        this.password = password;
        this.tePartidaGuardada = pg;
    }
    
    public Usuari(String username, String password){
        this.username = username;
        this.password = password;
        this.tePartidaGuardada = false;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public boolean setUsername(String username){
        this.username = username;
        return true;
    }
    
    public boolean setPassword(String password){
        if(password.length()> 3){
            this.password = password;
            return true;
        }
        return false;
    }
    
    public boolean teGuardada(){
        return this.tePartidaGuardada;
    }
    
    public void setPartidaGuardada(boolean st){
        this.tePartidaGuardada = st;
    }
}