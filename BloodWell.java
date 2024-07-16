import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

public class BloodWell extends LevelFramework implements ActionListener{
  
  private int backgroundWidth, backgroundHeight;
  
  
  public BloodWell (){
    setLayout (null);
    
     // Create and add draggable image labels
    Spell [] noSpells = {};
    Attack [] noAttacks = {};
    
    Character liam = new Players("CumGoblin.png", "Liam", 1, 1, noAttacks, noSpells);
    liam.setBounds(700, 600, liam.getPreferredSize().width, liam.getPreferredSize().height);
    add(liam);
    
    Character gabe = new Players("Gabe.png", "Gabe", 1, 1, noAttacks, noSpells);
    gabe.setBounds(750, 650, gabe.getPreferredSize().width, gabe.getPreferredSize().height);
    add(gabe);
    
    Character alex = new Players("Alex.png", "Alex", 1, 1, noAttacks, noSpells);
    alex.setBounds(710, 700, alex.getPreferredSize().width, alex.getPreferredSize().height);
    add(alex);
    
    Character jared = new Players("Jared.png", "Jared", 1, 1, noAttacks, noSpells);
    jared.setBounds(760, 600, jared.getPreferredSize().width, jared.getPreferredSize().height);
    add(jared);
    
    Character evan = new Players("Evan.png", "Evan", 1, 1, noAttacks, noSpells);
    evan.setBounds(800, 840, evan.getPreferredSize().width, evan.getPreferredSize().height);
    add(evan);
    
    WorldObject chest = new WorldObject ("Chest.png", "Chest", "The chest contains a +1 dagger and 2 potions of healing");
    chest.setBounds(1000-chest.getPreferredSize().width, 100, chest.getPreferredSize().width, chest.getPreferredSize().height);
   
    add(chest);
    
    backgroundWidth = 1200;
    backgroundHeight = 800;

    background = new Images ("BloodWell.png", backgroundWidth, backgroundHeight);
    background.setBounds(0, 0, backgroundWidth, backgroundHeight);
    
    
    Melkohm melkohm = new Melkohm ("Melkohm.png", 4);
    melkohm.setBounds(810, 590, melkohm.getPreferredSize().width, melkohm.getPreferredSize().height);
    add(melkohm);
    
    
    Ogre bloodOgre = new Ogre ("BloodOgre.png", "Blood Ogre");
    bloodOgre.setBounds(475, 360, bloodOgre.getPreferredSize().width, bloodOgre.getPreferredSize().height);
    add(bloodOgre);
    
    
    
    BloodHealer valentezna = new BloodHealer ("Valentezna.png", "Val", 4);
    valentezna.setBounds (800, 690, valentezna.getPreferredSize().width, valentezna.getPreferredSize().height);
    add (valentezna);
    
    
    /*BloodFighter leader = new BloodFighter ("Lise.png", "Lise", 4);
    leader.setBounds (870, 105, leader.getPreferredSize().width, leader.getPreferredSize().height);
    add (leader);*/
    WorldObject leader = new WorldObject ("Lise.png", "Lise", "", 100);
    leader.setBounds(680, 370, leader.getPreferredSize().width, leader.getPreferredSize().height);
    add (leader);
    
    add (background);
    
    Character c [] = {melkohm, bloodOgre, valentezna};
    characters = c;
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
  
    