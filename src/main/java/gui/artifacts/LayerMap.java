/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.artifacts;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import gui.Map;
import static gui.Map.COLUMNS;
import static gui.Map.LINES;

/**
 *
 * @author UserPL022Pc11
 */
public class LayerMap extends MapLayer {
    
    public LayerMap() {
        generateBiome();
    }

    public void generateBiome() {
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < LINES; i++) {
                if (i < 124 && j < 124) {
                    TerminalPosition ocepos = new TerminalPosition(i, j);
                    addObject(new Biome(ocepos, Biome.BiomeType.BIOME1)); 
                } else if (i > 131 && j > 131 && i < 256 && j < 256) {
                    TerminalPosition junpos = new TerminalPosition(i, j);
                    addObject(new Biome(junpos, Biome.BiomeType.BIOME2));
                } else if (j > 131 && j < 256 && i < 125) {
                    TerminalPosition lavpos = new TerminalPosition(i, j);
                    addObject(new Biome(lavpos, Biome.BiomeType.BIOME3));
                } else if (i > 131 && i < 256 && j < 125) {
                    TerminalPosition despos = new TerminalPosition(i, j);
                    addObject(new Biome(despos, Biome.BiomeType.BIOME4));
                } else if (i < 125 && j < 125) {
                    TerminalPosition nonpos = new TerminalPosition(i, j);
                    addObject(new Biome(nonpos, Biome.BiomeType.BIOME5));
                }
            }
        }
    }

}
