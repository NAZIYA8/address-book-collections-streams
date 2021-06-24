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

    /**
     * This method is used to create new contacts
     */
    public static void createContacts() {
        Contact contact = new Contact();
        System.out.println("Enter First Name");
        contact.setFirstName(sc.next());
        System.out.println("Enter last Name");
        contact.setLastName(sc.next());
        System.out.println("Enter Address");
        contact.setAddress(sc.next());
        System.out.println("Enter State");
        contact.setState(sc.next());
        System.out.println("Enter City");
        contact.setCity(sc.next());
        System.out.println("Enter Zip");
        contact.setPinCode(sc.nextInt());
        System.out.println("Enter Phone");
        contact.setPhoneNumber(sc.nextInt());
        System.out.println("Enter Email");
        contact.setEmailId(sc.next());
        System.out.println("-------------");
    }

    /**
     * This is the main method where all methods are called.
     * @param args
     */
    public static void main(String args[]) {
        createContacts();
    }
}