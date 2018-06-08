package de.dik.WerkzeugkastenFX.gui.produkte;

import com.jfoenix.controls.JFXButton;
import de.dik.WerkzeugkastenFX.gui.wkKlassen.IstSoll;
import de.dik.WerkzeugkastenFX.gui.wkKlassen.wkButton2;
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

    private wkButton2[][] wkButtonGrid = new wkButton2[6][5];

    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        //Im übergeordnetem AnchorPane positionieren
        AnchorPane.setTopAnchor(produkteSP, 0.0);
        AnchorPane.setLeftAnchor(produkteSP, 0.0);
        AnchorPane.setRightAnchor(produkteSP, 0.0);
        AnchorPane.setBottomAnchor(produkteSP, 0.0);

        JFXButton jfxButtonForComparisson = new JFXButton();
        int row = 0;
        int column = 0;
        for (Iterator it = produkteGP.getChildrenUnmodifiable().iterator(); it.hasNext();) {
            Node nextNode = (Node) it.next();
            if (nextNode.getClass().isInstance(jfxButtonForComparisson) == true) {
                JFXButton nextButton = new JFXButton();
                nextButton = (JFXButton) nextNode;
                wkButtonGrid[row][column] = new wkButton2(nextButton, row, column, IstSoll.NEUTRAL);
                //Spalten dann Zeilen hochzählen. Von Spalten 0-4(1-5)
                column++;
                if (column > 4) {
                    row++;
                    column = 0;
                }
            }
        }
    }

    @FXML
    public void btClick(ActionEvent event) {
        System.out.println("de.dik.WerkzeugkastenFX.gui.produkte.ProduktePresenter.bt11Click()");
        JFXButton button = (JFXButton) event.getSource();

        //TODO: Case nur ein grün und rot pro Zeile
        
        //WkButton anhand von button finden.
        //Damit die Eigenschaften von WkButton geändert werden können.
        //Und damit die Farbe von JFXButton geändert werden kann.        
        for (int row = 0; row < wkButtonGrid.length; row++) {
            wkButton2[] wkButtonsRow = wkButtonGrid[row];
            for (int column = 0; column < wkButtonsRow.length; column++) {
                JFXButton wkButton = wkButtonsRow[column].getButton();
                if (wkButton.equals(button)) {
                    //Wenn Button gefunden IstSoll setzen
                    //IstSoll ändern vom geklickted Button
                    //wenn Button neutral und Toggle rot -> rot
                    switch (wkButtonsRow[column].getIstSoll()) {
                        case NEUTRAL:
                            //ist
                            wkButtonsRow[column].setIstSoll(IstSoll.IST);
                            //Farbe rot
                            button.setStyle("-fx-background-color: rgba(255, 0, 0, 0.5);");
                            //wenn Button rot und Toggle grün -> rot und grün   
                            break;
                        case IST:
                            //ist und soll
                            wkButtonsRow[column].setIstSoll(IstSoll.ISTundSOLL);
                            //Farbe grün
                            button.setStyle("-fx-background-color: linear-gradient(from 40% 40% to 60% 60%, #ff0000, #558c5a); -fx-opacity: 0.5");
                            //wenn Button gradient und Toggle grün -> grün
                            break;
                        case ISTundSOLL:
                            //soll
                            wkButtonsRow[column].setIstSoll(IstSoll.SOLL);
                            //Farbe grün
                            button.setStyle("-fx-background-color: rgba(85, 140, 90, 0.5);");
                            //wenn Button rot und Toggle rot -> neutral
                            break;
                        case SOLL:
                            //neutral
                            wkButtonsRow[column].setIstSoll(IstSoll.NEUTRAL);
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
}
