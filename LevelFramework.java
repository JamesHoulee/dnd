import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Dimension;

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
public abstract class LevelFramework extends JPanel implements ActionListener, KeyListener {
  
  protected SpringLayout layout;
  
  protected Timer timer;
  protected int x,y,dx,dy;
  protected int time;
  
  protected Images background;
  
  private Dimension screenSize;
  private int imageWidth;
  private int imageHeight;
  
  protected Character [] characters;
  
  /**
   * This is the constructor for the LevelFramework class. It initializes all of the variables that were declared and
   * sets the layout of the JPanel to be a SpringLayout. It also puts the constraints on all the objects that will 
   * appear on screen.
   */
  public LevelFramework (){
    
    screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    imageWidth = screenSize.width;
    imageHeight = screenSize.height;
    
    setMinimumSize (new Dimension ((int) 2 * imageWidth / 3,(int) 2 * imageHeight / 3));
    
    System.out.println (2 * imageWidth / 3);
    System.out.println (2 * imageHeight / 3);
    
    layout = new SpringLayout ();
    setLayout (layout);
    
    timer = new Timer (5, this);
    
    dx = 0;
    dy = 0;
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
  
  @Override
  public Dimension getPreferredSize() {
    // so that our GUI is big enough
    return new Dimension((int) (2 * imageWidth / 3),(int) (2 * imageHeight / 3));
  }
}
                          
    
    
    
    