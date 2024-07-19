import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.Dimension;

import java.util.*;

/**
 * The LevelFramework class extends JPanel and implements ActionLister and KeyListener. This class defines how any level
 * created in the game should operate. This includes adding any objects that will always be on screen, and starting 
 * the animations via the Timer class.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>sprite </b> This variable holds the information of an Images object representing the sprite of the main character.
 * <p>
 * <b>layout </b> This variable holds the information of a SpringLayout object for the JPanel's layout.
 * <p>
 * <b>anxietyBar </b> This variable holds the information of an AnxietyBar object representing the player's anxiety bar.
 * <p>
 * <b>menuButton </b> This variable holds the information of a MenuButton object for the menu button
 * <p>
 * <b>inventory </b> This variable holds the information of an Inventory object for the player's inventory
 * <p>
 * <b>timer </b> This variable holds the information of a Timer object
 * <p>
 * <b>x </b> This variable represents the x-coordinate of the player
 * <p>
 * <b>y </b> This variable represents the y-coordinate of the player
 * <p>
 * <b>dx </b> This variable represents the horizontal velocity of the player
 * <p>
 * <b>dy </b> This variable represents the vertical velocity of the player
 * <p>
 * <b>time </b> this variable represents the amount of time since the Timer.start () method was called.
 * 
 * @author James Houle and Juan Diego Castano 
 * @version 1 06.08.19
 */
public abstract class LevelFramework extends JLayeredPane implements ActionListener, KeyListener {
  
  protected Images background;
  
  protected List<Character> characters;
  
  /**
   * This is the constructor for the LevelFramework class. It initializes all of the variables that were declared and
   * sets the layout of the JPanel to be a SpringLayout. It also puts the constraints on all the objects that will 
   * appear on screen.
   */
  public LevelFramework (){
    
    setLayout(null);
    
    characters = new ArrayList<Character> ();
  }
  
  public LevelFramework (Character [] c) {
    this ();
    
    characters = new ArrayList<Character> ();
    
    for (int i = 0; i < c.length; i++) {
      characters.add(c[i]);
    }

  }
  
  public LevelFramework (List<Character> c) {
    this ();
    
    characters = c;
  }
  
  public void rollInitiative () {
    
    for (int i = 0; i < characters.size (); i++) {
      System.out.print (characters.get(i).getName () + " ");
      characters.get(i).rollInitiative ();
    }
  }
  
  public void addCharacter (Character c) {
    characters.add(c);
  }
  
  public void addCharacter (Character [] c) {
    for (int i = 0; i < c.length; i++) {
      characters.add(c[i]);
    }
  }
  
  public void addUndefinedCharacter (Character c) {
    characters.add(c);
    c.setBounds (0, 0, c.getPreferredSize().width, c.getPreferredSize().height);
    add (c);
    moveToFront(c);
    
    System.out.print (c.getName () + " ");
    c.rollInitiative ();
  }
    
    
  
  public abstract void actionPerformed (ActionEvent e);
  
  public abstract void keyPressed (KeyEvent e);
  
  public void keyTyped (KeyEvent e){}
  
  public abstract void keyReleased (KeyEvent e);
  
  /**
   * The update method will re-apply the constraints of any objects that move across the screen
   */
  public abstract void update ();
  
  /**
   * The refresh method calls the repaint and revalidate methods.
   */
  public void refresh (){
    repaint ();
    revalidate ();
  }
  
  
  public abstract Dimension getPreferredSize();
}
                          
    
    
    
    