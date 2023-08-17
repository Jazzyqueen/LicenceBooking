/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package licencebooking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Reverside
 */
public class BookingProcessor {
    private List<User> userBookings;

    public BookingProcessor() {
        userBookings = new ArrayList<>();
    }

    public void bookUser(String idNumber) {
        validateIdNumber(idNumber);
        User user = new User(idNumber);
        userBookings.add(user);
    }

    public void processBookings() {
        Iterator<User> iterator = userBookings.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            String idNumber = user.getIdNumber();

            // Process the booking here
            System.out.println("Processing booking for user with ID: " + idNumber);
            iterator.remove();
        }
    }


    private void validateIdNumber(String idNumber) {
       if (idNumber.length() != 13) {
        throw new IllegalArgumentException("ID number must be 13 digits long");
    }
    }

    void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
