package event;


import java.io.*;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class user {

    String firstname, lastname, phonenumber, userEmail, usercity, username, password,repass,day;
    
public user(){
    
}
    public user(String firstname, String lastname, String phonenumber, String userEmail, String usercity, String username, String password,String repassword) throws IOException {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.userEmail = userEmail;
        this.usercity = usercity;
        this.username = username;
        this.password = password;
        repass=repassword;
        saveAccountInfo(firstname, lastname, phonenumber, userEmail, usercity, username, password,repassword);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUsercity() {
        return usercity;
    }

    public void setUsercity(String usercity) {
        this.usercity = usercity;
    }

   public String saveAccountInfo(String firstname, String lastname, String phonenumber, String userEmail, String usercity, String username, String password,String repassword) throws IOException {
    try{
        File file = new File("user_accounts.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter wr = new BufferedWriter(fw);
         
        wr.write(""+firstname + " " + lastname 
       +" "+username +" "+ password 
       +" "+userEmail 
       +" "+phonenumber 
       +" "+usercity);
            
        wr.close();
        return "Account created and saved to file!";
    } catch (IOException e) {
        return "Error creating file: " + e.getMessage();
    }
}
    
    
  //  public void checkLogin(String email,String pass){
        
        
   // }
    
    public void CardInfo(String cardNum, int amount) throws FileNotFoundException, IOException, ParseException {
      
        JSONParser parser = new JSONParser();
        File file = new File("cards.json");
        FileReader reader = new FileReader(file);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        JSONArray array = (JSONArray) jsonObject.get("cards");
        JSONObject user = new JSONObject();
        user.put("card_number", cardNum);
        user.put("amount", amount);

        array.add(user);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonObject.toJSONString());

        }

    }
    public boolean checkLogin(String userName, String password) throws IOException {
    // Open the file for reading using FileReader and BufferedReader
    boolean flag = false;
    Scanner input = new Scanner(new FileInputStream("user_accounts.txt"));

    while (input.hasNextLine()) {
        String line = input.nextLine();//reading line by line
        if (line.contains(userName) && line.contains(password)) {
            flag = true;
            break;
        }
    }

    input.close();
    return flag;
}
    
}