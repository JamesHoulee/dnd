import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

public class Shantalore extends LevelFramework implements ActionListener{
  
  private int backgroundWidth, backgroundHeight;
  
  
  public Shantalore (){
    setLayout (null);
    
     // Create and add draggable image labels
    Spell [] noSpells = {};
    Attack [] noAttacks = {};
    
    Character liam = new Players("CumGoblin.png", "Liam", 1, 1, noAttacks, noSpells);
    liam.setBounds(850, 850, liam.getPreferredSize().width, liam.getPreferredSize().height);
    add(liam);
    
    Character gabe = new Players("Gabe.png", "Gabe", 1, 1, noAttacks, noSpells);
    gabe.setBounds(900, 800, gabe.getPreferredSize().width, gabe.getPreferredSize().height);
    add(gabe);
    
    Character alex = new Players("Alex.png", "Alex", 1, 1, noAttacks, noSpells);
    alex.setBounds(860, 800, alex.getPreferredSize().width, alex.getPreferredSize().height);
    add(alex);
    
    Character jared = new Players("Jared.png", "Jared", 1, 1, noAttacks, noSpells);
    jared.setBounds(910, 860, jared.getPreferredSize().width, jared.getPreferredSize().height);
    add(jared);
    
    Character evan = new Players("Evan.png", "Evan", 1, 1, noAttacks, noSpells);
    evan.setBounds(950, 840, evan.getPreferredSize().width, evan.getPreferredSize().height);
    add(evan);
    
    WorldObject chest = new WorldObject ("Chest.png", "Chest", "The chest contains a +1 dagger and 2 potions of healing");
    chest.setBounds(1000-chest.getPreferredSize().width, 100, chest.getPreferredSize().width, chest.getPreferredSize().height);
   
    add(chest);
    
    backgroundWidth = 1000;
    backgroundHeight = 1000;

    background = new Images ("Shantalore.jpg", backgroundWidth, backgroundHeight);
    background.setBounds(0, 0, backgroundWidth, backgroundHeight);
    
    
    Melkohm melkohm = new Melkohm ("Melkohm.png", 4);
    melkohm.setBounds(960, 790, melkohm.getPreferredSize().width, melkohm.getPreferredSize().height);
    add(melkohm);
    
    
    Ogre ogre1 = new Ogre ("Ogre.png", "Ogre1");
    ogre1.setBounds(655, 480, ogre1.getPreferredSize().width, ogre1.getPreferredSize().height);
    add(ogre1);
    
    Ogre ogre2 = new Ogre ("Ogre.png", "Ogre2");
    ogre2.setBounds(210, 255, ogre2.getPreferredSize().width, ogre2.getPreferredSize().height);
    add(ogre2);
    
    BloodHealer healer1 = new BloodHealer ("FemaleBH.png", "Healer1", 4);
    healer1.setBounds (655, 350, healer1.getPreferredSize().width, healer1.getPreferredSize().height);
    add (healer1);
    
    BloodHealer healer2 = new BloodHealer ("MaleBH.png", "Healer2", 4);
    healer2.setBounds (210, 105, healer2.getPreferredSize().width, healer2.getPreferredSize().height);
    add (healer2);
    
    BloodHealer valentezna = new BloodHealer ("Valentezna.png", "", 4);
    valentezna.setBounds (870, 105, valentezna.getPreferredSize().width, valentezna.getPreferredSize().height);
    add (valentezna);
    
    
    add (background);
    
    Character c [] = {melkohm, ogre1, ogre2, healer1, healer2, valentezna};
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
  
    