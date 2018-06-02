package de.dik.WerkzeugkastenFX.gui.userWindow;

import de.dik.WerkzeugkastenFX.gui.start.StartView;
import de.dik.WerkzeugkastenFX.gui.tabPanes.TabPanesView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * @author gu35nxt
 */
public class UserWindowPresenter implements Initializable {

    @FXML
    AnchorPane userWindowAP;

    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;

        System.out.println("userwindow");

        TabPanesView tabPanes = new TabPanesView();
        tabPanes.getView(userWindowAP.getChildren()::add);     

//        StartView startView = new StartView();
//        startView.getView(userWindowAP.getChildren()::add);
    }
}
