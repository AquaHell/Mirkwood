package gui;

import java.util.Random;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import artefactos.MapObject;
        
public class PanelStatus extends Panel {

    private Panel pStatus;
    private Label Hp,
            Stamina,
            Power,
            Defense,
            Gold;

    public PanelStatus() {
        super(new GridLayout(2));

        addComponent(new Label("HP"));
        addComponent(createLabel(Hp, "Hp"));

        addComponent(new Label("Stamina"));
        addComponent(createLabel(Stamina, "Stamina"));

        addComponent(new Label("Power"));
        addComponent(createLabel(Power, "Power"));
        
        addComponent(new Label("Defense"));
        addComponent(createLabel(Defense, "Defense"));

        addComponent(new Label("Gold"));
        addComponent(createLabel(Gold, "Gold"));

    }
    
    private Label createLabel(Label lblValue, String lbl) {
        lblValue = new Label(String.valueOf((new Random().nextInt(100))));
        lblValue.setBackgroundColor(TextColor.ANSI.BLACK);
        lblValue.setForegroundColor(TextColor.ANSI.YELLOW);
        
        
        return lblValue;
    }

    public Panel getpStatus() {
        return pStatus;
    }

    public void setpStatus(Panel pStatus) {
        this.pStatus = pStatus;
    }

    public Label getLblHP() {
        return Hp;
    }

    public void setLblHP(Label lblHP) {
        this.Hp = lblHP;
    }

    public Label getLblStamina() {
        return Stamina;
    }

    public void setLblStamina(Label lblStamina) {
        this.Stamina = lblStamina;
    }

    public Label getLblPower() {
        return Power;
    }

    public void setLblPower(Label lblPower) {
        this.Power = lblPower;
    }

    public Label getLblGold() {
        return Gold;
    }

    public void setLblGold(Label Gold) {
        this.Gold = Gold;
    }

}
