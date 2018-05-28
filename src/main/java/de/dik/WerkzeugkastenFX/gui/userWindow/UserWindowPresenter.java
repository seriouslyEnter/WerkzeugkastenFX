/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dik.WerkzeugkastenFX.gui.userWindow;

import de.dik.WerkzeugkastenFX.gui.tabPanes.TabPanesView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author gu35nxt
 */
public class UserWindowPresenter implements Initializable {
    
    @FXML
    AnchorPane userWindowAP;

    private ResourceBundle resources = null;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        
        
                TabPanesView tabPanes = new TabPanesView();
        tabPanes.getViewAsync(userWindowAP.getChildren()::add);
    }
    
}