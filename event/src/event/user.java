package event;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

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
        write_in_file(firstname, lastname, phonenumber, userEmail, usercity, username, password,repassword);

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

    public void write_in_file(String firstname, String lastname, String phonenumber, String userEmail, String usercity, String username, String password,String repassword) throws IOException {
      {
          try{
        File file = new File("user_accounts.txt");
         FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
         BufferedWriter wr = new BufferedWriter(fw);
         
         
       // wr.write("\n user information\n ");
        wr.write(""+firstname + " " + lastname 
       +" "+username +" "+ password 
       +" "+userEmail 
        +" "+phonenumber 
        +" "+usercity);
            
         wr.close();
         
         System.out.println("Account created and saved to file!");
 } catch (IOException e) {
         System.out.println("Error creating file: " + e.getMessage());
 }
      }
    }
    
    
    public void checkLogin(String email,String pass){
        
        
    }
}
