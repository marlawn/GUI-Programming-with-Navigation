package com.example.project4;

/**
 * Cake donut class which extends MenuItem used throughout the project
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public class CakeDonut extends MenuItem {
    /** Instance variable representing flavor */
    private String flavor;
    /** Instance variable representing quantity */
    private int quantity;

    /**
     * Constructor that takes in flavor and quantity
     * @param flavor String representing flavor
     * @param quantity integer representing quantity
     */
    public CakeDonut(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Returns the item price
     * @return double representing the item price
     */
    @Override
    public double itemPrice() {
        return 1.79;
    }

    /**
     * Returns string representing the data
     * @return String representing the data
     */
    @Override
    public String toString() {
        return quantity + " " + flavor + " Cake Donut(s)";
    }
}
