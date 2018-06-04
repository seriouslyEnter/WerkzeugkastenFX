/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dik.WerkzeugkastenFX.gui.produkte;


import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

/**
 *
 * @author gu35nxt
 */
public class ProduktePresenter implements Initializable {

    @FXML ScrollPane produkteSP;

    @FXML
    private JFXButton bt11;
    @FXML
    private JFXButton bt12;
    @FXML
    private JFXButton bt13;
    @FXML
    private JFXButton bt14;
    @FXML
    private JFXButton bt15;
    @FXML
    private JFXButton bt21;
    @FXML
    private JFXButton bt22;
    @FXML
    private JFXButton bt23;
    @FXML
    private JFXButton bt24;
    @FXML
    private JFXButton bt25;
    @FXML
    private JFXButton bt31;
    @FXML
    private JFXButton bt32;
    @FXML
    private JFXButton bt33;
    @FXML
    private JFXButton bt34;
    @FXML
    private JFXButton bt35;
    @FXML
    private JFXButton bt41;
    @FXML
    private JFXButton bt42;
    @FXML
    private JFXButton bt43;
    @FXML
    private JFXButton bt44;
    @FXML
    private JFXButton bt45;
    @FXML
    private JFXButton bt51;
    @FXML
    private JFXButton bt52;
    @FXML
    private JFXButton bt53;
    @FXML
    private JFXButton bt54;
    @FXML
    private JFXButton bt55;
    @FXML
    private JFXButton bt61;
    @FXML
    private JFXButton bt62;
    @FXML
    private JFXButton bt63;
    @FXML
    private JFXButton bt64;
    @FXML
    private JFXButton bt65;

    
    
    
    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        AnchorPane.setTopAnchor(produkteSP, 0.0);
        AnchorPane.setLeftAnchor(produkteSP, 0.0);
        AnchorPane.setRightAnchor(produkteSP, 0.0);
        AnchorPane.setBottomAnchor(produkteSP, 0.0);
        
        
        
        
        
        
    }

    @FXML
    public void btClick(ActionEvent event) {
        System.out.println("de.dik.WerkzeugkastenFX.gui.produkte.ProduktePresenter.bt11Click()");
        
        //Farbe ändern
        JFXButton button = (JFXButton) event.getSource();
        button.setStyle("-fx-background-color: rgb(255, 0, 0, 0.5); ");
        
        //
        System.out.println(button.getId());
        
    }

}
