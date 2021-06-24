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

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Contact> contactArrayList;

    public AddressBookMain() {
        contactArrayList = new ArrayList<>();
    }

    /**
     * Adds new Contact to Address book that has a unique name
     * Display contact detail and Address book name
     */
    private void addNewContact(String firstName, String lastName, String address, String city, String state, int pinCode, long phoneNumber, String emailId) {
        Contact object = new Contact(firstName, lastName, address, city, state, pinCode, phoneNumber, emailId);
        contactArrayList.add(object);
    }

    /**
     * Edit existing contact using their name
     */
    public void editContact() {
        System.out.println("Enter The First Name And Last Name to edit the contact details");
        String firstName = sc.next();
        String lastName = sc.next();
        for (int i = 0; i < contactArrayList.size(); i++) {
            Contact object = contactArrayList.get(i);
            if (object.firstName.equals(firstName) && object.lastName.equals(lastName)) {
                System.out.print("Enter address,city,state,pinCode,phoneNumber,email");
                String address = sc.next();
                object.setAddress(address);
                String city = sc.next();
                object.setCity(city);
                String state = sc.next();
                object.setState(state);
                int pinCode = sc.nextInt();
                object.setPinCode(pinCode);
                long phoneNumber = sc.nextLong();
                object.setPhoneNumber(phoneNumber);
                String emailId = sc.next();
                object.setEmailId(emailId);
                System.out.println(contactArrayList);
                break;
            }
        }
    }

    /**
     * Delete contact details of a record of a
     * person using their First Name.
     */
    public void deleteContactDetails(String firstName, String lastName) {
        for (int i = 0; i < contactArrayList.size(); i++) {
            Contact object = contactArrayList.get(i);
            if (object.firstName.equals(firstName) && object.lastName.equals(lastName)) {
                contactArrayList.remove(i);
                System.out.println("Contact deleted");
                break;
            }
        }
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
            String email = sc.next();
            addressBookContacts.addNewContact(firstName, lastName, address, city, state, pinCode, phoneNumber, email);
        }
        addressBookContacts.editContact();
        System.out.println("Enter first name and last name of contact to be deleted: ");
        String firstName = sc.next();
        String lastName = sc.next();
        addressBookContacts.deleteContactDetails(firstName, lastName);
    }
}