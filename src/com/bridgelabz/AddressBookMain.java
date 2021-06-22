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

import java.util.*;

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contactArrayList;
    private Map<String, Contact> nameToContactMap;
    public Map<String, List<Contact>> cityToContactMap;
    public Map<String, List<Contact>> stateToContactMap;

    public AddressBookMain() {
        contactArrayList = new ArrayList<>();
        this.nameToContactMap = new LinkedHashMap<String, Contact>();
    }

    public List<Contact> getContactArray() {
        return contactArrayList;
    }

    public Map<String, Contact> getContactMap() {
        return nameToContactMap;
    }

    /**
     * Adds new Contact to Address book that has a unique name
     * Display contact detail and Address book name as key value pair
     */
    public void addNewContact() {
        String firstName = "";
        String lastName = "";
        while (true) {
            System.out.println("Enter First Name");
            firstName = sc.next();
            System.out.println("Enter last Name");
            lastName = sc.next();
            if (checkForDuplicate(firstName, lastName))
                continue;
            else
                break;
        }
        System.out.println("Enter the Address");
        String address = sc.next();
        System.out.println("Enter the City");
        String city = sc.next();
        System.out.println("Enter the State");
        String state = sc.next();
        System.out.println("Enter the Pin code");
        int pinCode = sc.nextInt();
        System.out.println("Enter the Number");
        long phoneNumber = sc.nextLong();
        System.out.println("Enter the Email");
        String emailId = sc.next();
        Contact newContact = new Contact(firstName, lastName, address, city, state, pinCode, phoneNumber, emailId);
        this.contactArrayList.add(newContact);
        String name = firstName + " " + lastName;
        this.nameToContactMap.put(name, newContact);
    }

    /**
     * This method is used to print the contacts
     */
    public void printContacts() {
        System.out.println(contactArrayList);
    }

    /**
     * Edit existing contact using their name
     */
    public void editContact() {
        System.out.println("Enter The First Name to edit the contact details");
        String firstName = sc.next();
        System.out.println("Enter The last Name to edit the contact details");
        String lastName = sc.next();
        String name = firstName + " " + lastName;
        Contact editedObject = nameToContactMap.get(name);
        System.out.print("Enter address,city,state,pinCode,phoneNumber,email");
        String address = sc.next();
        editedObject.setAddress(address);
        String city = sc.next();
        editedObject.setCity(city);
        String state = sc.next();
        editedObject.setState(state);
        int pin = sc.nextInt();
        editedObject.setPinCode(pin);
        long number = sc.nextLong();
        editedObject.setPhoneNumber(number);
        String email = sc.next();
        editedObject.setEmailId(email);
    }

    /**
     * Delete contact details of a record of a
     * person using their First Name.
     */
    public void deleteContactDetails() {
        System.out.println("Enter The First Name to delete the contact details");
        String firstName = sc.next();
        System.out.println("Enter The last Name to delete the contact details");
        String lastName = sc.next();
        String name = firstName + " " + lastName;
        Contact object = nameToContactMap.get(name);
        contactArrayList.remove(object);
        nameToContactMap.remove(name);
        System.out.println("Contact deleted");

    }

    /**
     * This method is used to check for duplicated
     *
     * @param firstname of the person
     * @param lastname  of the person
     */
    public boolean checkForDuplicate(String firstname, String lastname) {
        if (contactArrayList.stream().anyMatch(obj -> obj.getFirstName().equals(firstname))
                && contactArrayList.stream().anyMatch(obj -> obj.getLastName().equals(lastname))) {
            System.out.println("This contact already exists, try again!!");
            return true;
        } else
            return false;
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
            System.out.println("\n4. Show Contact details");
            System.out.println("\n5. Exit");
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
                    printContacts();
                    break;
                case 5:
                    System.out.println("Exit");
                    check = false;
                    break;
            }
        }
    }
}
