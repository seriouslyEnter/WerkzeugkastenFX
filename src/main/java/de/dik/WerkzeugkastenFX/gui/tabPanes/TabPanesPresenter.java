package de.dik.WerkzeugkastenFX.gui.tabPanes;

import de.dik.WerkzeugkastenFX.gui.produkte.ProdukteView;
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

    @FXML AnchorPane startTabPaneAP;
    @FXML AnchorPane produkteTabPaneAP;
    @FXML AnchorPane tabPaneAP;

    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;

        System.out.println("tabpanes");
        
        //Notwendig weil das für Injected fxml das nicht nicht SceneBuilder gesetzt werden kann
        AnchorPane.setRightAnchor(tabPaneAP, 0.0);
        AnchorPane.setLeftAnchor(tabPaneAP, 0.0);
        AnchorPane.setTopAnchor(tabPaneAP, 0.0);
        AnchorPane.setBottomAnchor(tabPaneAP, 0.0);
        
        

        StartView startView = new StartView();
        startView.getView(startTabPaneAP.getChildren()::add);

        ProdukteView produkteView = new ProdukteView();
        produkteView.getView(produkteTabPaneAP.getChildren()::add);

    }
}
