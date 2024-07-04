package com.example.project4;

import java.util.ArrayList;

/**
 * Order class which holds all the items in the order and is identified with its own unique order number
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class Order {
    /** Instance variable for order number */
    private int orderNumber;

    /** Instance variable for menu items */
    private ArrayList<MenuItem> menuItems;

    /** Static variable for counters to count order number */
    private static int counter = 1;

    /**
     * Constructor which takes in menu items ArrayList and assigns it to this one
     * @param menuItems ArrayList of MenuItem's
     */
    public Order(ArrayList menuItems) {
        this.orderNumber = counter;
        this.menuItems = menuItems;
        counter++;
    }

    /**
     * Converts the data to a string
     * @return String representing the data
     */
    @Override
    public String toString() {
        return orderNumber + ": " + menuItems.toString();
    }
}
