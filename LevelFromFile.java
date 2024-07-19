import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

public class LevelFromFile extends LevelFramework implements ActionListener{
  
  private int backgroundWidth, backgroundHeight;
  
  public LevelFromFile (String level) {
    
    String delim = "[,]";
    
    try {
      File myFile = new File (level + ".txt");
      Scanner myReader = new Scanner (myFile);
      

      //reads the background
      String [] input = myReader.nextLine().split(delim);
      
      backgroundWidth = Integer.parseInt(input[1]);
      backgroundHeight = Integer.parseInt(input[2]);
      
      background = new Images (input[0], backgroundWidth, backgroundHeight);
      background.setBounds(0, 0, backgroundWidth, backgroundHeight);
      
      //reads the characters
      while (myReader.hasNextLine()) {
        input = myReader.nextLine ().split (delim);
        
        File charFile = new File (input[0] + ".txt");
        Scanner charReader = new Scanner (charFile);
        
        Character c = new CharFromFile (input[0] + ".txt", charReader.nextLine().split(delim));
        c.setBounds(Integer.parseInt(input[1]), Integer.parseInt(input[2]), c.getPreferredSize().width, c.getPreferredSize().height);
        add(c);
        
        addCharacter(c);
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    add(background);
  }
  
  @Override
  public void keyReleased (KeyEvent e) {}
  
  /**
   * The update method will re-apply the constraints of any objects that move across the screen
   */
  public void update (){}
  
  @Override
  public void actionPerformed (ActionEvent ae) {}
  
  @Override
  public void keyPressed (KeyEvent e){}
  
  @Override
  public Dimension getPreferredSize() {
    // so that our GUI is big enough
    return new Dimension (backgroundWidth, backgroundHeight);
  }
}


    