import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;

public class Dnd {
  
  public static void addCharacter (LevelFramework lf) {
    
    String regex = "[,]";
    String [] wordsInRow;
    
    System.out.print ("Add who? ");
    Scanner console = new Scanner (System.in);
    String who = console.nextLine ();
    
    try {
      File myFile = new File (who + ".txt");
      Scanner myReader = new Scanner (myFile);
      
      wordsInRow = myReader.nextLine().split(regex);
      
      lf.addUndefinedCharacter (new CharFromFile (who + ".txt", wordsInRow));
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

   public static void addCharacter (LevelFramework lf, String who) {
    
    String regex = "[,]";
    String [] wordsInRow;
    
    try {
      File myFile = new File (who + ".txt");
      Scanner myReader = new Scanner (myFile);
      
      wordsInRow = myReader.nextLine().split(regex);
      
      lf.addUndefinedCharacter (new CharFromFile (who + ".txt", wordsInRow));
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  public static void loadLevel (LevelFramework lf) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    JPanel container = new JPanel ();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      
    JScrollPane display = new JScrollPane (lf, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    Menu m = new Menu ();
    
    container.add (display);
    container.add (m);
    
    lf.rollInitiative ();
    
    // create a basic JFrame  
    JFrame frame = new JFrame();  
    frame.add(container); 
    frame.setSize(screenSize.width, screenSize.height);
    frame.setVisible(true);  
    
    
    Scanner obj = new Scanner (System.in);
    String input;
    
    while (true) {
      input = obj.nextLine ();
      
      if (input.compareTo ("end") == 0) {
        break;
      }
      else if (input.compareTo ("add") == 0) {
        addCharacter (lf);
      }
      else if (input.substring (0,3).compareTo("add") == 0) {
        String [] temp = input.split ("[\\s]");
        
        for (String s : temp){
          System.out.println (s);
        }
        
        addCharacter (lf, input.split("[\\s]")[1]);
      }
    }
  }
  
  
  public static void main(String [] args) { 
    
    Scanner obj = new Scanner (System.in);
    String input; 
    
    while (true) {
      input = obj.nextLine ();
      
      if (input.compareTo ("attack port") == 0) {
        loadLevel (new AttackPort ());
      }
      else if (input.compareTo ("capital") == 0) {
        loadLevel (new Capital ());
      }
      else if (input.compareTo ("shantalore") == 0) {
        loadLevel (new Shantalore ());
      }
      else if (input.compareTo ("blood well") == 0) {
        loadLevel (new BloodWell ());
      }
      else if (input.compareTo ("shop") == 0) {
        loadLevel (new Shop ());
      }
      else if (input.compareTo ("tavern") == 0) {
        loadLevel (new Tavern ());
      }
      
      else if (input.compareTo ("end") == 0) {
        break;
      }
      else {
        loadLevel (new LevelFromFile (input));
      }
    }
  }  
  
}  