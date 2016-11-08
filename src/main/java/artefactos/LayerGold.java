/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import static gui.Map.COLUMNS;
import static gui.Map.LINES;

/**
 *
 * @author UserPL022Pc11
 */
public class LayerGold extends MapLayer {

    private final int GOLD = 20;

    public LayerGold() {
        generateGold();
    }

    public void generateGold() {
        for (int i = 0; i < GOLD; i++) {
            this.objectos[_rand.nextInt(COLUMNS)][_rand.nextInt(LINES)] = new Gold(); 
        }
    }
}
