/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dik.WerkzeugkastenFX.gui.produkte;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author gu35nxt
 */
public class ProduktePresenter implements Initializable {

    @FXML ScrollPane produkteSP;
    @FXML Button bt11;


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
    public void bt11Click(ActionEvent event) {
        System.out.println("de.dik.WerkzeugkastenFX.gui.produkte.ProduktePresenter.bt11Click()");
    }

}
