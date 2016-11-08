/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

import static gui.Map.TREECOUNT;
import static gui.Map.COLUMNS;
import static gui.Map.LINES;

/**
 *
 * @author Trainerpl022
 */
public class LayerTrees extends MapLayer {

    public LayerTrees() {
        super();

        generateTrees();
    }

    public void generateTrees() {

        for (int i = 0; i < TREECOUNT; i++) {
            this.objectos[_rand.nextInt(COLUMNS)][_rand.nextInt(LINES)] = new Tree2();
        }

    }
}
