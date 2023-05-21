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


public class eventPlace2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        @SuppressWarnings("unchecked")
        JSONObject place1 = new JSONObject();
        place1.put("place name", "Ash cafe");
        place1.put("location", "prince sultan");
        place1.put("catogery", "study area");
        place1.put("price", "150 per hour");
        place1.put("guest capacity", "30");
        JSONObject placeObj1 = new JSONObject();
        placeObj1.put("studyarea", place1);
        //---------
        JSONObject place2 = new JSONObject();
        place2.put("place name", "subject cafe");
        place2.put("location", "obhour");
        place2.put("catogery", "study area");
        place2.put("price", "110 per hour");
        place2.put("guest capacity", "25");
        JSONObject placeObj2 = new JSONObject();
        placeObj2.put("studyarea", place2);
        //-------------
        JSONObject place3 = new JSONObject();
        place3.put("place name", "alqasr");
        place3.put("location", "madinah road");
        place3.put("catogery", "wedding");
        place3.put("price", "250 per person");
        place3.put("guest capacity", "350");
        JSONObject placeObj3 = new JSONObject();
        placeObj3.put("wedding place", place3);
        //------------------
        JSONObject place4 = new JSONObject();
        place4.put("place name", "assilah hotel");
        place4.put("location", "tahlia street");
        place4.put("catogery", "wedding");
        place4.put("price", "300 per hour");
        place4.put("guest capacity", "150");
        JSONObject placeObj4 = new JSONObject();
        placeObj4.put("wedding place", place4);
        //JSONObject Places = new JSONObject();

        JSONArray Plist = new JSONArray();

        Plist.add(placeObj1);
        Plist.add(placeObj2);
        Plist.add(placeObj3);
        Plist.add(placeObj4);
  

        //obj.put("cources", list);
        try (FileWriter f = new FileWriter("places.json")) {
            f.write(Plist.toString());
            f.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
