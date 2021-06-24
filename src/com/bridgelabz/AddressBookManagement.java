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

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AddressBookManagement {
    static Scanner sc = new Scanner(System.in);
    public static Map<String, AddressBookMain> nameToAddressBookMap = new TreeMap<>();

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
     * This is the main method.
     *
     * @param args
     */
    public static void main(String args[]) {
        AddressBookManagement aBookManager = new AddressBookManagement();
        System.out.println("Enter 1 to add a new BOOK");
        int choice = sc.nextInt();
        if (choice == 1)
            aBookManager.addNewAddressBook();
        else
            System.out.println("Invalid choice");
    }
}
