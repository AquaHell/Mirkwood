/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import static gui.Map.COLUMNS;
import static gui.Map.LINES;
import script.Orc;
import script.Spider;

/**
 *
 * @author UserPL022Pc11
 */
public class LayerFoes extends MapLayer {

    private final int ORCS = 10;
    private final int SPIDERS = 10;

    public LayerFoes() {
        generateOrcs();
        generateSpiders();
    }

    public void generateOrcs() {
        for (int i = 0; i < ORCS; i++) {
            this.objectos[_rand.nextInt(COLUMNS)][_rand.nextInt(LINES)] = new Orc(); 
        }
        
        for (int i = 0; i < LINES;i++){
            if ( i%2 == 0){
                this.objectos[4][i] = new Orc();
            }
        }
        
    }
    public void generateSpiders() {
        for (int i = 0; i < SPIDERS; i++) {
            this.objectos[_rand.nextInt(COLUMNS)][_rand.nextInt(LINES)] = new Spider(); 
        }
    }
}
