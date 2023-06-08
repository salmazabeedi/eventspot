package event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author abodn
 */
public class reservation {
   public static void saveReservation(String userName, String placeN, String category, String location,int guestNum, int newPrice,String price , String date) throws FileNotFoundException, IOException, ParseException {
    Reservation reservation = new Reservation(userName, placeN, category, location,guestNum, newPrice,price,  date);
    
        JSONParser parser = new JSONParser();

        
        File file = new File("UserReservation.json");

        
        FileReader reader = new FileReader(file);

       
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        
        JSONArray array = (JSONArray) jsonObject.get("Reservation");

    JSONObject user = new JSONObject();
    user.put("User Name", reservation.getUserName());
    user.put("Place Name", reservation.getPlaceName());
    user.put("Category", reservation.getCategory());
    user.put("Guest Count", reservation.getGuestNum());
    user.put("Location", reservation.getLocation());
     user.put("Current Price", reservation.getnewPrice());
    user.put("standard Price", reservation.getPrice());
    user.put("Date", reservation.getDate());
    user.put("Day", reservation.getDay());
    JSONArray reslist = new JSONArray();
    array.add(user);
    JSONObject reserve = new JSONObject();
    reserve.put("Reservation", reslist); 

     try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonObject.toJSONString());
        System.out.println("Your reservation has been confirmed.");
        System.out.println("Reservation Details:");
        System.out.println("User Name: " + reservation.getUserName());
        System.out.println("Place Name: " + reservation.getPlaceName());
        System.out.println("Category: " + reservation.getCategory());
 
        System.out.println("Location: " + reservation.getLocation());
        System.out.println("current price: " + reservation.getnewPrice());
        System.out.println("standard Price: " + reservation.getPrice());
        System.out.println("Date: " + reservation.getDate());
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}
//h
  
        
    

public static class Reservation {
   private String userName;
    private String placeName;
    private String category;
    private String location;
    private int guestNum;
    private int newPrice;
    private String price;
    private String day;
    private String date;

        public Reservation() {
        }
    

    public Reservation(String userName, String placeName, String category, String location, int guestNum, int newPrice, String price,  String date) {
        this.userName = userName;
        this.placeName = placeName;
        this.category = category;
        this.location = location;
        this.guestNum = guestNum;
        this.newPrice = newPrice;
        this.price = price;
        this.day = day;
        this.date = date;
    }
     

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGuestNum() {
        return guestNum;
    }

    public void setGuestNum(int guestNum) {
        this.guestNum = guestNum;
    }
      public int getnewPrice() {
        return newPrice;
    }
     public void setnewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    }
    
}