/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;


import gui.Map;
import java.util.Random;

/**
 *
 * @author Trainerpl022
 */
public class MapLayer {
    MapObject[][] objectos;
    Random _rand;
    
    public MapLayer() {
        objectos = new MapObject[Map.COLUMNS][Map.LINES];
        _rand = new Random();
    }

    public MapObject[][] getMap() {
        return objectos;
    }

    public void setObjectos(MapObject[][] objectos) {
        this.objectos = objectos;
    }
}
