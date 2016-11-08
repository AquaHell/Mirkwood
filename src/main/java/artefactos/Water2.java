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
public class Water2 extends MapObject {
    
    
    
    public Water2() {
        super();
        
        setSymbol(SymbolsMirk.WATER[2]);
        
        setForegroundColor(new TextColor.RGB(50, 100, 255));
        setBackgroundColor(new TextColor.RGB(50, 100, 255));
        setWalkthrough(false);
    }
    
}
