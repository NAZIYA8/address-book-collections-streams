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
     * This is the main method.
     *
     * @param args
     */
    public static void main(String args[]) {
        AddressBookMain addressBookContacts = new AddressBookMain();
        System.out.println("Enter number of contact details to enter:");
        int numOfContact = sc.nextInt();
        for (int i = 0; i < numOfContact; i++) {
            System.out.print("Enter FirstName,Last Name,address,city,state,pinCode,phoneNumber,email");
            String firstName = sc.next();
            String lastName = sc.next();
            String address = sc.next();
            String city = sc.next();
            String state = sc.next();
            int pinCode = sc.nextInt();
            long phoneNumber = sc.nextLong();
            String emailId = sc.next();
            addressBookContacts.addNewContact(firstName, lastName, address, city, state, pinCode, phoneNumber, emailId);
        }
        addressBookContacts.editContact();
        System.out.println("Enter first name and last name of contact to be deleted: ");
        String firstName = sc.next();
        String lastName = sc.next();
        addressBookContacts.deleteContactDetails(firstName, lastName);
    }

    /**
     * Adds new Contact to Address book that has a unique name
     * Display contact detail and Address book name
     */
    private void addNewContact(String firstName, String lastName, String address, String city, String state, int pinCode, long phoneNumber, String emailId) {
        contactArray[numOfContact] = new Contact(firstName, lastName, address, city, state, pinCode, phoneNumber, emailId);
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
                System.out.print("Enter address,city,state,pincode,phonenumber,email");
                String ad = sc.next();
                contactArray[i].setAddress(ad);
                String ci = sc.next();
                contactArray[i].setCity(ci);
                String st = sc.next();
                contactArray[i].setState(st);
                int pin = sc.nextInt();
                contactArray[i].setPinCode(pin);
                long num = sc.nextLong();
                contactArray[i].setPhoneNumber(num);
                String em = sc.next();
                contactArray[i].setEmailId(em);
                System.out.println(contactArray[i]);
                break;
            }
        }
    }

    /**
     * Delete contact details of a record of a
     * person using their First Name.
     */
    public void deleteContactDetails(String firstName, String lastName) {
        for (int i = 0; i < numOfContact; i++) {
            if (contactArray[i].firstName.equals(firstName) && contactArray[i].lastName.equals(lastName)) {
                contactArray[i] = null;
                System.out.println("Contact deleted");
                break;
            }
        }
    }
}