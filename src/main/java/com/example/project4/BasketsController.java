package com.example.project4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.text.DecimalFormat;

/**
 * Controller for the Ordering Basket view
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class BasketsController {
    /** Initializes MainController variable */
    private MainController mainController;

    /** Gets the reference to the MainController object */
    public void setMainController (MainController controller) { mainController = controller; }

    /** Static variable for DecimalFormat */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /** Static variable for sales tax */
    private static double SALES_TAX = 0.06625;

    /** FXML ID for visibleList ListView */
    @FXML
    private ListView visibleList;

    /** FXML ID for subtotal Label */
    @FXML
    private Label subtotal;

    /** FXML ID for tax Label */
    @FXML
    private Label tax;

    /** FXML ID for total Label */
    @FXML
    private Label total;

    /** Loads the visibleList */
    @FXML
    public void load(){
        visibleList.getItems().clear();
        visibleList.getItems().addAll(mainController.getList());
        subtotal.setText(df.format(mainController.getSubtotal()));
        double temp = mainController.getSubtotal() * SALES_TAX;
        double res = mainController.getSubtotal() + temp;
        tax.setText(df.format(temp));
        total.setText(df.format(res));
        mainController.setCurrentPrice(res);
    }

    /** Removes the selected item */
    @FXML
    public void remove() {
        visibleList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                String temp = visibleList.getSelectionModel().getSelectedItem().toString();
                mainController.remove(temp);
            }
        });
        load();
    }

    /** Places order */
    public void placeOrder() {
        mainController.placeOrder();
        visibleList.getItems().clear();
        subtotal.setText("0.00");
        tax.setText("0.00");
        total.setText("0.00");
    }
}