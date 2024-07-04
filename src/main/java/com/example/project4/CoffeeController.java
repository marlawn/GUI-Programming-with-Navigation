package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

import java.text.DecimalFormat;

/**
 * Controller class for the Coffee view
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class CoffeeController {
    /** Initializes MainController variable */
    private MainController mainController;

    /** Gets the reference to the MainController object */
    public void setMainController (MainController controller) { mainController = controller; }

    /** Static variable for the decimal format */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /** FXML ID for coffee size choice box */
    @FXML
    private ChoiceBox coffeeSize;

    /** Populates coffee size choice box */
    @FXML
    private void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        coffeeSize.setItems(list);
    }

    /** FXML ID for french vanilla */
    @FXML
    private CheckBox frenchVanilla;

    /** FXML ID for irish cream */
    @FXML
    private CheckBox irishCream;

    /** FXML ID for caramel */
    @FXML
    private CheckBox caramel;

    /** FXML ID for mocha */
    @FXML
    private CheckBox mocha;

    /** Subtotal */
    private double subtotal = 0;

    /** FXML ID for subtotal number */
    @FXML
    private Label number;

    /** FXML ID for quantity text field */
    @FXML
    private TextField quantity;

    /**
     * Adds coffee and throws an error if something is wrong.
     */
    public void addCoffee() {
        checkForErrors();

        ArrayList<String> addIns = new ArrayList<>();
        String sz = coffeeSize.getSelectionModel().getSelectedItem().toString();
        if (frenchVanilla.isSelected()) {
            addIns.add("French Vanilla");
        }
        if (irishCream.isSelected()) {
            addIns.add("Irish Cream");
        }
        if (caramel.isSelected()) {
            addIns.add("Caramel");
        }
        if (mocha.isSelected()) {
            addIns.add("Mocha");
        }
        Coffee temp = new Coffee(sz, addIns, Integer.parseInt(quantity.getText().toString()));
        subtotal += temp.itemPrice() * Integer.parseInt(quantity.getText().toString());
        number.setText(df.format(subtotal));

        mainController.add(temp.toString());
        mainController.addPrice(subtotal);
    }

    /** Checks for errors */
    private void checkForErrors() {
        if (coffeeSize.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("SELECT SIZE!");
            alert.showAndWait();
            return;
        }
        try {
            if (quantity.getText().isEmpty() || Integer.parseInt(quantity.getText().toString()) > 5) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR!");
                alert.setHeaderText("INVALID QUANTITY!");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("INVALID QUANTITY!");
            alert.showAndWait();
        }
    }
}
