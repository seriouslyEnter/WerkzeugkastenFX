package de.dik.WerkzeugkastenFX.gui.tabPanes;

import com.jfoenix.controls.JFXTabPane;
import de.dik.WerkzeugkastenFX.gui.produkte.ProdukteView;
import de.dik.WerkzeugkastenFX.gui.produktion.ProduktionView;
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
    @FXML
    AnchorPane produkteTabPaneAP;
    @FXML
    AnchorPane produktionTabPaneAP;
    @FXML
    JFXTabPane tabPane;

    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;

        System.out.println("tabpanes");

        //Notwendig weil das für Injected fxml das nicht nicht SceneBuilder gesetzt werden kann
        AnchorPane.setRightAnchor(tabPane, 0.0);
        AnchorPane.setLeftAnchor(tabPane, 0.0);
        AnchorPane.setTopAnchor(tabPane, 0.0);
        AnchorPane.setBottomAnchor(tabPane, 0.0);

        StartView startView = new StartView();
        startView.getView(startTabPaneAP.getChildren()::add);

        ProdukteView produkteView = new ProdukteView();
        produkteView.getView(produkteTabPaneAP.getChildren()::add);

        ProduktionView produktionView = new ProduktionView();
        produktionView.getView(produktionTabPaneAP.getChildren()::add);

    }
}
