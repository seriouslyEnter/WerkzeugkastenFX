/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dik.WerkzeugkastenFX.gui.wkKlassen;

import com.jfoenix.controls.JFXButton;
import java.util.Objects;

/**
 *
 * @author gu35nxt
 */
public class WkButton {
    private JFXButton button;
    private Integer row;    //1-6
    private Integer column; //1-5
    private Integer istSoll; // 0(not selected) 0(ist) 1(soll)
    
    public WkButton(JFXButton button, Integer row, Integer column, Integer istSoll) {
        this.button = button;
        this.row = row;
        this.column = column;
        this.istSoll = istSoll;
    }

    public JFXButton getButton() {
        return button;
    }

    public void setButton(JFXButton button) {
        this.button = button;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getIstSoll() {
        return istSoll;
    }

    public void setIstSoll(Integer istSoll) {
        this.istSoll = istSoll;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.button);
        hash = 71 * hash + Objects.hashCode(this.row);
        hash = 71 * hash + Objects.hashCode(this.column);
        hash = 71 * hash + Objects.hashCode(this.istSoll);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WkButton other = (WkButton) obj;
        if (!Objects.equals(this.button, other.button)) {
            return false;
        }
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.column, other.column)) {
            return false;
        }
        if (!Objects.equals(this.istSoll, other.istSoll)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WkButton{" + "button=" + button + ", row=" + row + ", column=" + column + ", istSoll=" + istSoll + '}';
    }
    


}











