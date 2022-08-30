package Vista;
import Model.DAO;
import Model.Ciudades;

import java.util.ArrayList;

public class show {
    DAO dao = new DAO();

    public void showData(){
        ArrayList<Ciudades> c = dao.getCiudades();
        System.out.println("--- CIUDADES Y CAPITALES! ---");
        try {
            for (Ciudades ci : c){
                System.out.println("----////----");
                System.out.println("Nombre: "+ci.getPais());
                System.out.println("Capital: "+ci.getCapital());
                System.out.println("----////----");
            }
        } catch (Exception e){
            System.out.println("--- ERROR ---");
        }
    }
}
