package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Main controller which is used to switch views
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class MainController {
    /** Decimal format static variable */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /** Temporary array list */
    ArrayList<String> temp = new ArrayList<>();

    /** Double signifying the subtotal */
    private double subtotal = 0.00;

    /** Double signifying total with tax */
    private double currentPrice = 0.00;

    /** ArrayList representing the orders */
    ArrayList<String> ordersList = new ArrayList<>();

    /** Changes views when you click the donut icon */
    @FXML
    protected void onDonutsButtonClick(){
        Stage stage = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("donuts-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Order Donuts");
            stage.show();
            DonutsController donutcontroller = loader.getController();
            donutcontroller.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Loading donuts-view.fxml failed!");
            alert.showAndWait();
        }
    }

    /** Changes views when you click the coffee icon */
    @FXML
    public void onCoffeeButtonClick() {
        Stage stage = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("coffee-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Order Coffee");
            stage.show();
            CoffeeController coffeecontroller = loader.getController();
            coffeecontroller.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Loading coffee-view.fxml failed!");
            alert.showAndWait();
        }
    }

    /** Changes views when you click the basket icon */
    @FXML
    public void onBasketButtonClick() {
        Stage stage = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("baskets-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Ordering Basket");
            stage.show();
            BasketsController basketscontroller = loader.getController();
            basketscontroller.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Loading baskets-view.fxml failed!");
            alert.showAndWait();
        }
    }

    /** Changes views when you click the eye icon */
    @FXML
    public void onOrdersButtonClick() {
        Stage stage = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orders-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Store Orders");
            stage.show();
            OrdersController orderscontroller = loader.getController();
            orderscontroller.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Loading orders-view.fxml failed!");
            alert.showAndWait();
        }
    }

    /**
     * Adds the price to the subtotal
     * @param d double to set the subtotal to
     */
    public void addPrice(double d) {
        subtotal = d;
    }

    /**
     * Returns the subtotal
     * @return double representing subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Adds s to temp ArrayList
     * @param s String to be added
     */
    public void add(String s) {
        temp.add(s);
    }

    /**
     * Removes s from temp ArrayList
     * @param s String to be removed
     */
    public void remove(String s) {
        temp.remove(s);
    }

    /**
     * Returns the list
     * @return ArrayList temp
     */
    public ArrayList<String> getList() {
        return temp;
    }

    /**
     * Sets the current price to d
     * @param d double to set current price to
     */
    public void setCurrentPrice(double d) {
        currentPrice = d;
    }

    /**
     * Places order
     */
    public void placeOrder() {
        Order o = new Order(temp);
        ordersList.add(o.toString() + " $" + df.format(currentPrice));
        temp.clear();
        subtotal = 0.00;
        currentPrice = 0.00;
    }

    /**
     * Returns orders list ArrayList
     * @return ArrayList containing all the orders
     */
    public ArrayList<String> getOrdersList() {
        return ordersList;
    }

    /**
     * Removes orders from orders list ArrayList
     * @param s ArrayList containing all the orders to be removed
     */
    public void removeOrder(String s) {
        ordersList.remove(s);
    }

}