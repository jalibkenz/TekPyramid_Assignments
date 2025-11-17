package Assn_2025_11_15.view;

import Assn_2025_11_15.exception.DuplicateEntryException;
import Assn_2025_11_15.model.Customer;
import Assn_2025_11_15.service.CustomerService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerView {
    public static void showMenu(Scanner sc, CustomerService manager) {
        int choice;
        do {
            System.out.println("\n########## CUSTOMER MANAGEMENT ##########");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Enter Customer ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phone = sc.nextLine();
                        manager.addCustomer(new Customer(id, name, phone));
                    } catch (DuplicateEntryException e) {
                        System.out.println("⚠️ " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("⚠️ Invalid input! Customer already exist");
                        sc.nextLine(); // clear invalid input
                    }
                }
                case 2 -> manager.viewCustomers();
                case 3 -> {
                    System.out.print("Enter Customer ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new Phone Number: ");
                    String phone = sc.nextLine();
                    manager.updateCustomer(id, name, phone);
                }
                case 4 -> {
                    System.out.print("Enter Customer ID to delete: ");
                    int id = sc.nextInt();
                    manager.deleteCustomer(id);
                }
                case 5 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

}
