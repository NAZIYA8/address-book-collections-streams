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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Contact> contactArrayList;
    private Map<String, Contact> nameToContactMap;

    public AddressBookMain() {
        contactArrayList = new ArrayList<>();
        nameToContactMap = new HashMap<>();
    }

    /**
     * Adds new Contact to Address book that has a unique name
     * Display contact detail and Address book name as key value pair
     */
    public void addNewContact() {
        System.out.println("Enter the First Name");
        String firstName = sc.next();
        System.out.println("Enter the last Name");
        String lastName = sc.next();
        System.out.println("Enter the Address");
        String address = sc.next();
        System.out.println("Enter the City");
        String city = sc.next();
        System.out.println("Enter the State");
        String state = sc.next();
        System.out.println("Enter the Zipcode");
        int pinCode = sc.nextInt();
        System.out.println("Enter Phone Number");
        long phoneNumber = sc.nextLong();
        System.out.println("Enter the Email address");
        String emailId = sc.next();
        Contact contact = new Contact(firstName, lastName, address, city, state, pinCode, phoneNumber, emailId);
        contactArrayList.add(contact);
        nameToContactMap.put(contact.getFirstName() + " " + contact.getFirstName(), contact);
    }

    /**
     * Edit existing contact using their name
     */
    public void editContact() {
        System.out.println("Enter The First Name And Last Name to edit the contact details");
        String firstName = sc.next();
        String lastName = sc.next();
        String name = firstName + " " + lastName;
        Contact object = nameToContactMap.get(name);
        System.out.print("Enter address,city,state,pincode,phonenumber,email");
        String ad = sc.next();
        object.setAddress(ad);
        String ci = sc.next();
        object.setCity(ci);
        String st = sc.next();
        object.setState(st);
        int pin = sc.nextInt();
        object.setPinCode(pin);
        long num = sc.nextLong();
        object.setPhoneNumber(num);
        String em = sc.next();
        object.setEmailId(em);
    }

    /**
     * Delete contact details of a record of a
     * person using their First Name.
     */
    public void deleteContactDetails() {
        System.out.println("Enter The First Name And Last Name to delete the contact details");
        String firstName = sc.next();
        String lastName = sc.next();
        String name = firstName + " " + lastName;
        Contact object = nameToContactMap.get(name);
        contactArrayList.remove(object);
        nameToContactMap.remove(name);

    }

    /**
     * This method is used to maintain the Address book.
     */
    public void maintainAddressBook() {
        boolean check = true;
        while (check == true) {
            System.out.println("\n1. Add Contact Details");
            System.out.println("\n2. Edit Contact Details");
            System.out.println("\n3. Delete Contact Details");
            System.out.println("\n4. Exit");
            System.out.println("\nEnter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    if (contactArrayList.size() == 0)
                        System.out.println("Please Enter contacts");
                    else
                        editContact();
                    break;
                case 3:
                    if (contactArrayList.size() == 0)
                        System.out.println("Please Enter contacts");
                    else
                        deleteContactDetails();
                    break;
                case 4:
                    System.out.println("Exit");
                    check = false;
                    break;
            }
        }
    }
}

