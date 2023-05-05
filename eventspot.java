/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.io.IOException;
import static java.sql.DriverManager.println;
import java.util.Scanner;

public class eventspot {

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int choice = 0;
        boolean repeat=true;
        userandpass user1=new userandpass();
        do{
        System.out.println("____Event spot____ ");
        System.out.println("1-sign in");
        System.out.println("2-create account");
        System.out.println("3-exit");
         System.out.println("___________________");
        Scanner keyboard = new Scanner(System.in);
        choice = keyboard.nextInt();
        switch (choice) {
            case 1:
                keyboard.nextLine();
                System.out.println("please enter your user name:");
                String userName0 = keyboard.nextLine();
                System.out.println("please enter your password:");
                String password0 = keyboard.nextLine();
                //userandpass user = new userandpass();
                if (user1.checkLogin(userName0, password0)) {
                    System.out.println("correct");
                } else {
                    System.out.println("your password or user not correct ");
                
                }

                break;

            case 2:
                keyboard.nextLine();
                System.out.println("please enter your first name:");
                String firstName = keyboard.nextLine();
                System.out.println("please enter your last name:");
                String lastName = keyboard.nextLine();
                System.out.println("please enter your user name:");
                String userName = keyboard.nextLine();
                System.out.println("please enter your phone number:");
                String phoneNumber = keyboard.nextLine();
                System.out.println("please enter your E-mail:");
                String Email = keyboard.nextLine();
                System.out.println("please enter your password:");
                String password = keyboard.nextLine();
                 System.out.println("please enter your password again:");
                String repass = keyboard.nextLine();
                System.out.println("please enter your city:");
                String city = keyboard.nextLine();
                if(Email.contains("@") && password.equals(repass)){
                     System.out.println("your acount is created");
                }else{
                    System.out.println("failled,try again");
                }
                user1.creat(userName, password);
                user u1 = new user(firstName, lastName, phoneNumber, Email, city, userName, password,repass);
                // public user(String firstname, String lastname, String phonenumber, String userEmail, String usercity, String username, String password)

                break;

        
        case 3: repeat=false ;
      }

     }while(repeat);
        }
}
