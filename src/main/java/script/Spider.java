/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package script;

import com.googlecode.lanterna.TextColor;
import java.util.Random;

/**
 *
 * @author Trainerpl022
 */
public class Spider extends Character {
private final char FRONHA = '#';
    
    public Spider(){
    super(0,0,0,0);
    
    setHp(_rand.nextInt(60)+40);
    setAttack(_rand.nextInt(12)+8);
    setDefense(_rand.nextInt(10)+10);
    setSymbol(FRONHA);
    
    setBackgroundColor(new TextColor.RGB(0, 0, 0));
    setForegroundColor(new TextColor.RGB(255, 255, 0));
    
    }
    
    public Spider(int hp,  int attack, int defense) {
        super(hp, 0, attack, defense);
        
        setSymbol(FRONHA);
        
        Random r = new Random();
        int p = 4 + r.nextInt(5);  
    }
    
     
}
