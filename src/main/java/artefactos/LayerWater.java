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
public class LayerWater extends MapLayer {

    final int LIN = _rand.nextInt(LINES);
    int[] waterpos = new int[LINES];
    int col;

    public LayerWater() {
        super();

        generateWater();
        genWater();
    }

    public void genWater() {
        for (int i = 0; i < LINES; i++) {
            this.objectos[waterpos[i]][i] = new Water2();
            this.objectos[waterpos[i] - 1][i] = new Water2_1();
            this.objectos[waterpos[i] + 1][i] = new Water2_1();
            //this.objectos[COL+1][i] = new Water2();  
            if (LIN == i) {
                this.objectos[waterpos[i]][i] = new Bridge();
            }
        }

    }

    public void generateWater() {
        while (col < 2) {
            col = _rand.nextInt(LINES);
            if (col > 2 || col < 12) {
                for (int i = 0; i < LINES; i++) {
                    waterpos[i] = col + (_rand.nextInt(2) - 1);
                }
            }
        }
    }
}
