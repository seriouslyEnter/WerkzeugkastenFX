package de.dik.WerkzeugkastenFX.gui.produkte;

import com.jfoenix.controls.JFXButton;
import de.dik.WerkzeugkastenFX.gui.wkKlassen.IstSoll;
import de.dik.WerkzeugkastenFX.gui.wkKlassen.WkButton;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ProduktePresenter implements Initializable {

    @FXML
    private ScrollPane produkteSP;
    @FXML
    private GridPane produkteGP;

    private WkButton[][] wkButtonGrid = new WkButton[6][5];

    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        //Im übergeordnetem AnchorPane positionieren
        AnchorPane.setTopAnchor(produkteSP, 0.0);
        AnchorPane.setLeftAnchor(produkteSP, 0.0);
        AnchorPane.setRightAnchor(produkteSP, 0.0);
        AnchorPane.setBottomAnchor(produkteSP, 0.0);

        buttonInWkButtonsEinlesen();
    }

    @FXML
    public void btChangeIstSoll(ActionEvent event) {
        JFXButton button = (JFXButton) event.getSource();

        //TODO: Case nur ein grün und rot pro Zeile
        //WkButton anhand von button finden.
        //Damit die Eigenschaften von WkButton geändert werden können.
        //Und damit die Farbe von JFXButton geändert werden kann.
        for (WkButton[] wkButtonsRow : wkButtonGrid) {
            for (WkButton wkButton : wkButtonsRow) {
                JFXButton jfxButton = wkButton.getButton();
                if (jfxButton.equals(button)) {
                    //Wenn Button gefunden IstSoll setzen
                    //IstSoll ändern vom geklickted Button
                    //wenn Button neutral und Toggle rot -> rot
                    switch (wkButton.getIstSoll()) {
                        case NEUTRAL:
                            //ist
                            wkButton.setIstSoll(IstSoll.IST);
                            //Farbe rot
                            button.setStyle("-fx-background-color: rgba(255, 0, 0, 0.5);");
                            //wenn Button rot und Toggle grün -> rot und grün   
                            break;
                        case IST:
                            //ist und soll
                            wkButton.setIstSoll(IstSoll.ISTundSOLL);
                            //Farbe grün
                            button.setStyle("-fx-background-color: linear-gradient(from 40% 40% to 60% 60%, #ff0000, #558c5a); -fx-opacity: 0.5");
                            //wenn Button gradient und Toggle grün -> grün
                            break;
                        case ISTundSOLL:
                            //soll
                            wkButton.setIstSoll(IstSoll.SOLL);
                            //Farbe grün
                            button.setStyle("-fx-background-color: rgba(85, 140, 90, 0.5);");
                            //wenn Button rot und Toggle rot -> neutral
                            break;
                        case SOLL:
                            //neutral
                            wkButton.setIstSoll(IstSoll.NEUTRAL);
                            //Farbe rot
                            button.setStyle("-fx-background-color: transparent;");
                            break;
                        default:
                            System.out.println("Wenn hier dann Fehler");
                            break;
                    }
                }
            }
        }
        System.out.println(button.getId());
    }

    private void buttonInWkButtonsEinlesen() {
        JFXButton jfxButtonForComparisson = new JFXButton();
        int row = 0;
        int column = 0;
        for (Node nextNode : produkteGP.getChildrenUnmodifiable()) {
            if (nextNode.getClass().isInstance(jfxButtonForComparisson) == true) {
                JFXButton nextButton = new JFXButton();
                nextButton = (JFXButton) nextNode;
                wkButtonGrid[row][column] = new WkButton(nextButton, row, column, IstSoll.NEUTRAL);
                //Spalten dann Zeilen hochzählen. Von Spalten 0-4(1-5)
                column++;
                if (column > 4) {
                    row++;
                    column = 0;
                }
            }
        }
    }
}
