package gui;

import artefactos.LayerFoes;
import artefactos.LayerTrees;
import artefactos.LayerWater;
import artefactos.MapLayer;
import artefactos.MapObject;
import artefactos.Tree2;
import artefactos.Water2;
import java.util.EnumSet;
import java.util.Random;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.RGB;
import com.googlecode.lanterna.gui2.ComponentRenderer;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextGUIGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import java.util.ArrayList;

import script.Characters;
import script.Foe;
import script.Hero;
import script.Orc;

public class Map extends Panel {

    public static final int COLUMNS = 50;
    public static final int LINES = 16;

    public static final int TREECOUNT = 200;
    public static final int BRANCHESCOUNT = 250;

    Random mRand;

    int cont = 0;
    int[] playerpos = new int[]{2, 2};

    int[] waterpos = new int[LINES];
    Tree[] treespos = new Tree[TREECOUNT];
    Tree[] branchespos = new Tree[BRANCHESCOUNT];
    public static RGB bkgColor = new TextColor.RGB(165, 127, 61);
    public ArrayList<MapLayer> layers;
    Characters _chars;

    EmptySpace land;

    public Map(Characters chars) {
        super();

        _chars = chars;
        getBasePane();

        mRand = new Random();

        //generateWater();
        LayerTrees trees = new LayerTrees();
        LayerFoes foes = new LayerFoes();
        LayerWater water = new LayerWater();

        layers = new ArrayList();
        layers.add(trees);
        layers.add(foes);
        layers.add(water);

        land = new EmptySpace(new TextColor.RGB(165, 127, 61)) {
            protected ComponentRenderer<EmptySpace> createDefaultRenderer() {
                return new ComponentRenderer<EmptySpace>() {
                    public TerminalSize getPreferredSize(EmptySpace component) {
                        return new TerminalSize(Map.COLUMNS, Map.LINES);
                    }

                    public void drawComponent(TextGUIGraphics graphics, EmptySpace component) {
                        /*
						 * Fill background
                         */
                        graphics.setBackgroundColor(bkgColor);
                        graphics.setModifiers(EnumSet.of(SGR.BOLD));
                        graphics.fill(' ');

                        for (MapLayer ml : layers) {
                            for (int x = 0; x < COLUMNS; x++) {
                                for (int y = 0; y < LINES; y++) {
                                    MapObject t = (MapObject) ml.getMap()[x][y];
                                    if (t != null) {
                                        graphics.setBackgroundColor(t.getBackgroundColor());
                                        graphics.setForegroundColor(t.getForegroundColor());
                                        graphics.putString(x, y, String.valueOf(t.getSymbol()));
                                    }
                                }
                            }
                        }
                        /*for (int x = 0; x < COLUMNS; x++) {
                            for (int y = 0; y < LINES; y++) {
                                Tree2 t = (Tree2) trees.getMap()[x][y];
                                if (t != null) {
                                    graphics.setBackgroundColor(t.getBackgroundColor());
                                    graphics.setForegroundColor(t.getForegroundColor());
                                    graphics.putString(x, y, String.valueOf(t.getSymbol()));
                                }
                            }
                        }
                        for (int x = 0; x < COLUMNS; x++) {
                            for (int y = 0; y < LINES; y++) {
                                Orc o = (Orc) foes.getMap()[x][y];
                                if (o != null) {
                                    graphics.setBackgroundColor(o.getBackgroundColor());
                                    graphics.setForegroundColor(o.getForegroundColor());
                                    graphics.putString(x, y, String.valueOf(o.getSymbol()));
                                }
                            }
                        }*/


 /*
						 * Creates the river
 
                         */
 /*graphics.setForegroundColor(new TextColor.RGB(30, 150, 200));
                        for (int i = 0; i < waterpos.length; i++) {
                            graphics.setBackgroundColor(new TextColor.RGB(30, 150, 100));
                            graphics.putString(waterpos[i], i, String.valueOf(SymbolsMirk.WATER[2]));
                            graphics.setBackgroundColor(bkgColor);
                            graphics.putString(waterpos[i] - 1, i, String.valueOf(SymbolsMirk.WATER[1]));
                            graphics.putString(waterpos[i] + 1, i, String.valueOf(SymbolsMirk.WATER[1]));
                            graphics.putString(waterpos[i] - 2, i, String.valueOf(SymbolsMirk.WATER[0]));
                            graphics.putString(waterpos[i] + 2, i, String.valueOf(SymbolsMirk.WATER[0]));
                        }*/

 /*
						 * Draw characters
                         */
                        Hero h = _chars.getHero();
                        graphics.setBackgroundColor(h.get_bkgColor());
                        graphics.setForegroundColor(h.get_foregroundColor());
                        graphics.setCharacter(h.get_position(), h.get_face());

                        graphics.setModifiers(EnumSet.of(SGR.BLINK));
                        Foe f = _chars.getFoe();
                        graphics.setBackgroundColor(f.get_bkgColor());
                        graphics.setForegroundColor(f.get_foregroundColor());
                        graphics.setCharacter(f.get_position(), f.get_face());
                    }
                };
            }
        };

        addComponent(land);

    }

