package com.example.project4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Coffee class that extends MenuItem which is used throughout the project.
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class Coffee extends MenuItem {
    /** Price for short sizes */
    private static double SHORT_PRICE = 1.89;
    /** Price for tall sizes */
    private static double TALL_PRICE = 2.29;
    /** Price for grande sizes */
    private static double GRANDE_PRICE = 2.69;
    /** Price for venti sizes */
    private static double VENTI_PRICE = 3.09;
    /** Price for add-ins */
    private static double ADD_IN_PRICE = 0.30;
    /** Instance variable for cup size */
    private String cupSize;
    /** Instance variable for list of add-ins */
    private ArrayList<String> addIns = new ArrayList<>();
    /** Instance variable for quantity */
    private int quantity;

    /**
     * Constructor of coffee that takes in cup size and add-ins
     * @param cupSize size of cup as a String
     * @param addIns list of add-ins as an ArrayList
     */
    public Coffee(String cupSize, ArrayList addIns, int quantity) {
        this.cupSize = cupSize;
        this.addIns = addIns;
        this.quantity = quantity;
    }

    /**
     * Gets the cost of coffee
     * @return double that represents the coffee price
     */
    @Override
    public double itemPrice() {
        if (cupSize.equals("Short")) {
            return SHORT_PRICE + (ADD_IN_PRICE * addIns.size());
        } else if (cupSize.equals("Tall")) {
            return TALL_PRICE + (ADD_IN_PRICE * addIns.size());
        } else if (cupSize.equals("Grande")) {
            return GRANDE_PRICE + (ADD_IN_PRICE * addIns.size());
        }
        return VENTI_PRICE + (ADD_IN_PRICE * addIns.size());
    }

    /**
     * Overrides the toString() method to return the data
     * @return String representing the data
     */
    @Override
    public String toString() {
        if (addIns.isEmpty()) return quantity + " " + cupSize + " Black Coffee(s)";
        return quantity + " " + cupSize + " Black Coffee(s) with the Add-Ins: " + addIns.toString();
    }
}
