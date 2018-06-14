package de.dik.WerkzeugkastenFX.gui.produkte;

import com.jfoenix.controls.JFXButton;
import de.dik.WerkzeugkastenFX.gui.wkKlassen.IstSoll;
import de.dik.WerkzeugkastenFX.gui.wkKlassen.WkButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ProduktePresenter implements Initializable {

    @FXML
    private ScrollPane produkteSP;
    @FXML
    private GridPane produkteGP;

    private WkButton[][] wkButtonGrid = new WkButton[6][5];
    private FontAwesomeIconView[][] validationLight = new FontAwesomeIconView[6][2];

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

        rowValidationLights();
        
        
    }

    private void rowValidationLights() {
        Integer row = 0;
        for (int i = 0; i < 6; i++) {
            row = 4 + i * 4;

            //HBox
            HBox hboxRowVal = new HBox(10d);
            hboxRowVal.setFillHeight(true);
            hboxRowVal.setAlignment(Pos.CENTER);

            //Invalid
            FontAwesomeIconView invalid = new FontAwesomeIconView(FontAwesomeIcon.CLOSE, "5em");
            invalid.setStyleClass("invalid-icon");
            invalid.setDisable(false);
            hboxRowVal.getChildren().add(invalid); //add to HBox
            validationLight[i][0] = invalid; //add to Array Position Column 1

            //Valid
            FontAwesomeIconView valid = new FontAwesomeIconView(FontAwesomeIcon.CHECK, "5em");
            valid.setStyleClass("valid-icon");
            valid.setDisable(true);
            hboxRowVal.getChildren().add(valid); //add to HBox
            validationLight[i][1] = valid; //add to Array Position Column 2

            //Add to Grid
            produkteGP.add(hboxRowVal, 7, row, 1, 3);
        }
    }

    private void validationLights() {
        Integer counterISTundSOLL = 0;
        Integer istPosition = 0;
        Integer sollPosition = 0;
        Boolean validISTundSOLL = false;
        Boolean validISTSOLL = false;
        for (int row = 0; row < 6; row++) {
            WkButton[] wkRow = wkButtonGrid[row];
            for (WkButton wkColumn : wkRow) {
                //nur ein IStundSOLL ...
                if (wkColumn.getIstSoll().equals(IstSoll.ISTundSOLL)) {
                    counterISTundSOLL++;
                }
                //oder ein grün vor rot
                if (wkColumn.getIstSoll().equals(IstSoll.IST)) {
                    istPosition = wkColumn.getColumn() + 1;
                }
                if (wkColumn.getIstSoll().equals(IstSoll.SOLL)) {
                    sollPosition = wkColumn.getColumn() + 1;
                }
            }

            //ISTundSOLL valide?
            if (counterISTundSOLL == 1) {
                validISTundSOLL = true;
            } else {
                validISTundSOLL = false;
            }
            counterISTundSOLL = 0; //reset counter pro Zeile

            //Ist Soll valide
            if (istPosition > 0 && sollPosition > 0 && istPosition < sollPosition) {
                validISTSOLL = true;
            } else {
                validISTSOLL = false;
            }
            istPosition = 0; //reset
            sollPosition = 0; //reset

            //setze die Lichter
            if (validISTSOLL == true | validISTundSOLL == true) {
                //Light valid
                validationLight[row][0].setDisable(true); //invalid
                validationLight[row][1].setDisable(false); //valid
            } else {
                validationLight[row][0].setDisable(false); //invalid
                validationLight[row][1].setDisable(true); //valid
            }

            validISTundSOLL = false; //reset
            validISTSOLL = false; //reset
        }
    }

    @FXML
    public void buttonColorChange(ActionEvent event) {
        JFXButton buttonAction = (JFXButton) event.getSource();
        JFXButton buttonInWkGrid;

        //WkButton anhand von button finden.
        //Damit die Eigenschaften von WkButton geändert werden können.
        //Und damit die Farbe von JFXButton geändert werden kann.
        for (WkButton[] wkButtonsRow : wkButtonGrid) {
            for (WkButton wkButtonAction : wkButtonsRow) {
                buttonInWkGrid = wkButtonAction.getButton();
                if (buttonInWkGrid.equals(buttonAction)) {
                    //Wenn Button gefunden IstSoll setzen
                    //IstSoll ändern vom geklickted Button
                    switch (wkButtonAction.getIstSoll()) {
                        //wenn Button neutral und Toggle rot -> rot
                        case NEUTRAL:
                            //Check ob Änderung valide? Wenn nicht, änder Farbe trotzdem aber dann wechsel automatisch weiter zu nächsten Farbe
                            if (wkButtonRowValidation(wkButtonAction, wkButtonsRow, IstSoll.IST) == true) {
                                wkButtonAction.setIstSoll(IstSoll.IST);
                                buttonAction.setStyle("-fx-background-color: rgba(255, 0, 0, 0.5);"); //Farbe rot
                            } else {
                                wkButtonAction.setIstSoll(IstSoll.IST);
                                buttonAction.setStyle("-fx-background-color: rgba(255, 0, 0, 0.5);"); //Farbe rot
                                //wechsel zur nächsten Farbe in dem diese Methode nochmal aufgerufen wird.
                                buttonColorChange(event);
                            }
                            break;
                        //wenn Button rot und Toggle grün -> rot und grün  
                        case IST:
                            //Check ob Änderung valide? Wenn nicht, änder Farbe trotzdem aber dann wechsel automatisch weiter zu nächsten Farbe
                            if (wkButtonRowValidation(wkButtonAction, wkButtonsRow, IstSoll.ISTundSOLL) == true) {
                                wkButtonAction.setIstSoll(IstSoll.ISTundSOLL);
                                buttonAction.setStyle("-fx-background-color: linear-gradient(from 40% 40% to 60% 60%, #ff0000, #558c5a); -fx-opacity: 0.5"); //gradient von rot nach grün
                            } else {
                                wkButtonAction.setIstSoll(IstSoll.ISTundSOLL);
                                buttonAction.setStyle("-fx-background-color: linear-gradient(from 40% 40% to 60% 60%, #ff0000, #558c5a); -fx-opacity: 0.5"); //gradient von rot nach grün
                                //wechsel zur nächsten Farbe in dem diese Methode nochmal aufgerufen wird.
                                buttonColorChange(event);
                            }
                            break;
                        //wenn Button gradient und Toggle grün -> grün
                        case ISTundSOLL:
                            //Check ob Änderung valide? Wenn nicht, änder Farbe trotzdem aber dann wechsel automatisch weiter zu nächsten Farbe
                            if (wkButtonRowValidation(wkButtonAction, wkButtonsRow, IstSoll.SOLL) == true) {
                                wkButtonAction.setIstSoll(IstSoll.SOLL);
                                buttonAction.setStyle("-fx-background-color: rgba(85, 140, 90, 0.5);"); //Farbe grün
                            } else {
                                wkButtonAction.setIstSoll(IstSoll.SOLL);
                                buttonAction.setStyle("-fx-background-color: rgba(85, 140, 90, 0.5);"); //Farbe grün
                                //wechsel zur nächsten Farbe in dem diese Methode nochmal aufgerufen wird.
                                buttonColorChange(event);
                            }
                            break;
                        //wenn Button rot und Toggle rot -> neutral
                        case SOLL:
                            //Check ob Änderung valide? Wenn nicht, änder Farbe trotzdem aber dann wechsel automatisch weiter zu nächsten Farbe
                            if (wkButtonRowValidation(wkButtonAction, wkButtonsRow, IstSoll.NEUTRAL) == true) {
                                wkButtonAction.setIstSoll(IstSoll.NEUTRAL);
                                buttonAction.setStyle("-fx-background-color: transparent;");
                            } else {
                                wkButtonAction.setIstSoll(IstSoll.NEUTRAL);
                                buttonAction.setStyle("-fx-background-color: transparent;");
                                //wechsel zur nächsten Farbe in dem diese Methode nochmal aufgerufen wird.
                                buttonColorChange(event);
                            }
                            break;
                        default:
                            System.out.println("Wenn hier dann Fehler");
                            break;
                    }
                }
            }
        }
        validationLights();
        System.out.println(buttonAction.getId());
    }

    private Boolean wkButtonRowValidation(WkButton wkButtonAction, WkButton[] wkButtonRow, IstSoll changeToColor) {
        Boolean changeValid = false;
        switch (changeToColor) {
            case NEUTRAL:
                //immer erlaubt
                changeValid = validateChangeToNeutral(wkButtonRow, wkButtonAction, changeValid);
                break;
            //wechsel zu ist
            case IST:
                changeValid = validateChangeToIst(wkButtonRow, wkButtonAction, changeValid);
                break;
            //wechsel zu istundsoll
            case ISTundSOLL:
                changeValid = validateChangeToIstUndSoll(wkButtonRow, wkButtonAction, changeValid);
                break;
            case SOLL:
                changeValid = validateChangeToSoll(wkButtonRow, wkButtonAction, changeValid);
                break;
            default:
                changeValid = true;
                break;
        }
        return changeValid;
    }

    private Boolean validateChangeToNeutral(WkButton[] wkButtonRow, WkButton wkButtonAction, Boolean changeValid) {
        //wechsel zu neutral immer erlaubt
        changeValid = true;
        return changeValid;
    }

    private Boolean validateChangeToIst(WkButton[] wkButtonRow, WkButton wkButtonAction, Boolean changeValid) {
        //nur ein IST und IST vor Soll und kein anderes ISTundSOLL
        Boolean keinIST = true;
        Boolean keinISTundSoll = true;
        Boolean keinSollOderIstVorSoll = true;
        for (WkButton validate : wkButtonRow) {
            if (validate.getIstSoll().equals(IstSoll.IST)) {
                keinIST = false;
            } else if (validate.getIstSoll().equals(IstSoll.ISTundSOLL)) {
                keinISTundSoll = false;
            } else if (validate.getIstSoll().equals(IstSoll.SOLL)) {
                //dann muss die Position vom ist noch vor dem Soll sein.
                if (wkButtonAction.getColumn() >= validate.getColumn()) {
                    keinSollOderIstVorSoll = false;
                }
            }
        }
        if (keinIST == true && keinISTundSoll == true && keinSollOderIstVorSoll == true) {
            changeValid = true;
        }
        return changeValid;
    }

    private Boolean validateChangeToIstUndSoll(WkButton[] wkButtonRow, WkButton wkButtonAction, Boolean changeValid) {
        //nur ein IST und IST vor Soll und kein anderes ISTundSOLL
        Boolean alleNeutralAusserDerActionButton = true;
        for (WkButton validate : wkButtonRow) {
            if (validate.getIstSoll() != IstSoll.NEUTRAL && !Objects.equals(wkButtonAction.getColumn(), validate.getColumn())) {
                alleNeutralAusserDerActionButton = false;
            }
        }
        if (alleNeutralAusserDerActionButton == true) {
            changeValid = true;
        }
        return changeValid;
    }

    private Boolean validateChangeToSoll(WkButton[] wkButtonRow, WkButton wkButtonAction, Boolean changeValid) {
        //nur ein IST und IST vor Soll und kein anderes ISTundSOLL
        Boolean keinSoll = true;
        Boolean keinISTundSollAnAndererStelle = true;
        Boolean istVorSoll = true;
        for (WkButton validate : wkButtonRow) {
            if (validate.getIstSoll().equals(IstSoll.SOLL)) {
                keinSoll = false;
            } else if (validate.getIstSoll().equals(IstSoll.ISTundSOLL) && !Objects.equals(wkButtonAction.getColumn(), validate.getColumn())) {
                keinISTundSollAnAndererStelle = false;
            } else if (validate.getIstSoll().equals(IstSoll.IST)) {
                //dann muss die Position vom ist noch vor dem Soll sein.
                if (wkButtonAction.getColumn() <= validate.getColumn()) {
                    istVorSoll = false;
                }
            }
        }
        if (keinSoll == true && keinISTundSollAnAndererStelle == true && istVorSoll == true) {
            changeValid = true;
        }
        return changeValid;
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