    public void generateWater() {
        int col = mRand.nextInt(COLUMNS);
        for (int i = 0; i < LINES; i++) {
            waterpos[i] = col + (mRand.nextInt(2) - 1);
        }
    }

    public void refreshLand() {
        land.invalidate();
    }

    public void updatePlayer(KeyStroke keyStroke) {
        TerminalPosition ppos = _chars.getHero().get_position();
        Hero player = _chars.getHero();
        switch (keyStroke.getCharacter()) {
            case 'w':
                if (canPass(ppos.getColumn(), ppos.getRow() - 1)) {
                    player.set_position(new TerminalPosition(ppos.getColumn(), ppos.getRow() - 1));
                }
                break;
            case 's':
                if (canPass(ppos.getColumn(), ppos.getRow() + 1)) {
                    player.set_position(new TerminalPosition(ppos.getColumn(), ppos.getRow() + 1));
                }
                break;
            case 'a':
                if (canPass(ppos.getColumn() - 1, ppos.getRow())) {
                    player.set_position(new TerminalPosition(ppos.getColumn() - 1, ppos.getRow()));
                }
                break;
            case 'd':
                if (canPass(ppos.getColumn() + 1, ppos.getRow())) {
                    player.set_position(new TerminalPosition(ppos.getColumn() + 1, ppos.getRow()));
                }
                break;
            default:
                System.out.println(keyStroke.getCharacter().toString());
                break;
        }

        refreshLand();
    }

    private boolean canPass(int x, int y) {
        if (x <0 || y <0 || x >49 || y >15) {
            return false;
        } else {
            for (MapLayer ml : layers) {
                if (ml.getMap()[x][y] != null) {

                    MapObject[][] map = ml.getMap();
                    MapObject mo = map[x][y];
                    if (!ml.getMap()[x][y].isWalkthrough()) {
                        return false;
                    }

                }
            }
        }

        return true;
    }

    private boolean canSee(int x, int y) {
        for (MapLayer ml : layers) {
            if (ml.getMap()[x][y] != null) {
                MapObject[][] map = ml.getMap();
                MapObject mo = map[x][y];
                if (!ml.getMap()[x][y].isVisible()) {
                    return false;
                }

            }
        }
        return true;
    }
    /*
	 * @Override protected void onAfterDrawing(TextGUIGraphics graphics) { //
	 * TODO Auto-generated method stub super.onAfterDrawing(graphics);
	 * graphics.setForegroundColor(TextColor.ANSI.CYAN);
	 * graphics.setBackgroundColor(TextColor.ANSI.BLUE);
	 * graphics.setModifiers(EnumSet.of(SGR.BOLD)); graphics.fill(' ');
	 * graphics.putString(3, 0, "Text GUI in 100% Java"); }
     */
}
