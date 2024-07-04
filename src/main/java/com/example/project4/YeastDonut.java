package com.example.project4;

/**
 * Yeast donut class used throughout the project
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class YeastDonut extends MenuItem {
    /** Instance variable representing the flavor */
    private String flavor;

    /** Instance variable representing the quantity */
    private int quantity;

    /**
     * Constructor that assigns the flavor to itself
     * @param flavor as a String
     */
    public YeastDonut(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Gets the cost of coffee
     * @return double that represents the coffee price
     */
    @Override
    public double itemPrice() {
        return 1.59;
    }

    /**
     * Overrides the toString() method to return new String
     * @return String representing data
     */
    @Override
    public String toString() {
        return quantity + " " + flavor + " Yeast Donut(s)";
    }
}
