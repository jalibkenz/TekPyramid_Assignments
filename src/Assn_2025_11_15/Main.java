import Assn_2025_11_15.exception.DuplicateEntryException;
import Assn_2025_11_15.exception.ResourceNotFoundException;
import Assn_2025_11_15.service.CustomerService;
import Assn_2025_11_15.service.MenuService;
import Assn_2025_11_15.service.OrderService;
import Assn_2025_11_15.view.CustomerView;
import Assn_2025_11_15.view.MenuItemView;
import Assn_2025_11_15.view.OrderView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DuplicateEntryException, ResourceNotFoundException {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();

        int choice;
        do {
            System.out.println("\n===== RESTAURANT MANAGEMENT APPLICATION =====");
            System.out.println("\nMAIN MENU---------------");
            System.out.println("1. Menu Item Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Order Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> MenuItemView.showMenu(sc, menuService);
                case 2 -> CustomerView.showMenu(sc, customerService);
                case 3 -> OrderView.showMenu(sc, orderService);
                case 4 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

}