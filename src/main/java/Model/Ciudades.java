package Model;

import java.net.URL;
import java.util.ArrayList;

public class Ciudades {
    String pais;
    String capital;
    ArrayList<Ciudades> c;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public ArrayList<Ciudades> getC() {
        return c;
    }

    public void setC(ArrayList<Ciudades> c) {
        this.c = c;
    }

    public Ciudades() {

    }

    public Ciudades(String pais, String capital){
        this.pais = pais;
        this.capital = capital;
    }
}
