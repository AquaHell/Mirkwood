/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.RGB;
import gui.Map;
import gui.SymbolsMirk;
import script.Character;

/**
 *
 * @author Trainerpl022
 */
public class Gold extends MapObject {

    public Gold() {
        super();

        setSymbol(SymbolsMirk.GOLD);

        setForegroundColor(new TextColor.RGB(204, 204, 0));
        setBackgroundColor(Map.bkgColor);
        setVisible(false);

    }

}
