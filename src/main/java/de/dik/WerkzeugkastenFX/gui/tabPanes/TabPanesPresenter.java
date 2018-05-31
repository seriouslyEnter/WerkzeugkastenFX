package de.dik.WerkzeugkastenFX.gui.tabPanes;

import de.dik.WerkzeugkastenFX.gui.start.StartView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * @author gu35nxt
 */
public class TabPanesPresenter implements Initializable {

    @FXML
    AnchorPane startTabPaneAP;
    
    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;

        System.out.println("tabpanes");
        
        StartView startView = new StartView();
        startView.getView(startTabPaneAP.getChildren()::add); 
    }
    
    
    
    
    
}
