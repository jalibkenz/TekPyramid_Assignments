package Assn_2025_11_15.service;

import Assn_2025_11_15.exception.DuplicateEntryException;
import Assn_2025_11_15.exception.ResourceNotFoundException;
import Assn_2025_11_15.model.MenuItem;
import java.util.ArrayList;

public class MenuService {
    private ArrayList<MenuItem> menuList = new ArrayList<>();

    public void addMenuItem(MenuItem item) throws DuplicateEntryException {
        for (MenuItem m : menuList) {
            if (m.getId() == item.getId()) {
                throw new DuplicateEntryException("Menu Item ID " + item.getId() + " already exists!");
            }
        }
        menuList.add(item);
        System.out.println("✅ Menu item added successfully!");
    }

    public void viewMenuItems() {
        if (menuList.isEmpty()) {
            System.out.println("No menu items available!");
            return;
        }
        System.out.println("\n--- MENU ITEMS ---");
        for (MenuItem item : menuList) {
            System.out.println(item);
        }
    }

    public void updateMenuItem(int id, String name, double price, String category)
            throws ResourceNotFoundException {
        for (MenuItem item : menuList) {
            if (item.getId() == id) {
                item.setName(name);
                item.setPrice(price);
                item.setCategory(category);
                System.out.println("Menu item updated successfully!");
                return;
            }
        }
        throw new ResourceNotFoundException("Menu item with ID " + id + " not found!");
    }

    public void deleteMenuItem(int id) throws ResourceNotFoundException {
        for (MenuItem item : menuList) {
            if (item.getId() == id) {
                menuList.remove(item);
                System.out.println("Menu item deleted successfully!");
                return;
            }
        }
        throw new ResourceNotFoundException("Menu item with ID " + id + " not found!");
    }



}
