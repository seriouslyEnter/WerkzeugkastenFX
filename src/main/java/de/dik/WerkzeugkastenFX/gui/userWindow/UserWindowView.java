/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dik.WerkzeugkastenFX.gui.userWindow;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author gu35nxt
 */
public class UserWindowView extends FXMLView {
    
    public UserWindowPresenter getRealPresenter() {
        return (UserWindowPresenter) super.getPresenter();
    }
    
}
