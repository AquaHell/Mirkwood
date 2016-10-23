/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.artifacts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import gui.Map;
import gui.SymbolsMirk;

/**
 *
 * @author davidsanguinetti
 */
public class Water extends MapObject {

    public enum WaterType {
        DEEP,
        SHORE,
        NEAR_SHORE
    }

    public Water(TerminalPosition pos, WaterType type) {
        super(pos, false, true);
        char symbolWater = 'w';
        switch (type) {
            case DEEP:
                setSymbol(SymbolsMirk.WATER[2]);
                setBackgroundColor(new TextColor.RGB(30, 150, 200));
                break;
            case SHORE: {
                setSymbol(SymbolsMirk.WATER[1]);
                setBackgroundColor(Map.bkgColor);
                break;
            }
            case NEAR_SHORE: {
                setSymbol(SymbolsMirk.WATER[0]);
                setBackgroundColor(Map.bkgColor);
                break;
            }
        }
        setForegroundColor(new TextColor.RGB(30, 150, 200));
        
    }

}
