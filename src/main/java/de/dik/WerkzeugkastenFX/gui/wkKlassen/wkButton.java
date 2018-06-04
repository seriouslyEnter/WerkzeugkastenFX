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
public class wkButton {
    private JFXButton button;
    private Integer row;    //1-6
    private Integer column; //1-5
    private Boolean ist;
    private Boolean soll;
    
    
        public wkButton(JFXButton button, Integer row, Integer column, Boolean ist, Boolean soll) {
        this.button = button;
        this.row = row;
        this.column = column;
        this.ist = ist;
        this.soll = soll;
    }

    public Boolean getSoll() {
        return soll;
    }

    public void setSoll(Boolean soll) {
        this.soll = soll;
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

    public Boolean getIst() {
        return ist;
    }

    public void setIst(Boolean ist) {
        this.ist = ist;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.button);
        hash = 59 * hash + Objects.hashCode(this.row);
        hash = 59 * hash + Objects.hashCode(this.column);
        hash = 59 * hash + Objects.hashCode(this.ist);
        hash = 59 * hash + Objects.hashCode(this.soll);
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
        final wkButton other = (wkButton) obj;
        if (!Objects.equals(this.button, other.button)) {
            return false;
        }
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.column, other.column)) {
            return false;
        }
        if (!Objects.equals(this.ist, other.ist)) {
            return false;
        }
        if (!Objects.equals(this.soll, other.soll)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wkButton{" + "button=" + button + ", row=" + row + ", column=" + column + ", ist=" + ist + ", soll=" + soll + '}';
    }
        
        
        
        
        
        
        
        
        
        
}
