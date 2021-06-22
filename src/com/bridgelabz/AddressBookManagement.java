/**
 * ****************************************************************************
 * Purpose: This class is implemented for the address book management.
 * This class contains the main method.
 *
 * @author Syeda Naziya
 * @version 1.0
 * @since 22-06-2021
 * ****************************************************************************
 */

package com.bridgelabz;

import java.util.*;

public class AddressBookManagement {
    static Scanner sc = new Scanner(System.in);
    public static Map<String, AddressBookMain> nameToAddressBookMap = new TreeMap<>();
    public static Map<String, Contact> cityToContactEntryMap = new TreeMap<>();
    public static Map<String, Contact> stateToContactEntryMap = new TreeMap<>();

    /**
     * This method is used to add new Address book
     * having unique name.
     */
    public static void addNewAddressBook() {
        AddressBookMain object = new AddressBookMain();
        System.out.println("Enter a unique name");
        String name = sc.next();
        object.maintainAddressBook();
        nameToAddressBookMap.put(name, object);
    }

    /**
     * This method is used to search the person
     * across multiple address book.
     *
     * @param search
     */
    public static void searchPersonInBook(String search) {
        int numberOfPerson = 0;
        Iterator contactArray = nameToAddressBookMap.entrySet().iterator();
        while (contactArray.hasNext()) {
            Map.Entry entry = (Map.Entry) contactArray.next();
            AddressBookMain a = (AddressBookMain) entry.getValue();
            List<Contact> list = a.getContactArray();
            for (Contact con : list) {
                if (con.getCity().equals(search) || con.getState().equals(search)) {
                    System.out.println(con);
                    numberOfPerson++;
                }
            }
            if (numberOfPerson == 0)
                System.out.println("No person was found");
        }
    }

    /**
     * This is the main method.
     *
     * @param args
     */
    public static void main(String args[]) {
        AddressBookManagement aBookManager = new AddressBookManagement();
        while (true) {
            System.out.println("\n1. Add a new Address Book");
            System.out.println("\n2. Search person across all address books");
            System.out.println("\n3. Exit");
            System.out.println("\n Please Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    while (true) {
                        AddressBookMain m = new AddressBookMain();
                        System.out.println("Enter A name for address Book");
                        String name = sc.next();
                        if (aBookManager.nameToAddressBookMap.containsKey(name)) {
                            System.out.println("\nAddress Book already exists !!!\n");
                            continue;
                        } else {
                            aBookManager.nameToAddressBookMap.put(name, m);
                            System.out.println("\n In Address Book : " + name);
                            m.maintainAddressBook();
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter city or state to search a person");
                    String searchIn = sc.next();
                    aBookManager.searchPersonInBook(searchIn);
                    break;

                case 3:
                    break;
            }
        }
    }
}