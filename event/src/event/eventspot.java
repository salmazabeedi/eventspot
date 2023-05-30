package event;

/**
 *
 * @author 96656
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

public class eventspot {

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        // TODO code application logic here
        
        welcomeMethod();
        int choice = 0;
        boolean repeat = true;
        boolean validEmail = false;
        boolean validpass = false;
        boolean validLogin=false;
        String type = null;
        int choose;
        boolean validPhoneNum=false;
        String firstName, lastName, userName, phoneNumber, Email, password, repass;

        userandpass user1 = new userandpass();

        do {
            
            System.out.println("1-sign in");
            System.out.println("2-create account");
            System.out.println("3-exit");
            System.out.println("___________________________");

            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    keyboard.nextLine();
                    System.out.println("___________________________");

                    System.out.println("\nplease enter your user name:");
                    String userName0 = keyboard.nextLine();
                    System.out.println("please enter your password:");
                    String password0 = keyboard.nextLine();

                  //  if (user1.checkLogin(userName0, password0)) {

                  //     eventPlace1 place=new eventPlace1(); 
                 //   } else {
                       // repeat = false;
                  //  }
                        
                         File readFile= new File("user_accounts.txt");
                         Scanner scan= new Scanner(readFile);
                         String line;
                         ArrayList<String> fileContent= new ArrayList<>();
              
                         while( scan.hasNext() ){
                         line=scan.nextLine();
                         fileContent.add(line);
                         }scan.close();
              
                         for(int i=0; i< fileContent.size() ; i++ ){
                  
                         if(userName0.equalsIgnoreCase(fileContent.get(i))){
                             
                             if (password0.equalsIgnoreCase(fileContent.get(i+1))){
                      
                         System.out.println(" HELLO "+ fileContent.get(i+2) + " again!!!");
                         
                         validLogin=true;
                         eventPlace1 place=new eventPlace1();
                         
                       
                             }
                      
                         }
                         }
                         
                         
                         while(!validLogin)
                         {
                             System.out.println("You have entered invalid username or password\nplease enter your username again :");
                             userName0=keyboard.nextLine();
                             System.out.println("please enter your password:");
                             password0 = keyboard.nextLine();
                             
                             validLogin=false;
                             
                            for(int i=0; i< fileContent.size() ; i++ ){
                  
                            if(userName0.equalsIgnoreCase(fileContent.get(i))){
                             
                            if (password0.equalsIgnoreCase(fileContent.get(i+1))){
                      
                            System.out.println(" HELLO "+ fileContent.get(i+2) + " again!!!");
                         
                             validLogin=true;
                             eventPlace1 place=new eventPlace1();
                     
                         }
                            }
                            }
                         }
                       
                     
                    break;

                case 2:
                    keyboard.nextLine();
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please enter your personal information:");

                    System.out.print("First name: ");
                    firstName = input.nextLine().trim();
                    while (!firstName.matches("[a-zA-Z]+")) {
                    System.out.print("\nInvalid first name. Please enter only letters for the name \nFirst name: ");
                    firstName = input.nextLine().trim();
                    }

                    System.out.print("Last name: ");
                    lastName = input.nextLine().trim();
                    while (!lastName.matches("[a-zA-Z]+")) {
                    System.out.print("\nInvalid last name. Please enter only letters for the name \nLast name: ");
                    lastName = input.nextLine().trim();
                    }
                    System.out.print("User name: ");
                    userName = input.nextLine();
                    do {
                    System.out.print("Phone number (starts with 05 and has a length of 10 digits): ");
                    phoneNumber = input.nextLine().trim();

                    if (phoneNumber.matches("05\\d{8}")) {
                       validPhoneNum = true;
                    } else if (!phoneNumber.matches("\\d+")) {
                    System.out.println("Invalid phone number format. Please enter only digits.");
                    } else if (!phoneNumber.startsWith("05")) {
                    System.out.println("Invalid phone number format. Please enter a number that starts with 05.");
                    } else {
                    System.out.println("Invalid phone number length. Please enter 10 digits.");
                    } 
                    } while (!validPhoneNum);

                   do {
                   System.out.print("Email address: ");
                   Email = input.nextLine();

                    if (Email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
                    validEmail = true;
                    } else {
                    System.out.println("Invalid email address format. Please enter an email address that contains only letters, digits, '.' and '@' characters, and is in the format '*****@**.*'. For example, 'john.doe@example.com'");
                    }
                    } while (!validEmail);

                    // cheak pass
                    do {
                    System.out.print("Please enter a password (at least 6 characters, letters and digits only): ");
                    password = input.nextLine();

                    System.out.print("Please re-enter the password: ");
                    repass = input.nextLine();

                    if (repass.equals(password)) {
                    if (password.matches("^[a-zA-Z0-9]{6,}$")) {
                    validpass = true;
                    } 
                    else {
                    System.out.println("Invalid password format. Please enter a password that has at least 6 characters and contains only letters or digits.");
                    }
                    }
                    else {
                    System.out.println("Passwords do not match. Please try again.");
                    }
                    } while (!validpass);

                    System.out.println("please enter your city:");
                    String city = keyboard.nextLine();

                    user1.creat(userName, password);
                    user u1 = new user(firstName, lastName, phoneNumber, Email, city, userName, password, repass);

                    break;

                case 3:
                    repeat = false;
                
                    
                    
                default:
                System.out.println("Wrong entry. Please enter a valid option(1, 2, or 3).");
                break;    
            }

        } while (repeat);
    }
    
     public static void welcomeMethod(){
       
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------"); 
        System.out.println();
        System.out.println("          *************   welcome to EventSpot app  **************  \n "
                         + "EventSpot is an application where you can find the perfect spot for your event");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------"); 
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------"); 
     
    }
}