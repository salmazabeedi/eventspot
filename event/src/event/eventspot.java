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
        boolean repeat = true;
        boolean validEmail = false;
        boolean validpass = false;
        String firstName, lastName, userName, phoneNumber, Email, password, repass;

        userandpass user1 = new userandpass();
        
        do {
            System.out.println("          __Event spot__ ");
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
                    //userandpass user = new userandpass();
                    if (user1.checkLogin(userName0, password0)) {
                        System.out.println("correct");
                    } else {
                        repeat = false;
                    }

                    break;

                case 2:
                    keyboard.nextLine();
// firstName , lastName , userName , phoneNumber , Email , password,repass;
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please enter your personal information:");

                    System.out.print("First name: ");
                    firstName = input.nextLine();

                    System.out.print("Last name: ");
                    lastName = input.nextLine();
                    System.out.print("Last name: ");
                    userName = input.nextLine();
                    System.out.print("Phone number: ");
                    phoneNumber = input.nextLine();

                    do {
                        System.out.print("Email address: ");
                        Email = input.nextLine();

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

                        System.out.print("Please re-enter the password: ");
                        repass = input.nextLine();

                        if (repass.equals(password)) {
                            System.out.println("Passwords match!");
                            validpass = true;
                        } else {
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
            }

        } while (repeat);
    }

}