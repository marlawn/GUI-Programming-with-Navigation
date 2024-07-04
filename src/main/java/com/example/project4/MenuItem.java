package com.example.project4;

/**
 * Abstract superclass for all menu items
 * @author Marlon Vergara
 * @author Luis Castellanos
 */
public abstract class MenuItem {
    /** Forces all subclasses to implement this method which returns item price */
    public abstract double itemPrice();
}