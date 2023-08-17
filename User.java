/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package licencebooking;

/**
 *
 * @author Reverside
 */
class User {

    private String firstName;
    private String lastName;
    private String birthday;
    private String idNumber;
    private String gender;

    public User(String firstName, String lastName, String birthday, String idNumber, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.idNumber = idNumber;

        if (validateIdNumber(idNumber)) {
            this.idNumber = idNumber;
        } else {
            System.out.println("Invalid ID number.");
        }

        this.gender = gender;
    }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    User(String idNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean validateIdNumber(String idNumber) {
        if (idNumber.length() != 13) {
            return false;
        }

        String month = idNumber.substring(2, 4);
        String day = idNumber.substring(4, 6);

        int monthValue = Integer.parseInt(month);
        int dayValue = Integer.parseInt(day);

        if (monthValue < 1 || monthValue > 12 || dayValue < 1 || dayValue > 31) {
            return false;
        }

        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getGender() {
        return gender;
    }

    void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
