package event;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author w
 */
public class userandpass {

    String userName, pass;
      String TitalLine[]=
 {"firstName"," lastName", "phoneNumber", "Email", "city"," userName", "password"," repass"};

    public userandpass(String un, String pass) {
        this.userName = un;
        this.pass = pass;

    }

    userandpass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean checkLogin() throws IOException {
        // Open the file for reading using FileReader and BufferedReader
                boolean flag = false;

        Scanner input = new Scanner(new FileInputStream("user_accounts.txt"));
        
    while (input.hasNextLine()) {
                   
            String line = input.nextLine();//reading line by line
            // System.out.println(line);
            if (line.contains(userName)) {
                       for(int i=0;i<8;i++){
          System.out.print("  "+TitalLine[i]+" ");
                          return true;

                            }
        System.out.println();
   
                flag = true;
            }
            
        } if (!flag) {
            System.out.println("there is no one have  this user name in our system");

        }    
        return false;
        
    }

}