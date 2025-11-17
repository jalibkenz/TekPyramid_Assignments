package Assn_2025_11_15.view;

import Assn_2025_11_15.exception.DuplicateEntryException;
import Assn_2025_11_15.exception.MenuSelectionException;
import Assn_2025_11_15.exception.ResourceNotFoundException;
import Assn_2025_11_15.model.MenuItem;
import Assn_2025_11_15.service.MenuService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuItemView {
    public static void showMenu(Scanner sc, MenuService manager) {
        int choice = 0;
        do {
            try {
                System.out.println("\n########## MENU ITEM MANAGEMENT ##########");
                System.out.println("1. Add Menu Item");
                System.out.println("2. View All Menu Items");
                System.out.println("3. Update Menu Item");
                System.out.println("4. Delete Menu Item");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        try {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Enter Category:(Veg/Non-Veg) ");
                            String category = sc.nextLine();
                            manager.addMenuItem(new MenuItem(id, name, price, category));
                        } catch (DuplicateEntryException e) {
                            System.out.println("⚠️ " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("⚠️ Invalid input! Menu Item already exist");
                            sc.nextLine(); // clear invalid input
                        }
                    }

                    case 2 -> manager.viewMenuItems();

                    case 3 -> {
                        try {
                            System.out.print("Enter ID to update: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter new Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter new Price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Enter new Category: ");
                            String category = sc.nextLine();
                            manager.updateMenuItem(id, name, price, category);
                        } catch (ResourceNotFoundException e) {
                            System.out.println("⚠️ " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("⚠️ Invalid price input!");
                            sc.nextLine();
                        }
                    }

                    case 4 -> {
                        try {
                            System.out.print("Enter ID to delete: ");
                            int id = sc.nextInt();
                            manager.deleteMenuItem(id);
                        } catch (ResourceNotFoundException e) {
                            System.out.println("⚠️ " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("⚠️ Invalid ID input!");
                            sc.nextLine();
                        }
                    }

                    case 5 -> System.out.println("Returning to Main Menu...");

                    default -> throw new MenuSelectionException("Invalid menu selection! Please choose 1–5.");
                }

            } catch (MenuSelectionException e) {
                System.out.println("⚠️ " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Please enter a number!");
                sc.nextLine(); // clear invalid input
            }

        } while (choice != 5);
    }
}
