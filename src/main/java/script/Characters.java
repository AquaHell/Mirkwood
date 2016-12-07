package script;

import com.googlecode.lanterna.TerminalPosition;

import gui.Map;

public class Characters {
	Hero hero;
	Foe foe;
	

	public Characters() {
		super();
		
		hero = new Hero("Sir Guinetti", new TerminalPosition(5, 5));
		foe = new Foe("Sauron", new TerminalPosition(Map.COLUMNS-2, 2));
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Foe getFoe() {
		return foe;
	}

	public void setFoe(Foe foe) {
		this.foe = foe;
	}
	
	
	
	
}
