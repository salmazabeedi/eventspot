/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class payment {

    String cardNum;
    int amount;

    public payment(String cardNum, int amount) {
        this.cardNum = cardNum;
        this.amount = amount;
    }

    payment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static boolean paymentCheck(String cardnum, int price) throws FileNotFoundException, IOException, ParseException {
        String Useramount;
        JSONParser parser = new JSONParser();

        // Create a File object for the JSON file.
        File file = new File("cards.json");

        FileReader reader = new FileReader(file);

        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        JSONArray array = (JSONArray) jsonObject.get("cards");

        Scanner scanner = new Scanner(System.in);

        // ask the user to enter a user name.
        // Search for the key in the array.
        boolean found = false;
        for (Object o : array) {

            JSONObject object = (JSONObject) o;
            if (object.get("card_number").equals(cardnum)) {
                found = true;
                Useramount = object.get("amount").toString();
                int amount = Integer.parseInt(Useramount);
                if (amount > price) {
                    return true;

                } 
            
            else {

                    return false;

                }
            }
        }
                if (!found) {
                    System.out.println("the user with card ID " + cardnum + " not register.");
                }
                return false;
            }
 
}
