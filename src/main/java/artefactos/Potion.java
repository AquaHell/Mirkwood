/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import com.googlecode.lanterna.TextColor;
import gui.Map;
import gui.SymbolsMirk;

/**
 *
 * @author UserPL022Pc11
 */ 
public class Potion extends MapObject {

    public Potion() {

        setSymbol(SymbolsMirk.POTION);

        setForegroundColor(new TextColor.RGB(255, 0, 0));
        setBackgroundColor(Map.bkgColor);
        setWalkthrough(true);
        setVisible(true);
        
    }

}
