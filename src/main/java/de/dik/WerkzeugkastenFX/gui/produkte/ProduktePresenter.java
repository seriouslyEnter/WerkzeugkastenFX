/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dik.WerkzeugkastenFX.gui.produkte;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
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

/**
 *
 * @author gu35nxt
 */
public class ProduktePresenter implements Initializable {

    @FXML
    private ScrollPane produkteSP;

    @FXML
    private AnchorPane produkteAP;

    @FXML
    private GridPane produkteGP;

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

    @FXML
    private JFXToggleButton IstSollTB;

    private WkButton[][] wkButtonGrid = new WkButton[6][5];

    private ResourceBundle resources = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        AnchorPane.setTopAnchor(produkteSP, 0.0);
        AnchorPane.setLeftAnchor(produkteSP, 0.0);
        AnchorPane.setRightAnchor(produkteSP, 0.0);
        AnchorPane.setBottomAnchor(produkteSP, 0.0);

        //Ist/Soll ToggleButton für den Start auf false(Ist) setzen
        //.isSelected funktioniert beim stat nicht. Es bleibt grau.
        IstSollTB.setSelected(true);
        IstSollTB.setSelected(false);

        JFXButton jfxButtonForComparisson = new JFXButton();
        int row = 0;
        int column = 0;
        for (Iterator it = produkteGP.getChildrenUnmodifiable().iterator(); it.hasNext();) {
            Node nextNode = (Node) it.next();
            if (nextNode.getClass().isInstance(jfxButtonForComparisson) == true) {
                JFXButton nextButton = new JFXButton();
                nextButton = (JFXButton) nextNode;
                wkButtonGrid[row][column] = new WkButton(nextButton, row, column, IstSoll.NEUTRAL);
//                JFXButton nextButton = (JFXButton) nextNode;
////                System.out.println("zähler: " + nextButton.getId());
//                wkButtonGrid[row][column].setButton(nextButton);
//                wkButtonGrid[row][column].setIstSoll(0);
//                wkButtonGrid[row][column].setRow(row);
//                wkButtonGrid[row][column].setRow(column);
//                //Spalten dann Zeilen hochzählen. Von Spalten 0-4(1-5)
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
            WkButton[] wkButtonsRow = wkButtonGrid[row];
            for (int column = 0; column < wkButtonsRow.length; column++) {
                JFXButton wkButton = wkButtonsRow[column].getButton();
                if (wkButton.equals(button)) {
                    
                    //TODO: Toggle Button entfernen, der ist nicht mehr nötig und stört sogar!
                    
                    
                    //Wenn Button gefunden IstSoll setzen
                    //IstSoll ändern vom geklickted Button
                    //wenn Button neutral und Toggle rot -> rot
                    if (wkButtonsRow[column].getIstSoll().equals(IstSoll.NEUTRAL)) {
                        //ist
                        wkButtonsRow[column].setIstSoll(IstSoll.IST);
                        //Farbe rot
                        button.setStyle("-fx-background-color: rgba(255, 0, 0, 0.5);");
                        //Flip ToogleButton
                        IstSollTB.setSelected(true);
                    //wenn Button rot und Toggle grün -> rot und grün   
                    } else if (wkButtonsRow[column].getIstSoll().equals(IstSoll.IST)) {
                        //ist und soll
                        wkButtonsRow[column].setIstSoll(IstSoll.ISTundSOLL);
                        //Farbe grün
                        button.setStyle("-fx-background-color: linear-gradient(from 40% 40% to 60% 60%, #ff0000, #558c5a); -fx-opacity: 0.5");
                        //dont Flip ToogleButton
//                        IstSollTB.setSelected(false);
                    //wenn Button gradient und Toggle grün -> grün
                    } else if (wkButtonsRow[column].getIstSoll().equals(IstSoll.ISTundSOLL)) {
                        //soll
                        wkButtonsRow[column].setIstSoll(IstSoll.SOLL);
                        //Farbe grün
                        button.setStyle("-fx-background-color: rgba(85, 140, 90, 0.5);");
                        //Flip ToogleButton
                        IstSollTB.setSelected(false);
                    //wenn Button rot und Toggle rot -> neutral
                    } else if (wkButtonsRow[column].getIstSoll().equals(IstSoll.SOLL)){
                        //neutral
                        wkButtonsRow[column].setIstSoll(IstSoll.NEUTRAL);
                        //Farbe rot
                        button.setStyle("-fx-background-color: transparent;");
                        //Flip ToogleButton
                        IstSollTB.setSelected(false);
                    } else {
                        System.out.println("Wenn hier dann Fehler");
                    }
                break;
                }
            }
        }
        

//        //Farbe ändern vom geklickted Button
//        if (IstSollTB.selectedProperty().getValue() != true) {
//            //rot
//            button.setStyle("-fx-background-color: rgb(255, 0, 0, 0.5); ");
//            IstSollTB.setSelected(true);
//        } else {
//            //grün
//            button.setStyle("-fx-background-color: rgb(85, 140, 90, 0.5); ");
//            IstSollTB.setSelected(false);
//        }

        System.out.println(button.getId());
    }

    @FXML
    void IstSollTBAction(ActionEvent event) {
        System.out.println("fire");
        System.out.println(IstSollTB.selectedProperty().toString());
    }
}
