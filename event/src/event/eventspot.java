
package event;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
>>>>>>> Stashed changes
import java.util.Scanner;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes


public class eventspot {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        
<<<<<<< Updated upstream
    
=======
        welcome();
        

>>>>>>> Stashed changes
        int choice = 0;
        boolean repeat = true;

        do {
<<<<<<< Updated upstream
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

=======
         System.out.println("---- Event spot---- ");
         System.out.println("1-sign in");
         System.out.println("2-create account");
         System.out.println("3-access reservations");
         System.out.println("4-view blog");
         System.out.println("5-exit");
         System.out.println("************************");

            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            System.out.println("___");

            switch (choice) {

                case 1:
                    displaysignInForm();
                    break;

                case 2:
                    displayCreateAccountForm();
>>>>>>> Stashed changes
                    break;

                case 3:
                    accessReservations();
                    break;

                case 4:
                    displayBlogForm();
                    break;

                case 5:
                    System.out.println("Thank you for using Event spot!");
                    repeat = false;
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
        }


        } while (repeat);
    }

    public static void displaysignInForm() throws IOException, ParseException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nplease enter your user name:");
        String userName = keyboard.nextLine();
        System.out.println("please enter your password:");
        String password = keyboard.nextLine();

        user newUser = new user();
        if (newUser.checkLogin(userName, password)) {
            signInSuccess(userName);
            eventPlace1 place = new eventPlace1(userName);
        } else {
            signInFailure();
        }
    }

    public static void signInSuccess(String userName) {
        System.out.println("sign in done successfully as user " + userName);
        System.out.println("**********************************");
    }

    public static void signInFailure() {
        System.out.println("sign in failed : Invalid user name or password. Please try again.");
    }

    public static void accessReservations() throws IOException, ParseException {
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
<<<<<<< Updated upstream
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
=======
        System.out.println("please enter your password:");
        String password = scanner.nextLine();
        userandpass user2 = new userandpass(userN,password);

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
>>>>>>> Stashed changes
                    System.out.println("Catogery: " + object.get("Category"));
                    System.out.println("number of guest: " + object.get("Guest Count"));
                    System.out.println("Location: " + object.get("Location"));
                    System.out.println("Your bill: " +object.get("Current Price"));
                    System.out.println("Date: " + object.get("Date"));
<<<<<<< Updated upstream
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
=======
                    
                }
                // If the user was not found, print an error message.
                else if (found) {
                    System.out.println("the user " + userN + " not have a reservation.");
                }
            }
        }
    }

public static void displayCreateAccountForm() throws IOException, FileNotFoundException, ParseException {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your personal information:");

    System.out.print("First name: ");
    String firstName = input.nextLine().trim();
    while (!firstName.matches("[a-zA-Z]+")) {
        System.out.print("\nInvalid first name. Please enter only letters for the name \nFirst name: ");
        firstName = input.nextLine().trim();
    }
    System.out.println("____________");

    System.out.print("Last name: ");
    String lastName = input.nextLine().trim();
    while (!lastName.matches("[a-zA-Z]+")) {
        System.out.print("\nInvalid last name. Please enter only letters for the name \nLast name: ");
        lastName = input.nextLine().trim();
    }
    System.out.println("____________");

    System.out.print("Phone number (starting with 05 and with a length of 10 digits): ");
    String phoneNumber = input.nextLine().trim();
    while (!phoneNumber.matches("05[0-9]{8}")) {
        System.out.print("\nInvalid phone number. Please enter a valid phone number starting with 05 and with a length of 10 digits \nPhone number: ");
        phoneNumber = input.nextLine().trim();
    }
    System.out.println("____________");

    System.out.println("Enter your card ID");
    String cardNum = input.nextLine();
    Random random = new Random();
     int amount = random.nextInt(100000);
    

    boolean validEmail = false;
    String Email = null;
    System.out.println("____________");
    do{
        System.out.print("Email address (in the format *****@**.*****): ");
        Email = input.nextLine().trim();
        System.out.println("____________");

        if (Email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            validEmail = true;
        } else {
            System.out.println("Invalid email address. Please try again.");
        }
    } while (!validEmail);

    // check password
    boolean validpass = false;
    String password = null;
    String repass = null;
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
            System.out.println("*Passwords do not match. Please try again*");
        }
    } while (!validpass);

    System.out.println("please enter your city:");
    String city = input.nextLine().trim();
    System.out.println("____________");

    System.out.print("Please enter a username: ");
    String userName = input.nextLine().trim();
    System.out.println("____________");

    user u1 = new user(firstName, lastName, phoneNumber, Email, city, userName, password, repass);
    String message = u1.saveAccountInfo(firstName, lastName, phoneNumber, Email, city, userName, password, repass);
    u1.CardInfo(cardNum, amount);
    System.out.println(message);
}
    
    public static void welcome() {
        System.out.println("************************Welcome to Event spot!************************");
        System.out.println("*******our main job is finding the perfect spot for your event*******");
     
        System.out.println("************************");
    }

    public static void displayBlogForm() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nplease enter your user name:");
        String userName = input.nextLine();
        System.out.println("please enter your password:");
        String password = input.nextLine();

        user newUser = new user();
        if (newUser.checkLogin(userName, password)) {
            signInSuccess(userName);
           Blog blog = new Blog(userName, password);
             blog.showBlogMenu();
        } else {
            signInFailure();
        }

     
       
>>>>>>> Stashed changes
    }
}