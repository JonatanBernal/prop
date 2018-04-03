package Persistencia;

import Domini.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ControladorPersistencia {
    private File f;
    //private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private static String mainPath = "datagame";
    private static String credentialsPath = "datagame/Credencials.log";
    private static String usersPath = mainPath + "/userdata";
    private static String hidatosPath = mainPath + "/hidatos";    
    
    public ControladorPersistencia(){
        this.f = null;
        //this.fr = null;
        this.br = null;
    }
    
    public  void createMainDirectory(){
        try{
            f = new File(hidatosPath);
            if(!f.exists()) f.mkdirs();
            f = new File(usersPath);
            if(!f.exists())f.mkdirs();
            f = new File(credentialsPath);
            if(!f.exists()) f.createNewFile();
            f = null;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean existeixUsuari(String username){
        File tmp = new File(usersPath+"/"+username);
        return tmp.exists();
    }
    
    public ArrayList<String> usersList(){
        ArrayList<String> result = new ArrayList<>();
        File tmp = new File(usersPath);
        File[] tmpArray = tmp.listFiles();
        for(int i = 0; i < tmpArray.length; ++i){
            result.add(tmpArray[i].getName());
        }
        return result;
    }
    
    public ArrayList<Usuari> getAllUsers(){
        ArrayList<Usuari> result = new ArrayList<>();
        File tmp = new File(credentialsPath);
        String line;
        try{
            br = new BufferedReader(new FileReader(tmp.getPath()));
            line = br.readLine();
            while(line != null){
                String[] currentParse = line.split(";");
                boolean saved =false;
                if(currentParse[2].equals("1")) saved = true;
                Usuari newUser = new Usuari(currentParse[0],currentParse[1],saved);
                result.add(newUser);
                line = br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public boolean existeixUsuari(Usuari user){
        File tmp = new File(mainPath+"/Credencials.log");
        String line;
        try{
            br = new BufferedReader(new FileReader(tmp.getPath()));
            line = br.readLine();
            while(line != null){
                String[] currentParse = line.split("$");
                
                if(currentParse[0].equals(user.getUsername())){
                    return true;
                }
                line = br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean credencialsValides(Usuari user){
        File tmp = new File(credentialsPath);
        String line;
        try{
            br = new BufferedReader(new FileReader(tmp.getPath()));
            line = br.readLine();
            while(line != null){
                String[] currentParse = line.split(";");
                if(currentParse[0].equals(user.getUsername())){
                    if(currentParse[1].equals(user.getPassword())){
                        return true;
                    }
                }
                line = br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean crearUsuari(Usuari user){
        File tmp = new File(usersPath+"/"+user.getUsername());
        if(existeixUsuari(user)) System.out.println("Ja existeix usuari amb aquest nom");
        else{
            try {
                //Creacio usuari i registre
                fw = new FileWriter(new File(credentialsPath),true);
                String register = user.getUsername()+";"+user.getPassword()+";0";
                fw.write(register);
                fw.write(System.lineSeparator());
                fw.close();
                tmp.mkdirs();
                tmp = new File(usersPath+"/"+user.getUsername()+"/saved");
                tmp.mkdirs();
                tmp = new File(usersPath+"/"+user.getUsername()+"/partides");
                tmp.mkdirs();
                System.out.println("Usuari Creat Correctament, validat ja!");
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    public void deleteAllUsers() throws IOException{
        File tmp = new File(usersPath);
        File[] tmpArray = tmp.listFiles();
        for(int i = 0; i < tmpArray.length;++i){
            try{
                if(tmpArray[i].delete()){
                    System.out.println("Usuari "+tmpArray[i].getName()+" ELIMINAT!");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        tmp = new File(credentialsPath);
        tmp.delete();
        try{
            tmp.createNewFile();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
