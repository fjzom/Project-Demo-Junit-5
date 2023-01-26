package com.example.test.inventory;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.inventory.Inventory;

public class InventoryTest {
    Inventory inventory = new Inventory();

    @Test
    public void addItemTest() {
        inventory.addItem("item1", 10);
        assertEquals(10, inventory.getQuantity("item1"));
    }

    @Test
    public void removeItemTest() {
        inventory.addItem("item1", 10);
        inventory.removeItem("item1", 5);
        assertEquals(5, inventory.getQuantity("item1"));
    }

    @Test
    public void removeItemErrorTest() {
        inventory.addItem("item1", 10);
        inventory.removeItem("item1", 15);
        assertEquals(10, inventory.getQuantity("item1"));
    }

    @Test
    public void getQuantityTest() {
        inventory.addItem("item1", 10);
        assertEquals(10, inventory.getQuantity("item1"));
    }

    @Test
    public void getQuantityErrorTest() {
        assertEquals(0, inventory.getQuantity("item1"));
    }
    
    @ParameterizedTest
    @CsvSource({
        "item1, 10, 10",
        "item2, 20, 20",
        "item3, 30, 30"
    })
    void addItemTest(String itemName, int quantity, int expected) {
        Inventory inventory = new Inventory();
        inventory.addItem(itemName, quantity);
        assertEquals(expected, inventory.getQuantity(itemName));
    }
}