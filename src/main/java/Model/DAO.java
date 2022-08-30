package Model;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


import Model.Ciudades;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

public class DAO {
    private URL url;
    private HttpURLConnection con;

    private void conectarBD(){
        try {
            url = new URL("https://countriesnow.space/api/v0.1/countries/capital");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            if (con.getResponseCode() != 200){
                throw new RuntimeException("error: "+con.getResponseCode());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String info (){
        try {
            StringBuilder informationString = new StringBuilder();
            Scanner scan = new Scanner(url.openStream());

            while (scan.hasNext()){
                informationString.append(scan.nextLine());
            }
            scan.close();
            return informationString.toString();

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Ciudades> getCiudades(){
        conectarBD();
        try {
            JSONObject j = new JSONObject(info());
            JSONArray json = j.getJSONArray("data");
            ArrayList<Ciudades> lista = new ArrayList<Ciudades>();
            for (int i = 0 ; i< json.length(); i++){
                Ciudades c = new Ciudades();
                c.setPais(json.getJSONObject(i).getString("name"));
                c.setCapital(json.getJSONObject(i).getString("capital"));
                lista.add(c);
            }
            desconectarBD();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void desconectarBD(){
        con.disconnect();
    }



}
