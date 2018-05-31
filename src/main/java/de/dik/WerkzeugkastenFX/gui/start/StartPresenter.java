/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dik.WerkzeugkastenFX.gui.start;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author gu35nxt
 */
public class StartPresenter implements Initializable {

    private ResourceBundle resources = null;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        
        System.out.println("de.dik.WerkzeugkastenFX.gui.start.StartPresenter.initialize()");
    }
    
}
