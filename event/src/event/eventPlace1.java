/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author abodn
 */
public class eventPlace1 {

    public eventPlace1 ()throws FileNotFoundException, IOException, ParseException {
        int choose;
       String type = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("choose from menu your event type");
        System.out.println("1.study area");
        System.out.println("2.wedding");
        choose = keyboard.nextInt();
        switch (choose) {
            case 1:
                type = "studyArea";

                break;
            case 2:
                type="wedding";
                
        }

        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("places.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONArray array = (JSONArray) jsonObject.get(type);
            System.out.println("Please choose from the following:");
            findplace(array);
            keyboard.nextLine();
             String choice = keyboard.nextLine();

        // Check if the user's choice is in the array.
        boolean found = false;
       String placeN = null;
        String price = null;
        String catogery=null;
        String location=null;
        String capacity=null;
        for (Object o : array) {
            JSONObject object = (JSONObject) o;
            if (object.get("place name").equals(choice)) {
                found = true;
                 placeN=object.get("place name").toString();
                 price=object.get("price").toString();
                 catogery=object.get("catogery").toString();
                 location=object.get("location").toString();
                 capacity=object.get("guest capacity").toString();
                 
                
                break;
            }
        }
        if (found){
            System.out.println("your choose is "+choice);
           // System.out.println("Place Name: " + placeN);
            System.out.println("Catogery: " + catogery);
            System.out.println("guest Capacity: " + capacity);
            System.out.println("Location: " + location);
            System.out.println("Price: " + price);
            
            
        }else{
            System.out.println("invalid choose");
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private static void findplace(JSONArray array) {

        for (Object o : array) {
            JSONObject object = (JSONObject) o;
            System.out.println("Place Name: " + object.get("place name"));
            System.out.println("Catogery: " + object.get("catogery"));
            System.out.println("guest Capacity: " + object.get("guest capacity"));
            System.out.println("Location: " + object.get("location"));
            System.out.println("Price: " + object.get("price"));
            System.out.println("_______________________");

        }

    }

}
