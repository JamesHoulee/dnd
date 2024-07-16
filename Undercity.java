import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.awt.Dimension;


/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class Undercity extends LevelFramework implements ActionListener{
  
  private int backgroundWidth, backgroundHeight;
  
  /**
   * @param level is the level the player is currently in
   */
  public Undercity (){
     // Create and add draggable image labels
    Spell [] noSpells = {};
    Attack [] noAttacks = {};
    
    Character liam = new Players("CumGoblin.png", "Cum Goblin II", 1, 1, noAttacks, noSpells);
    liam.setBounds(100, 100, liam.getPreferredSize().width, liam.getPreferredSize().height);
    add(liam);
    
    Character gabe = new Players("Gabe.png", "Gabe", 1, 1, noAttacks, noSpells);
    gabe.setBounds(200, 200, gabe.getPreferredSize().width, gabe.getPreferredSize().height);
    add(gabe);
    
    Character alex = new Players("Alex.png", "Alex", 1, 1, noAttacks, noSpells);
    alex.setBounds(200, 200, alex.getPreferredSize().width, alex.getPreferredSize().height);
    add(alex);
    
    Character jared = new Players("Jared.png", "Jared", 1, 1, noAttacks, noSpells);
    jared.setBounds(200, 200, jared.getPreferredSize().width, jared.getPreferredSize().height);
    add(jared);
    
    Character evan = new Players("Evan.png", "Evan", 1, 1, noAttacks, noSpells);
    evan.setBounds(200, 200, evan.getPreferredSize().width, evan.getPreferredSize().height);
    add(evan);
    
    WorldObject chest = new WorldObject ("Chest.png", "Chest", "I do nothing!");
    chest.setBounds(100, 100, chest.getPreferredSize().width, chest.getPreferredSize().height);
    
    layout.putConstraint (layout.EAST, chest, 0, layout.EAST, this);
    add(chest);
    
    backgroundWidth = 1000;
    backgroundHeight = 1000;

    background = new Images ("Undercity.png", backgroundWidth, backgroundHeight);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, background, 0, layout.NORTH, this);
    add (background);
    
    Character c [] = {gabe, evan, liam, jared, alex};
    characters = c;
  }

  
  @Override
  public void keyReleased (KeyEvent e) {
    
  }
  
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
  
    