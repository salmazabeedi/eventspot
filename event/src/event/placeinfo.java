/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.*;
import java.util.Scanner;


public class placeinfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        @SuppressWarnings("unchecked")
        JSONObject place1 = new JSONObject();
        place1.put("place name", "Ash cafe");
        place1.put("location", "prince sultan");
        place1.put("catogery", "cafe");
        place1.put("price", "150 per person");
        place1.put("guest capacity", "30");

        //---------
        JSONObject place2 = new JSONObject();
        place2.put("place name", "subject cafe");
        place2.put("location", "obhour");
        place2.put("catogery", "cafe");
        place2.put("price", "110 per person");
        place2.put("guest capacity", "25");
   
        //-------------
        JSONObject place3 = new JSONObject();
        place3.put("place name", "alqasr");
        place3.put("location", "madinah road");
        place3.put("catogery", "hall");
        place3.put("price", "250 per person");
        place3.put("guest capacity", "350");

        //------------------
        JSONObject place4 = new JSONObject();
        place4.put("place name", "assilah hotel");
        place4.put("location", "tahlia street");
        place4.put("catogery", "hall");
        place4.put("price", "300 per person");
        place4.put("guest capacity", "150");
        JSONObject placeObj4 = new JSONObject();
        placeObj4.put("wedding place", place4);
       //---------------
        JSONObject place5 = new JSONObject();
        place5.put("place name", "hilton hotel");
        place5.put("location", "cornich");
        place5.put("catogery", "hall");
        place5.put("price", "350 per person");
        place5.put("guest capacity", "280");
        //----------------
        JSONObject place6 = new JSONObject();
        place6.put("place name", "radison blue");
        place6.put("location", "cornich");
        place6.put("catogery", "hall");
        place6.put("price", "400 per person");
        place6.put("guest capacity", "180");
       //---------------
       JSONObject place7 = new JSONObject();
        place7.put("place name", "meraki");
        place7.put("location", "abdulmaqsod khoja");
        place7.put("catogery", "cafe");
        place7.put("price", "100 per person");
        place7.put("guest capacity", "30");
     //-------------------
       JSONObject place8 = new JSONObject();
        place8.put("place name", "urth cafe");
        place8.put("location", "king abdilaziz road ");
        place8.put("catogery", "cafe");
        place8.put("price", "300 per person");
        place8.put("guest capacity", "150");
        


        JSONArray Plist = new JSONArray();
        JSONArray Plist2 = new JSONArray();

        Plist.add(place1);
        Plist.add(place2);
        Plist.add(place8);
        Plist.add(place7);
        Plist2.add(place3);
        Plist2.add(place4);
        Plist2.add(place6);
        Plist2.add(place5);
        JSONObject j=new JSONObject();
        j.put("cafe", Plist);
        j.put("hall", Plist2);
  

        //obj.put("cources", list);
        try (FileWriter f = new FileWriter("places.json")) {
            f.write(j.toString());
            f.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}