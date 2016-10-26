package gui;

import artefactos.LayerTrees;
import artefactos.Tree2;
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

import script.Characters;
import script.Foe;
import script.Hero;

public class Map extends Panel {

    public static final int COLUMNS = 50;
    public static final int LINES = 16;

    public static final int TREECOUNT = 400;
    public static final int BRANCHESCOUNT = 250;

    Random mRand;
    LayerTrees trees;
    int cont = 0;
    int[] playerpos = new int[]{2, 2};

    int[] waterpos = new int[LINES];
    Tree[] treespos = new Tree[TREECOUNT];
    Tree[] branchespos = new Tree[BRANCHESCOUNT];
    public static RGB bkgColor = new TextColor.RGB(165, 127, 61);

    Characters _chars;

    EmptySpace land;

    public Map(Characters chars) {
        super();

        _chars = chars;
        getBasePane();

        mRand = new Random();

        generateWater();

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
                        while (cont == 0) {
                            trees = new LayerTrees();
                            cont++;
                        }
                        for (int x = 0; x < COLUMNS; x++) {
                            for (int y = 0; y < LINES; y++) {
                                Tree2 t = (Tree2) trees.getMap()[x][y];
                                if (t != null) {
                                    graphics.setBackgroundColor(t.getBackgroundColor());
                                    graphics.setForegroundColor(t.getForegroundColor());
                                    graphics.putString(x, y, String.valueOf(t.getSymbol()));
                                }
                            }
                        }


                        /*
						 * Creates the river
                         */
                        graphics.setForegroundColor(new TextColor.RGB(30, 150, 200));
                        for (int i = 0; i < waterpos.length; i++) {
                            graphics.setBackgroundColor(new TextColor.RGB(30, 150, 100));
                            graphics.putString(waterpos[i], i, String.valueOf(SymbolsMirk.WATER[2]));
                            graphics.setBackgroundColor(bkgColor);
                            graphics.putString(waterpos[i] - 1, i, String.valueOf(SymbolsMirk.WATER[1]));
                            graphics.putString(waterpos[i] + 1, i, String.valueOf(SymbolsMirk.WATER[1]));
                            graphics.putString(waterpos[i] - 2, i, String.valueOf(SymbolsMirk.WATER[0]));
                            graphics.putString(waterpos[i] + 2, i, String.valueOf(SymbolsMirk.WATER[0]));
                        }

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
                player.set_position(new TerminalPosition(ppos.getColumn(), ppos.getRow() - 1));
                break;
            case 's':
                player.set_position(new TerminalPosition(ppos.getColumn(), ppos.getRow() + 1));
                break;
            case 'a':
                player.set_position(new TerminalPosition(ppos.getColumn() - 1, ppos.getRow()));
                break;
            case 'd':
                player.set_position(new TerminalPosition(ppos.getColumn() + 1, ppos.getRow()));
                break;
            default:
                System.out.println(keyStroke.getCharacter().toString());
                break;
        }

        refreshLand();
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
