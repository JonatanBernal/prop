
package Persistencia;

import Domini.Usuari;
import java.io.IOException;
import java.util.ArrayList;

public class DriverControladorPersistencia {
    public static void main(String[] args) throws IOException {
        ControladorPersistencia cp = new ControladorPersistencia();
        /*ArrayList<String> tmp = cp.usersList();
        ArrayList<Usuari> tmp2 = cp.getAllUsers();
        for(int i = 0; i < tmp.size();++i){
            System.out.println(tmp.get(i));
        }*/
        cp.deleteAllUsers();
    }
}
    