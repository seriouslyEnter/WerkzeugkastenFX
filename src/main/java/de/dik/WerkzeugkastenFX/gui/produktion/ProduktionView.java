/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dik.WerkzeugkastenFX.gui.produktion;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author gu35nxt
 */
public class ProduktionView extends FXMLView {
    
    public ProduktionPresenter getRealPresenter() {
        return (ProduktionPresenter) super.getPresenter();
    }
    
}
