import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

public class AttackPort extends LevelFramework implements ActionListener{
  
  private int backgroundWidth, backgroundHeight;
  
  
  public AttackPort (){
    super ();
    
     // Create and add draggable image labels
    Spell [] noSpells = {};
    Attack [] noAttacks = {};
    
    Character liam = new Players("CumGoblin.png", "Liam", 1, 1, noAttacks, noSpells);
    liam.setBounds(700, 900, liam.getPreferredSize().width, liam.getPreferredSize().height);
    add(liam);
    
    Character gabe = new Players("Gabe.png", "Gabe", 1, 1, noAttacks, noSpells);
    gabe.setBounds(660, 900, gabe.getPreferredSize().width, gabe.getPreferredSize().height);
    add(gabe);
    
    Character alex = new Players("Alex.png", "Alex", 1, 1, noAttacks, noSpells);
    alex.setBounds(620, 900, alex.getPreferredSize().width, alex.getPreferredSize().height);
    add(alex);
    
    Character jared = new Players("Jared.png", "Jared", 1, 1, noAttacks, noSpells);
    jared.setBounds(580, 900, jared.getPreferredSize().width, jared.getPreferredSize().height);
    add(jared);
    
    Character evan = new Players("Evan.png", "Evan", 1, 1, noAttacks, noSpells);
    evan.setBounds(540, 900, evan.getPreferredSize().width, evan.getPreferredSize().height);
    add(evan);
    
    WorldObject chest = new WorldObject ("Chest.png", "Chest", "The chest contains a +1 dagger and 2 potions of healing");
    chest.setBounds(1000-chest.getPreferredSize().width, 100, chest.getPreferredSize().width, chest.getPreferredSize().height);
   
    add(chest);
    
    backgroundWidth = 1000;
    backgroundHeight = 1000;

    background = new Images ("ShantalorePort.jpg", backgroundWidth, backgroundHeight);
    background.setBounds(0, 0, backgroundWidth, backgroundHeight);
    
    
    Melkohm melkohm = new Melkohm ("Melkohm.png", 4);
    melkohm.setBounds(500, 900, melkohm.getPreferredSize().width, melkohm.getPreferredSize().height);
    add(melkohm);
    
    WorldObject soldier = new WorldObject ("Soldier.png", "", "");
    soldier.setBounds (325, 635, soldier.getPreferredSize().width, soldier.getPreferredSize().height);
    add (soldier);
    
    BloodHealer healer = new BloodHealer ("FemaleBH.png", "Healer", 4);
    healer.setBounds (250, 100, healer.getPreferredSize().width, healer.getPreferredSize().height);
    add (healer);
    
    OrcWarrior orc1 = new OrcWarrior ("OrcWarrior.png", "Orc 1", 4, false);
    orc1.setBounds (190, 110,  orc1.getPreferredSize().width, orc1.getPreferredSize().height);
    add (orc1);
    
    OrcWarrior orc2 = new OrcWarrior ("OrcWarrior.png", "Orc 2", 4, false);
    orc2.setBounds (95, 110,  orc2.getPreferredSize().width, orc2.getPreferredSize().height);
    add (orc2);
    
    OrcWarrior tank = new OrcWarrior ("OrcTank.png", "Orc 3", 4, true);
    tank.setBounds (135, 115,  tank.getPreferredSize().width, tank.getPreferredSize().height);
    add (tank);
    
    add (background);
    
    Character c [] = {melkohm, healer, orc1, orc2, tank};
    addCharacter (c);
  }

  
  @Override
  public void keyReleased (KeyEvent e) {}
  
  /**
   * The update method will re-apply the constraints of any objects that move across the screen
   */
  public void update (){}
  
  @Override
  public void actionPerformed (ActionEvent ae){}
  
  @Override
  public void keyPressed (KeyEvent e){}
  
  @Override
  public Dimension getPreferredSize() {
    // so that our GUI is big enough
    return new Dimension (backgroundWidth, backgroundHeight);
  }
}
  
    