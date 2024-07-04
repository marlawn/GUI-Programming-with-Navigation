package com.example.project4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the Store Orders view
 * @author Marlon Vergara
 * @author Luis Castellanos
 */

public class OrdersController {
    /** Initializes MainController variable */
    private MainController mainController;

    /** Gets the reference to the MainController object */
    public void setMainController (MainController controller) { mainController = controller; }

    /** FXML ID for list ListView */
    @FXML
    private ListView<String> list;

    /** Loads the list */
    public void load() {
        list.getItems().clear();
        list.getItems().addAll(mainController.getOrdersList());
    }

    /** Cancels the current selected order */
    public void cancel() {
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                String temp = list.getSelectionModel().getSelectedItem();
                mainController.removeOrder(temp);
            }
        });
        load();
    }

    /** Saves the current order list to a orders.txt file */
    public void save() throws IOException {
        File file = new File("orders.txt");
        FileWriter writer = new FileWriter("orders.txt");
        ArrayList<String> temp = mainController.getOrdersList();
        for (int i = 0; i < temp.size(); i++) {
            writer.write(temp.get(i) + "\n");
        }
        writer.close();
    }
}
