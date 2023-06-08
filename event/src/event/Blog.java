/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

/**
 *
 * @author 96656
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Blog {
    private String userName;
    private String password;

   

    Blog(String userName, String password) {
         this.userName = userName;
        this.password = password;
    }

    public void setUserName(String username) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void showBlogMenu() {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("---- Blog ----");
            System.out.println("1-Show all reviews");
            System.out.println("2-Show my own reviews");
            System.out.println("3-Write a review");

            int choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    seeReviews();
                    break;
                case 2:
                    seeOwnReviews();
                    break;
                case 3:
                    writeReview();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

   private void seeReviews() throws FileNotFoundException, IOException {
    System.out.println("---- Reviews ----");
    List<String> places = new ArrayList<>(getAllPlaces());
    System.out.println("Available places:");
    for (int i = 0; i < places.size(); i++) {
        System.out.println((i+1) + ". " + places.get(i));
    }
    System.out.println("Enter the number of the place to see reviews:");
    Scanner keyboard = new Scanner(System.in);
    int placeNumber = keyboard.nextInt();
    keyboard.nextLine(); // consume the newline character

    if (placeNumber <= 0 || placeNumber > places.size()) {
        System.out.println("Invalid place number. Please try again.");
    } else {
        String placeName = places.get(placeNumber-1);
        List<String[]> reviews = getReviewsForPlace(placeName);
        if (reviews.isEmpty()) {
            System.out.println("No reviews found for " + placeName + ".");
        } else {
            System.out.println("Reviews for " + placeName + ":");
            for (String[] review : reviews) {
                String username = review[0];
                String reviewText = review[1];
                System.out.println("- review of user [" + username + "]: " + reviewText);
            }
        }
    }
}
private void writeReview() throws IOException, FileNotFoundException, ParseException {
    Scanner keyboard = new Scanner(System.in);
    List<String> reservations = getUserReservations(this.userName);
    if (reservations.isEmpty()) {
        System.out.println("You haven't made any reservations yet.");
    } else {
        while (true) {
            System.out.println("Choose another place you've reserved before to write a review for:");
            for (int i = 0; i < reservations.size(); i++) {
                System.out.println((i + 1) + ". " + reservations.get(i));
            }
            int reservationChoice = 0;
            while (reservationChoice == 0) {
                System.out.print("Enter your choice: ");
                if (keyboard.hasNextInt()) {
                    reservationChoice = keyboard.nextInt();
                    if (reservationChoice <= 0 || reservationChoice > reservations.size()) {
                        System.out.println("Invalid choice. Please try again.");
                        reservationChoice = 0;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    keyboard.next(); // consume the non-integer input
                }
            }
            String reservation = reservations.get(reservationChoice - 1);
            System.out.println("Write your review for " + reservation + ":");
            keyboard.nextLine(); // consume the newline character
            String review = keyboard.nextLine();
            System.out.println("Your review is:");
            System.out.println(review);
            System.out.println("Do you want to publish the review (P), rewrite it (R), or choose another reservation (C)?");
            String choice = keyboard.next();
            while (!choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("R") && !choice.equalsIgnoreCase("C")) {
                System.out.println("Invalid choice. Please enter P to publish, R to rewrite, or enter (m)to go back to main menu");
                choice = keyboard.next();
            }
            if (choice.equalsIgnoreCase("P")) {
                saveReview(this.userName, reservation, review);
                System.out.println("Review published.");
                break; // exit the loop and return to the main menu
            } else if (choice.equalsIgnoreCase("R")) {
                // continue the loop and write a new review for the same reservation
            } else { // choice is "C"
                break; // exit the loop and return to the main menu
            }
        }
    }
}

   private void seeOwnReviews() throws FileNotFoundException, IOException {
    System.out.println("---- Your Reviews ----");
    Set<String> places = getAllPlaces();
    System.out.println("Available places:");
    for (String place : places) {
        System.out.println("- " + place);
    }
    System.out.println("Enter the name of the place to see your reviews:");
    Scanner keyboard = new Scanner(System.in);
    String placeName = keyboard.nextLine();

    List<String[]> reviews = getReviewsByUser(this.userName);
    boolean foundReviews = false;
    for (String[] review : reviews) {
        if (review[0].equals(placeName)) {
            String reviewText = review[1];
            System.out.println("- " + reviewText);
            foundReviews = true;
        }
    }
    if (!foundReviews) {
        System.out.println("No reviews found for " + placeName + ".");
    }
}

 private static Set<String> getAllPlaces() throws FileNotFoundException {
    Set<String> places = new HashSet<>();
    JSONParser parser = new JSONParser();
    Object obj;
    try {
        obj = parser.parse(new FileReader("places.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray studyAreas = (JSONArray) jsonObject.get("cafe");
        JSONArray weddings = (JSONArray) jsonObject.get("hall");
        for (Object studyAreaObj : studyAreas) {
            JSONObject studyArea = (JSONObject) studyAreaObj;
            String placeName = (String) studyArea.get("place name");
            places.add(placeName);
        }
        for (Object weddingObj : weddings) {
            JSONObject wedding = (JSONObject) weddingObj;
            String placeName = (String) wedding.get("place name");
            places.add(placeName);
        }
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
    return places;
}

  private static List<String[]> getReviewsForPlace(String placeName) throws FileNotFoundException {
    List<String[]> reviews = new ArrayList<>();
    Scanner scanner = new Scanner(new File("reviews.txt"));
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        String username = parts[0];
        String reservation = parts[1];
        String review = parts[2];
        if (reservation.equals(placeName)) {
            reviews.add(new String[]{username, review});
        }
    }
    return reviews;
}

private List<String> getUserReservations(String username) throws FileNotFoundException, IOException {
    List<String> reservations = new ArrayList<>();
    JSONParser parser = new JSONParser();
    try (Reader reader = new FileReader("UserReservation.json")) {
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray reservationsArray = (JSONArray) jsonObject.get("Reservation");
        for (Object obj : reservationsArray) {
            JSONObject reservation = (JSONObject) obj;
            String reservedBy = (String) reservation.get("User Name");
            String place = (String) reservation.get("Place Name");
            if (reservedBy.equals(username)) {
                reservations.add(place);
            }
        }
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return reservations;
}

 private void saveReview(String username, String reservation, String review) throws FileNotFoundException, IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("reviews.txt"))) {
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = reader.readLine();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter("reviews.txt"))) {
            writer.print(sb.toString());
            writer.printf("%s,%s,%s%n", username, reservation, review);
        }
    } catch (FileNotFoundException e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("reviews.txt"))) {
            writer.printf("%s,%s,%s%n", username, reservation, review);
        }
    }
}
    
    private List<String[]> getReviewsByUser(String username) throws FileNotFoundException {
    List<String[]> reviews = new ArrayList<>();
    Scanner scanner = new Scanner(new File("reviews.txt"));
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        String reviewUsername = parts[0];
        String reservation = parts[1];
        String review = parts[2];
        if (reviewUsername.equals(username)) {
            reviews.add(new String[]{reservation, review});
        }
    }
    return reviews;
}
}