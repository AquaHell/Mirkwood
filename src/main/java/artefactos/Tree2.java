/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import com.googlecode.lanterna.TextColor;
import gui.Map;
import gui.SymbolsMirk;
import java.util.Random;

/**
 *
 * @author Trainerpl022
 */
public class Tree2 extends MapObject {

    Random green = new Random();
    


    
    public Tree2() {
        super();
        setSymbol(SymbolsMirk.TREES[_rand.nextInt(SymbolsMirk.TREES.length)]);
        setForegroundColor(new TextColor.RGB(0, green.nextInt(156)+100, 0));
        setBackgroundColor(Map.bkgColor);
    }
    
}
