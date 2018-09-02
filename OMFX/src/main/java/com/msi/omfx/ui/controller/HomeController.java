/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msi.omfx.ui.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import com.msi.omfx.ui.model.OperationModel;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Eng.MSI
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private VBox sideBar;
    @FXML
    private HBox filtersBar;
    @FXML
    private AnchorPane mainScreen;
    @FXML
    private JFXHamburger menuButton;
    @FXML
    private TableView<OperationModel> MorningTable;
    @FXML
    private TableColumn totalColumn;

    @FXML
    private TableColumn typeColumn;

    @FXML
    private TableColumn noColumn;

    @FXML
    private TableColumn notesColumn;

    @FXML
    private TableColumn grossWeightColumn;

    @FXML
    private TableColumn netWeightColumn;

    @FXML
    private TableColumn suppliersColumn;
    @FXML
    private TableColumn priceColumn;

    private boolean menuPressed = false;
    JFXDatePicker datePicker = new JFXDatePicker();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initMenuButton();
        initFiltersBar();

        final ObservableList<OperationModel> data = FXCollections.observableArrayList(
                new OperationModel(5, 100, 95, 5, 475, "m", "g", null),
                new OperationModel(100, 100, 95, 5, 475, "m", "g", null),
                new OperationModel(1000, 1000, 900, 5, 47500, "m", "g", null),
                new OperationModel(500, 100, 95, 5, 475, "m", "g", null),
                new OperationModel(13, 100, 95, 5, 475, "m", "g", null),
                new OperationModel(25, 100, 95, 5, 475, "m", "g", null),
                new OperationModel(30, 100, 95, 5, 475, "m", "g", null),
                new OperationModel(1, 100, 95, 5, 475, "m", "g", null),
                new OperationModel(4, 100, 95, 5, 475, "m", "g", null),
                new OperationModel(7, 100, 95, 5, 475, "m", "g", null)
        );
        noColumn.setCellValueFactory(
                new PropertyValueFactory<OperationModel, Integer>("no")
        );
        grossWeightColumn.setCellValueFactory(
                new PropertyValueFactory<OperationModel, Integer>("grossWeight")
        );
        netWeightColumn.setCellValueFactory(
                new PropertyValueFactory<OperationModel, Integer>("netWeight")
        );
        priceColumn.setCellValueFactory(
                new PropertyValueFactory<OperationModel, Integer>("price")
        );
        totalColumn.setCellValueFactory(
                new PropertyValueFactory<OperationModel, Integer>("totalPrice")
        );
        typeColumn.setCellValueFactory(
                new PropertyValueFactory<OperationModel, String>("type")
        );
        suppliersColumn.setCellValueFactory(
                new PropertyValueFactory<OperationModel, String>("supplier")
        );
        notesColumn.setCellValueFactory(
                new PropertyValueFactory<OperationModel, String>("notes")
        );
        MorningTable.setItems(data);

    }

    public void initMenuButton() {
        HamburgerBasicCloseTransition burgerTask = new HamburgerBasicCloseTransition(menuButton);
        burgerTask.setRate(-1);
        menuButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask.setRate(burgerTask.getRate() * -1);
            burgerTask.play();
            toggleSideMenu();
        });

    }

    public void initFiltersBar() {
        Locale.setDefault(Locale.forLanguageTag("ar"));
        filtersBar.getChildren().add(1, datePicker);
    }

    public void toggleSideMenu() {
        if (sideBar.getLayoutX() == 0) {

            KeyValue kv1 = new KeyValue(sideBar.layoutXProperty(), -300);
            KeyValue kv2 = new KeyValue(menuButton.layoutXProperty(), 15);
            KeyFrame kf1 = new KeyFrame(Duration.millis(250), kv1);
            KeyFrame kf2 = new KeyFrame(Duration.millis(250), kv2);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(kf1);
            timeline.getKeyFrames().add(kf2);
            timeline.play();
        } else {
            KeyValue kv1 = new KeyValue(sideBar.layoutXProperty(), 0);
            KeyValue kv2 = new KeyValue(menuButton.layoutXProperty(), 250);
            KeyFrame kf1 = new KeyFrame(Duration.millis(250), kv1);
            KeyFrame kf2 = new KeyFrame(Duration.millis(250), kv2);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(kf1);
            timeline.getKeyFrames().add(kf2);
            timeline.play();
        }
    }

    public boolean isMenuPressed() {
        return menuPressed;
    }

    public void setMenuPressed(boolean menuPressed) {
        this.menuPressed = menuPressed;
    }

}
