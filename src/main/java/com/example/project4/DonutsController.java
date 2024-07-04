package com.example.project4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Controller for the Ordering Donuts view
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class DonutsController {
    /** Initializes MainController variable */
    private MainController mainController;

    /** Gets the reference to the MainController object */
    public void setMainController (MainController controller) { mainController = controller; }

    /** Instance variable for type of donut */
    private String typeOfDonut;

    /** Instance variable for flavor */
    private String flavor;

    /** FXML ID for quantity text field */
    @FXML
    private TextField quantity;

    /** Subtotal */
    private double subtotal = 0;

    /** Static variable for decimal format */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /** FXML ID for img ImageView */
    @FXML
    private ImageView img;

    /** Yeast donut image */
    Image yeast = new Image(getClass().getResourceAsStream("/Icons/yeast-donut.png"));

    /** Cake donut image */
    Image cake = new Image(getClass().getResourceAsStream("/Icons/cake-donut.jpg"));

    /** Donut holes image */
    Image holes = new Image(getClass().getResourceAsStream("/Icons/donut-holes.jpg"));

    /** FXML ID for donut list ComboBox */
    @FXML
    private ComboBox donutList;

    /** Populates the donut list ComboBox with options */
    @FXML
    private void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Yeast Donuts", "Cake Donuts", "Donut Holes");
        donutList.setItems(list);
    }

    /** FXML ID for flavors ListView */
    @FXML
    private ListView<String> flavors;

    /** Array of strings representing yeast donut flavors */
    String[] yF = {"Glazed", "Jelly", "Chocolate Frosting", "Boston Kreme", "Strawberry Frosting", "Old Fashioned"};

    /** Array of strings representing cake donut flavors */
    String[] cF = {"Vanilla Glazed", "Chocolate Glazed", "Carrot Cake"};

    /** Array of strings representing donut hole flavors */
    String[] hF = {"Vanilla", "Chocolate", "Glazed"};

    /** FXML ID for subtotal number Label */
    @FXML
    private Label number;

    /** Selects the donut and changes the image respectively */
    public void selectDonut() {
        typeOfDonut = donutList.getSelectionModel().getSelectedItem().toString();
        if (typeOfDonut.equals("Yeast Donuts")) {
            flavors.getItems().clear();
            img.setImage(yeast);
            flavors.getItems().addAll(yF);
            flavors.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    flavor = flavors.getSelectionModel().getSelectedItem();
                }
            });
        }
        if (typeOfDonut.equals("Cake Donuts")) {
            flavors.getItems().clear();
            img.setImage(cake);
            flavors.getItems().addAll(cF);
            flavors.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    flavor = flavors.getSelectionModel().getSelectedItem();
                }
            });
        }
        if (typeOfDonut.equals("Donut Holes")) {
            flavors.getItems().clear();
            img.setImage(holes);
            flavors.getItems().addAll(hF);
            flavors.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    flavor = flavors.getSelectionModel().getSelectedItem();
                }
            });
        }
    }

    /** Checks for errors */
    private void checkForErrors() {
        if (typeOfDonut == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("SELECT DONUT TYPE!");
            alert.showAndWait();
            return;
        }
        if (flavor == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("SELECT FLAVOR!");
            alert.showAndWait();
            return;
        }
        if (quantity.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("ENTER VALID AMOUNT!");
            alert.showAndWait();
            return;
        }
        try {
            Integer.parseInt(quantity.getText().toString());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setHeaderText("ENTER VALID AMOUNT!");
            alert.showAndWait();
        }
    }

    /**
     * Adds a donut and throws an error if something went wrong
     */
    public void addDonut() {
        checkForErrors();

        MenuItem temp = null;
        if (typeOfDonut.equals("Yeast Donuts")) {
            temp = new YeastDonut(flavor, Integer.parseInt(quantity.getText().toString()));
        } else if (typeOfDonut.equals("Cake Donuts")) {
            temp = new CakeDonut(flavor, Integer.parseInt(quantity.getText().toString()));
        } else if (typeOfDonut.equals("Donut Holes")) {
            temp = new DonutHoles(flavor, Integer.parseInt(quantity.getText().toString()));
        }
        subtotal += temp.itemPrice() * Integer.parseInt(quantity.getText().toString());
        number.setText(df.format(subtotal));

        mainController.add(temp.toString());
        mainController.addPrice(subtotal);
    }

}
