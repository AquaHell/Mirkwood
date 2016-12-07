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
 * @author UserPL022Pc11
 */
public class Biome extends MapObject {

    public enum BiomeType {
        BIOME1,
        BIOME2,
        BIOME3,
        BIOME4,
        BIOME5
    }

    public Biome(TerminalPosition pos, BiomeType type) {
        super(pos, true, true);

        switch (type) {
            case BIOME1:
                setBackgroundColor(new TextColor.RGB(30, 150, 200)); //Ocean
                break;
            case BIOME2: {
                setBackgroundColor(new TextColor.RGB(51, 204, 51)); //Jungle
                break;
            }
            case BIOME3: {
                setBackgroundColor(new TextColor.RGB(204, 0, 0)); //Lava
                break;
            }
            case BIOME4: {
                setBackgroundColor(new TextColor.RGB(204, 204, 0)); //Desert
                break;
            }
            case BIOME5: {
                setBackgroundColor(new TextColor.RGB(128, 128, 128)); //None
                break;
            }
        }
        setForegroundColor(new TextColor.RGB(30, 150, 200));
    }

}
