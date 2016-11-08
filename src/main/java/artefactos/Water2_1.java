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


/**
 *
 * @author Trainerpl022
 */
public class Water2_1 extends MapObject {
    
    
    
    public Water2_1() {
        super();
        
        setSymbol(SymbolsMirk.WATER[1]);
        
        setForegroundColor(new TextColor.RGB(50, 100, 255));
        setBackgroundColor(Map.bkgColor);
        setWalkthrough(true);
    }
    
}
