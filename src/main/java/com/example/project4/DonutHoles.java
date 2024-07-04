package com.example.project4;

/**
 * Donut holes class that extends MenuItem which is used throughout the project
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class DonutHoles extends MenuItem {
    /** Instance variable for flavor */
    private String flavor;
    /** Instance variable for quantity */
    private int quantity;

    /**
     * Constructor for donut holes object that sets the flavor
     * @param flavor flavor as a String
     */
    public DonutHoles(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Gets the price of the donut holes
     * @return double that represents the price of a donut hole
     */
    @Override
    public double itemPrice() {
        return 0.39;
    }

    /**
     * Overrides the toString() method to return the data
     * @return String representning the data
     */
    @Override
    public String toString() {
        return quantity + " " + flavor + " Donut Hole(s)";
    }
}
