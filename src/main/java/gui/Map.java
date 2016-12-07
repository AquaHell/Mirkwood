package gui;

import gui.artifacts.Tree;
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
import gui.artifacts.LayerRiver;
import gui.artifacts.MapLayer;
import gui.artifacts.MapObject;
import java.util.ArrayList;

import script.Characters;
import script.Foe;
import script.Hero;

public class Map extends Panel {

	public static final int COLUMNS = 256;
	public static final int LINES = 256;
	
	public static final int TREECOUNT = 5000;
	public static final int BRANCHESCOUNT = 8500;
	
	
	int[] playerpos = new int[]{2, 2};
        int[] playerinit = new int[]{2, 2};
	
	Tree[] treespos = new Tree[TREECOUNT];
	Tree[] branchespos = new Tree[BRANCHESCOUNT];
	public static RGB bkgColor = new TextColor.RGB(165, 127, 61);
        
        ArrayList<MapLayer> _layers;
	
	Characters _chars;

	EmptySpace land;

	public Map(Characters chars) {
		super();
                
                
                /*
                Create the respective layers
                */
                _layers = new ArrayList<MapLayer>();
                _layers.add(new LayerRiver());

		_chars = chars;
                
                playerpos[0] = _chars.getHero().get_position().getColumn();
                playerpos[1] = _chars.getHero().get_position().getRow();
                
                playerinit[0] = _chars.getHero().get_position().getColumn();
                playerinit[1] = _chars.getHero().get_position().getRow();
                
                
		getBasePane();
		
//		mRand = new Random();
		
//		generateWater();
		generateTrees();

		land = new EmptySpace(new TextColor.RGB(165, 127, 61)) {
			protected ComponentRenderer<EmptySpace> createDefaultRenderer() {
				return new ComponentRenderer<EmptySpace>() {
					public TerminalSize getPreferredSize(EmptySpace component) {
						return new TerminalSize(20, 10);
					}

					public void drawComponent(TextGUIGraphics graphics, EmptySpace component) {
						/*
						 * Fill background
						 */
						graphics.setBackgroundColor(bkgColor);
						graphics.setModifiers(EnumSet.of(SGR.BOLD));
						graphics.fill(' ');
						
						/*
						 * Creates the trees and branches
						 */
						for (Tree t : treespos) {
                                                    if ((t.getmPosition().getColumn() + (playerinit[0] - playerpos[0])) <= (COLUMNS - (t.getmPosition().getColumn() + 10))){
							graphics.setForegroundColor(t.getColor());
							graphics.putString(t.getmPosition().getColumn() + (playerinit[0] - playerpos[0]), 
                                                                t.getmPosition().getRow() + (playerinit[1] - playerpos[1]), 
                                                                String.valueOf(t.getmTree()));
                                                    }
						}
						for (Tree t : branchespos) {
                                                     if ((t.getmPosition().getColumn() + (playerinit[1] - playerpos[1])) <= (COLUMNS - (t.getmPosition().getColumn() + 5))){
							graphics.setForegroundColor(t.getColor());
							graphics.putString(t.getmPosition().getColumn()  +(playerinit[0] - playerpos[0]),  
                                                                t.getmPosition().getRow() + ((playerinit[1] + playerpos[1])),  
                                                                String.valueOf(t.getmTree()));
                                                     }
						}
						
						/*
						 * Creates the objects of layers
						 */
                                                /*
                                            for (MapLayer ml : _layers) {
                                                for (int i = _chars.getHero().get_position().getColumn() - 10; i < _chars.getHero().get_position().getColumn() + 10; i++) {
                                                    for (int j = _chars.getHero().get_position().getRow() - 5; j < _chars.getHero().get_position().getRow() +5; j++) {
                                                        MapObject mo = ml.getMaplayer()[i][j];
                                                        if (mo != null) {
                                                            graphics.setForegroundColor(mo.getForegroundColor());
                                                            graphics.setBackgroundColor(mo.getBackgroundColor());
                                                            graphics.putString(mo.getPosition(), String.valueOf(mo.getSymbol()));
                                                        }
                                                    }
                                                }
                                            }
                                                */
                                                    
                                                    

						
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
	
	public void generateTrees() {
		for (int i=0; i < TREECOUNT; i++)
			treespos[i] = Tree.factoryRandomTree(COLUMNS, LINES);

		for (int i=0; i < BRANCHESCOUNT; i++)
			branchespos[i] = Tree.factoryRandomBranch(COLUMNS, LINES);
	}

	public void refreshLand() {
		land.invalidate();
	}
	
    public void updatePlayer(KeyStroke keyStroke) {
        TerminalPosition ppos = _chars.getHero().get_position();
        Hero player = _chars.getHero();
        switch (keyStroke.getCharacter()) {
            case 'w': {
                playerpos[1] = playerpos[1] - 1;
                /*
                TerminalPosition npos = new TerminalPosition(ppos.getColumn(), ppos.getRow() - 1);
                if (isPositionAvailable(npos)) {
                    player.set_position(npos);
                }
                */
                break;
            }
            case 's': {
                playerpos[1] = playerpos[1] + 1;
                /*
                TerminalPosition npos = new TerminalPosition(ppos.getColumn(), ppos.getRow() + 1);
                if (isPositionAvailable(npos)) {
                    player.set_position(npos);
                }
                */
                break;
            }
            case 'a': {
                playerpos[0] = playerpos[0] - 1;
                /*
                TerminalPosition npos = new TerminalPosition(ppos.getColumn() - 1, ppos.getRow());
                if (isPositionAvailable(npos)) {
                    player.set_position(npos);
                }
                */
                break;
            }
            case 'd': {
                playerpos[0] = playerpos[0] + 1;
                /*
                TerminalPosition npos = new TerminalPosition(ppos.getColumn() + 1, ppos.getRow());
                if (isPositionAvailable(npos)) {
                    player.set_position(npos);
                }
                */
                break;
            }
            default:
                System.out.println(keyStroke.getCharacter().toString());
                break;
        }

        refreshLand();
    }
        
        private boolean isPositionAvailable(TerminalPosition pos) {
            
            for (MapLayer ml : _layers) {
                for (int i = 0; i < COLUMNS; i++) {
                    for (int j = 0; j < LINES; j++) {
                        MapObject mo = ml.getMaplayer()[i][j];
                        if (mo != null) {
                            if (mo.getPosition().getColumn() == pos.getColumn() && 
                                    mo.getPosition().getRow() == pos.getRow() &&
                                    !mo.isFree())
                                return false;
                        }
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
