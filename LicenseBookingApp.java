/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package licencebooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

/**
 *
 * @author Reverside
 */
public class LicenseBookingApp {
    private List<User> users = new ArrayList<>();
    private List<User> bookings = new ArrayList<>();       
    private Scanner scanner = new Scanner(System.in);

       public void validateIdNumber(String idNumber)  {
    // Check if the ID number has the correct length
    if (idNumber.length() != 13) {
        System.out.println("ID number must be 13 digits long");
    }

    // Extract the month and day portions from the ID number
    String monthPart = idNumber.substring(2, 4);
    String dayPart = idNumber.substring(4, 6);

    // Convert the month and day strings to integers
    int month = Integer.parseInt(monthPart);
    int day = Integer.parseInt(dayPart);

    // Validate the month 
    if (month < 1 || month > 12) {
        System.out.println("Invalid month");
    }

    // Validate the day 
    if (day < 1 || day > 31) {
        System.out.println("Invalid day");
    }
       }

    public void registerUser() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter birthday (YYYY-MM-DD): ");
        String birthday = scanner.nextLine();
        System.out.print("Enter ID number: ");
        String idNumber = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        try {
            validateIdNumber(idNumber);
            User user = new User(firstName, lastName, birthday, idNumber, gender);
            users.add(user);
            System.out.println("User registered successfully!");
        } catch (Exception e) {
            System.out.println("Invalid ID number. User registration failed.");
        }
    }
    public void makeBooking() {
        if (users.isEmpty()) {
            System.out.println("No users registered. Cannot make a booking.");
            return;
        }

        System.out.print("Enter user ID for booking: ");
        String userId = scanner.nextLine();

        User user = users.stream()
                .filter(u -> u.getIdNumber().equals(userId))
                .findAny()
                .orElse(null);

        if (user != null) {
            bookings.add(user);
            System.out.println("Booking  made successfully!");
        } else {
            System.out.println("User not found. Booking failed.");
        }
    }

    public void processBookings() {
        
        if (bookings.isEmpty()) {
            System.out.println("No bookings to process.");
            return;
        }

        User processedUser = bookings.get(other);
        System.out.println("Processed booking for: " + processedUser.getFirstName() + " " + processedUser.getLastName());
    }

    public void run() {
        while (true) {
            System.out.println("\nLicense Booking Console Application");
            System.out.println("1. Register User");
            System.out.println("2. Make Booking");
            System.out.println("3. Process Bookings");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    makeBooking();
                    break;
                case "3":
                    processBookings();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

    

