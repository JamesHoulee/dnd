import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 2 06.05.19
 */
public class Undercity extends LevelFramework implements ActionListener{
  
  /**
   * @param level is the level the player is currently in
   */
  public Undercity (){
     // Create and add draggable image labels
    Spell [] noSpells = {new Spell ("Dummy", 2, "1d4", "Does dmg"), new Spell ("Other Dummy", 2, "2d4", "does smth")};
    Attack [] noAttacks = {new Attack ("deddy", 4, "1d4", 3, "attack!")};
    
    Character gabe = new BloodElf("Gabe.png", "Gabe", 10, 15, noAttacks, noSpells);
    gabe.setBounds(100, 100, gabe.getPreferredSize().width, gabe.getPreferredSize().height);
    add(gabe);
    
    Character gabe1 = new BloodElf("Gabe.png", "Gabe1", 10, 15, noAttacks, noSpells);
    gabe1.setBounds(200, 200, gabe1.getPreferredSize().width, gabe1.getPreferredSize().height);
    add(gabe1);
    

    background = new Images ("Undercity.png",1000,750);
    
    layout.putConstraint (layout.WEST, background, 0, layout.WEST, this);
    layout.putConstraint (layout.NORTH, background, 0, layout.NORTH, this);
    add (background);
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
  
}
  
    