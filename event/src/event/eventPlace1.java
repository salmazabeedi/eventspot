package event;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import static java.util.Calendar.PM;
import org.json.simple.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class eventPlace1 {

    private static Map<Date, Boolean> reservations = new HashMap<>();

    public eventPlace1(String user) throws FileNotFoundException, IOException, ParseException {

        int choose;
        String type = null;
        String day, date;
        int guestnum;
        String userName = user;
        Scanner keyboard = new Scanner(System.in);
        JSONParser parser = new JSONParser();

        while (true) {
            // Display the event types
            displayEventSpotsTypes();

            choose = keyboard.nextInt();
            switch (choose) {
                case 1:
                    type = "cafe";
                    break;
                case 2:
                    type = "hall";
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            // Display the event places for the chosen type
            displayEventPlaces(type);

            // Ask the user to choose a place and display its information
            keyboard.nextLine();
            String choice = keyboard.nextLine();
            JSONObject object = getObjectFromChoice(type, choice, parser);
            if (object != null) {
                String placeN = object.get("place name").toString();
                String price = object.get("price").toString();
                String category = object.get("catogery").toString();
                String location = object.get("location").toString();
                String capacity = object.get("guest capacity").toString();
                System.out.println("Your choice is " + placeN);
                System.out.println("Category: " + category);
                System.out.println("Guest Capacity: " + capacity);
                System.out.println("Location: " + location);
                System.out.println("Price: " + price);

<<<<<<< Updated upstream
                // Ask the user to choose a place and display its information
                keyboard.nextLine();
                String choice = keyboard.nextLine();
                JSONObject object = placeMap.get(choice);
                if (object != null) {
                    String placeN = object.get("place name").toString();
                    String price = object.get("price").toString();
                    String category = object.get("catogery").toString();
                    String location = object.get("location").toString();
                    String capacity = object.get("guest capacity").toString();
                    System.out.println("Your choice is " + placeN);
                    System.out.println("Category: " + category);
                    System.out.println("Guest Capacity: " + capacity);
                    System.out.println("Location: " + location);
                    System.out.println("Price: " + price);

                    while (true) {
                        System.out.println("Enter - 'back'-  to go back to the places list or - 'book' - to make a booking:");
                        String action = keyboard.nextLine();
                        if (action.equalsIgnoreCase("back")) {
                            break;
                        } else if (action.equalsIgnoreCase("book")) {
                            System.out.println("Enter the number of your guests:");
                            guestnum = keyboard.nextInt();
                            int c = Integer.parseInt(capacity);
                            if (c < guestnum) {
                                System.out.println("Sorry, your guest countis greater than the place capacity.");
                            } else {
                                double newPrice = 0;

                                String numberWithoutPerson = price.replace(" per person", "");

                                int hourlyRate = Integer.parseInt(numberWithoutPerson);
                                newPrice = hourlyRate * guestnum;
                                System.out.println("price:" + newPrice);
                                keyboard.nextLine();

                                Scanner scanner = new Scanner(System.in);

                                // Prompt the user to enter the date of reservation
                                System.out.print("Enter the date of your reservation (dd/mm/yyyy): ");
                                date = scanner.nextLine();
                                Date reservationDate = parseDate(date);

                                // Check if the entered date is available
                                if (!isDateAvailable(reservationDate)) {
                                    System.out.println("Sorry, this date is not available.");
                                } else {
                                    // Add the reservation to the list of reservations
                                    reservations.put(reservationDate, true);
                                    System.out.println("Reservation made successfully for " + reservationDate);
                                }

                                //=======================================================
                                reservation.saveReservation(userName, placeN, category, location, guestnum, (int) newPrice, price, date);
                                System.out.println("Booking for " + placeN + " confirmed!");
                                return;
                            }
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
=======
                while (true) {
                    System.out.println("Enter - 'back'-  to go back to the places list or - 'book' - to make a booking:");
                    String action = keyboard.nextLine();
                    if (action.equalsIgnoreCase("back")) {
                        break;
                    } else if (action.equalsIgnoreCase("book")) {
                        displayBookingForm(keyboard, userName, placeN, category, location, price, capacity);
                        return;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
>>>>>>> Stashed changes
                    }
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

<<<<<<< Updated upstream
    private static boolean isDateAvailable(Date date) {
        // Check if the date is already reserved
        if (reservations.containsKey(date) && reservations.get(date)) {
            return false;
        }

        return true;
    }

    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (java.text.ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use dd/mm/yyyy.");
        }
    }
}
=======
   private static void displayBookingForm(Scanner keyboard, String userName, String placeN, String category, String location, String price, String capacity) throws IOException, FileNotFoundException, ParseException {
    while (true) {
        System.out.println("Enter the number of your guests:");
        int guestnum = keyboard.nextInt();
        int c = Integer.parseInt(capacity);
        if (c < guestnum) {
            System.out.println("Sorry, your guest count is greater than the place capacity. Please try again.");
        } else {
            double newPrice = 0;

            String numberWithoutPerson = price.replace(" per person", "");

            int hourlyRate = Integer.parseInt(numberWithoutPerson);
            newPrice = hourlyRate * guestnum;
            System.out.println("price:" + newPrice);
            keyboard.nextLine();

           Scanner scanner = new Scanner(System.in);
    boolean validDate = false;
    Date reservationDate = null;
 String date=null;
    while (!validDate) {
        System.out.print("Enter the date of your reservation (dd/mm/yyyy): ");
         date = scanner.nextLine();
        try {
            reservationDate = parseDate(date);
            if (!isDateAvailable(reservationDate)) {
                System.out.println("Sorry, this date is not available.");
            } else {
                validDate = true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    // Add the reservation to the list of reservations
    reservations.put(reservationDate, true);
    System.out.println("Reservation for date : " + reservationDate);
    
                boolean paymentSuccessful = displayPaymentForm(keyboard, userName, placeN, category, location, guestnum, newPrice, price, date);
                if (paymentSuccessful) {
                    confirmBooking(userName, placeN, category, location, guestnum, (int) newPrice, price, date);
                } else {
                    cancelBooking(userName, placeN, category, location, guestnum, (int) newPrice, price, date);
                }
                return;
            }
        }
    }


private static boolean displayPaymentForm(Scanner keyboard, String userName, String placeN, String category, String location, int guestnum, double newPrice, String price, String date) throws IOException, FileNotFoundException, ParseException {
    int numTries = 0;
    boolean confirm = false;
    
    while (numTries < 3 && !confirm) {
        System.out.println("Enter your card ID (you have " + (3 - numTries) + " tries left):");
        String cardNum = keyboard.nextLine();
        confirm = payment.paymentCheck(cardNum, (int) newPrice);
        if (!confirm) {
            numTries++;
            System.out.println("Sorry, the card ID you entered is incorrect. Please try again.");
        }
    }
    
    if (!confirm) {
        System.out.println("You have exceeded the maximum number of attempts to enter your card ID.");
        System.out.println("Please contact customer support for assistance.");
    }
    
    return confirm;
}

private static void confirmBooking(String userName, String placeN, String category, String location, int guestnum, int price, String priceStr, String date) throws IOException, FileNotFoundException, ParseException {
    reservation.saveReservation(userName, placeN, category, location, guestnum, price, priceStr, date);
    System.out.println("Booking for " + placeN + " confirmed!");
}

private static void cancelBooking(String userName, String placeN, String category, String location, int guestnum, int price, String priceStr, String date) {
    System.out.println("Booking for " + placeN + " cancelled.");
}
    
   

    private static void displayEventPlaces(String type) throws IOException, ParseException {
        System.out.println("Please choose from the following:");

        // Read the event places from the JSON file for the chosen type
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("places.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray array = (JSONArray) jsonObject.get(type);

            // Loop through the places and display their names
            int placeCount = 1;
            Map<String, JSONObject> placeMap = new HashMap<>();
            for (Object o : array) {
                JSONObject object = (JSONObject) o;
                String placeName = object.get("place name").toString();
                System.out.println(placeCount + ". " + placeName + "");
                placeMap.put(String.valueOf(placeCount), object);
                placeCount++;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getObjectFromChoice(String type, String choice, JSONParser parser) {
        try (FileReader reader = new FileReader("places.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray array = (JSONArray) jsonObject.get(type);

            // Get the chosen place object from the JSON array
            JSONObject object = null;
            Map<String, JSONObject> placeMap = new HashMap<>();
            for (Object o : array) {
                JSONObject place = (JSONObject) o;
                String placeCount = String.valueOf(placeMap.size() + 1);
                placeMap.put(placeCount, place);
                if (placeCount.equals(choice)) {
                    object = place;
                    break;
                }
            }
            return object;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

private static boolean isDateAvailable(Date date) {
    // Check if the date is already reserved
    if (reservations.containsKey(date) && reservations.get(date)) {
        return false;
    }

    return true;
} // isDateAvailable

private static Date parseDate(String dateStr) {
    try {
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
    } catch (java.text.ParseException e) {
        throw new IllegalArgumentException("Invalid date format. Please use dd/mm/yyyy.");
    }
}//Date parseDate
    

    private static void displayEventSpotsTypes() {
        System.out.println("Choose from the following event types:");
        System.out.println("1. cafes");
        System.out.println("2. halls");
    }
}
>>>>>>> Stashed changes
