/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.terminal.Terminal;
import java.util.Random;

/**
 *
 * @author Trainerpl022
 */
public class MapObject{
    char symbol;
    TextColor.RGB foregroundColor;
    TextColor.RGB backgroundColor;
    
    boolean walkthrough = true;
    boolean visible = true;
    
    double value;
    
    protected Random _rand;
    
    public MapObject() {
        _rand = new Random();
    }

    public MapObject(char symbol, TextColor.RGB foregroundColor, TextColor.RGB backgroundColor) {
        this.symbol = symbol;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public TextColor.RGB getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(TextColor.RGB foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public TextColor.RGB getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(TextColor.RGB backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isWalkthrough() {
        return walkthrough;
    }

    public void setWalkthrough(boolean walkthrough) {
        this.walkthrough = walkthrough;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }    
}
