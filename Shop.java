import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

public class Shop extends LevelFramework implements ActionListener{
  
  private int backgroundWidth, backgroundHeight;
  
  
  public Shop (){
    setLayout (null);
    
     // Create and add draggable image labels
    Spell [] noSpells = {};
    Attack [] noAttacks = {};
    
    Character liam = new Players("CumGoblin.png", "Liam", 1, 1, noAttacks, noSpells);
    liam.setBounds(850, 300, liam.getPreferredSize().width, liam.getPreferredSize().height);
    add(liam);
    
    Character gabe = new Players("Gabe.png", "Gabe", 1, 1, noAttacks, noSpells);
    gabe.setBounds(900, 350, gabe.getPreferredSize().width, gabe.getPreferredSize().height);
    add(gabe);
    
    Character alex = new Players("Alex.png", "Alex", 1, 1, noAttacks, noSpells);
    alex.setBounds(860, 400, alex.getPreferredSize().width, alex.getPreferredSize().height);
    add(alex);
    
    Character jared = new Players("Jared.png", "Jared", 1, 1, noAttacks, noSpells);
    jared.setBounds(910, 300, jared.getPreferredSize().width, jared.getPreferredSize().height);
    add(jared);
    
    Character evan = new Players("Evan.png", "Evan", 1, 1, noAttacks, noSpells);
    evan.setBounds(950, 340, evan.getPreferredSize().width, evan.getPreferredSize().height);
    add(evan);
    
    
    backgroundWidth = 1000;
    backgroundHeight = 800;

    background = new Images ("Shop.png", backgroundWidth, backgroundHeight);
    background.setBounds(0, 0, backgroundWidth, backgroundHeight);
    
    
    
    WorldObject garfunkel = new WorldObject ("Garfunkel.png", "Garfunkel", "", 110);
    garfunkel.setBounds(240, 340, garfunkel.getPreferredSize().width, garfunkel.getPreferredSize().height);
    add (garfunkel);
    
    add (background);
    Character c [] = {};
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
  
    