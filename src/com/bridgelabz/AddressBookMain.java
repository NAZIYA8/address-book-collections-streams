/**
 * ****************************************************************************
 * Purpose: This class contains a number of methods.
 * This class is used to maintain the Address Book.
 *
 * @author Syeda Naziya
 * @version 1.0
 * @since 22-06-2021
 * ****************************************************************************
 */

package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);
    int numOfContact = 0;
    private Contact[] contactArray;

    public AddressBookMain() {
        contactArray = new Contact[5];
    }

    /**
     * Adds new Contact to Address book that has a unique name
     * Display contact detail and Address book name
     */

    private void addNewContact(String firstName, String lastName, String address, String city, String state, int pinCode, long mobiileNumber, String emailId) {
        contactArray[numOfContact] = new Contact(firstName, lastName, address, city, state, pinCode, mobiileNumber, emailId);
        System.out.println(contactArray[numOfContact]);
        numOfContact++;
    }

    /**
     * This method is used to print the contacts
     */
    public void printContact() {
        System.out.println(contactArray);
    }


    /**
     * Edit existing contact using their name
     */
    public void editContact() {
        System.out.println("Enter The First Name And Last Name to edit the contact details");
        String firstName = sc.next();
        String lastName = sc.next();
        for (int i = 0; i < numOfContact; i++) {
            if (contactArray[i].firstName.equals(firstName) && contactArray[i].lastName.equals(lastName)) {
                System.out.print("Enter address,city,state,pinCode,phoneNumber,email");
                String address = sc.next();
                contactArray[i].setAddress(address);
                String city = sc.next();
                contactArray[i].setCity(city);
                String state = sc.next();
                contactArray[i].setState(state);
                int pinCode = sc.nextInt();
                contactArray[i].setPinCode(pinCode);
                long phoneNumber = sc.nextLong();
                contactArray[i].setPhoneNumber(phoneNumber);
                String email = sc.next();
                contactArray[i].setEmailId(email);
                System.out.println(contactArray[i]);
                break;
            }
        }
    }

    /**
     * This is the main method that calls other methods
     *
     * @param args
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter FirstName,Last Name,address,city,state,pinCode,phoneNumber,email");
        String firstName = sc.next();
        String lastName = sc.next();
        String address = sc.next();
        String cityNew = sc.next();
        String state = sc.next();
        int zip = sc.nextInt();
        long phoneNumber = sc.nextLong();
        String email = sc.next();
        AddressBookMain Contact1 = new AddressBookMain();
        Contact1.addNewContact(firstName, lastName, address, cityNew, state, zip, phoneNumber, email);
        Contact1.editContact();
        Contact1.printContact();
    }
}