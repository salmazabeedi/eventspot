
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




public class eventspot {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        
    
        int choice = 0;
        boolean repeat = true;
        boolean validEmail = false;
        boolean validpass = false;
        String type = null;
        int choose;
        String firstName, lastName, userName, phoneNumber, Email, password, repass;

        //userandpass user1 = new userandpass();

        do {
            System.out.println("          Event spot ");
            System.out.println("1-sign in");
            System.out.println("2-create account");
            System.out.println("3-access reservations");
            System.out.println("4-exit");
                        System.out.println("************************");

            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
                                    System.out.println("___");

            switch (choice) {
                
                
                case 1:
                    keyboard.nextLine();

                    System.out.println("\nplease enter your user name:");
                    String userName0 = keyboard.nextLine();
                    System.out.println("please enter your password:");
                    String password0 = keyboard.nextLine();
                    
                            userandpass user11 = new userandpass(userName0,password0);

    
  if (user11.checkLogin()) {

                       eventPlace1 place=new eventPlace1(userName0); 
                    } else {
                        repeat = false;
                    }

                    break;

                case 2:
                    keyboard.nextLine();
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please enter your personal information:");

                    System.out.print("First name: ");
                    firstName = input.nextLine();
                        System.out.println("____________");

                    System.out.print("Last name: ");
                    lastName = input.nextLine();
                                            System.out.println("____________");

                    System.out.print("User name: ");
                    userName = input.nextLine();
                                            System.out.println("____________");

                    System.out.print("Phone number: ");
                    phoneNumber = input.nextLine();
                                            System.out.println("____________");

                    
                    

                    do {
                        System.out.print("Email address: ");
                        Email = input.nextLine();
                                                System.out.println("____________");


                        if (Email.contains("@")) {
                            validEmail = true;
                        } else {
                            System.out.println("Invalid email address. Please try again.");
                        }
                    } while (!validEmail);

                    // cheak pass
                    do {
                        System.out.print("Please enter a password: ");
                        password = input.nextLine();
                                                System.out.println("____________");


                        System.out.print("Please re-enter the password: ");
                        repass = input.nextLine();
                                                System.out.println("____________");


                        if (repass.equals(password)) {
                            System.out.println("**Passwords match!**");
                            validpass = true;
                        } else {
                            System.out.println("**Passwords do not match. Please try again**");

                        }
                    } while (!validpass);

                    System.out.println("please enter your city:");
                    String city = keyboard.nextLine();
                                            System.out.println("____________");


                    user u1 = new user(firstName, lastName, phoneNumber, Email, city, userName, password, repass);

                    break;

                case 3:
                    JSONParser parser = new JSONParser();

        // Create a File object for the JSON file.
        File file = new File("UserReservation.json");

        FileReader reader = new FileReader(file);

       
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

       
        JSONArray array = (JSONArray) jsonObject.get("Reservation");

        
        Scanner scanner = new Scanner(System.in);

        // ask the user to enter a user name.
        System.out.println("Please enter a user name : ");
        String userN = scanner.nextLine();
          System.out.println("please enter your password:");
                    String password2= keyboard.nextLine();
        keyboard.nextLine();
                                    userandpass user2 = new userandpass(userN,password2);

if(user2.checkLogin())
{
       // Search for the key in the array.
        boolean found = false;
        for (Object o : array) {
            
            
            JSONObject object = (JSONObject) o;
            
            if (object.get("User Name").equals(userN) ) {
         
                found = true;
                        System.out.println("********************************");

                System.out.println("**** Hi  ( " + userN + "  ) your reservation details is **** ");
                 System.out.println("Place Name: " + object.get("Place Name"));
                    System.out.println("Catogery: " + object.get("Category"));
                    System.out.println("number of guest: " + object.get("Guest Count"));
                    System.out.println("Location: " + object.get("Location"));
                    System.out.println("Your bill: " +object.get("Current Price"));
                    System.out.println("Date: " + object.get("Date"));
                break;
            }
        // If the user was not found, print an error message.
     else if (found) {
            System.out.println("the user " + userN + " not have a reservation.");
        }
        }
}
                    
                    
                case 4: 
                    repeat = false;
            

        
            }
        } while (repeat);
    }
}