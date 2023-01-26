package com.example.inventory;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> items;

    public Inventory() {
        items = new HashMap<String, Integer>();
    }

    public void addItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            int currentQuantity = items.get(itemName);
            items.put(itemName, currentQuantity + quantity);
        } else {
            items.put(itemName, quantity);
        }
    }

    public void removeItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            int currentQuantity = items.get(itemName);
            if (currentQuantity - quantity < 0) {
                System.out.println("Error: Not enough items in stock.");
            } else {
                items.put(itemName, currentQuantity - quantity);
            }
        } else {
            System.out.println("Error: Item not found.");
        }
    }

    public int getQuantity(String itemName) {
        if (items.containsKey(itemName)) {
            return items.get(itemName);
        } else {
            return 0;
        }
    }
}