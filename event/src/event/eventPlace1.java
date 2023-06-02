package event;

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

/**
 *
 * @author abodn
 */
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
            System.out.println("Choose from the following event types:");
            System.out.println("1. Study area");
            System.out.println("2. Wedding");
            choose = keyboard.nextInt();
            switch (choose) {
                case 1:
                    type = "studyArea";
                    break;
                case 2:
                    type = "wedding";
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            try (FileReader reader = new FileReader("places.json")) {
                JSONObject jsonObject = (JSONObject) parser.parse(reader);
                JSONArray array = (JSONArray) jsonObject.get(type);
                System.out.println("Please choose from the following:");

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
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
