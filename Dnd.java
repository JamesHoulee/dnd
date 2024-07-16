import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.Scanner;


public class Dnd {
  
  public static void tavern () {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    JPanel container = new JPanel ();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    
    Tavern cap = new Tavern ();  
    JScrollPane display = new JScrollPane (cap, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    Menu m = new Menu ();
    
    container.add (display);
    container.add (m);
    
    // create a basic JFrame  
    JFrame frame = new JFrame();  
    frame.add(container); 
    frame.setSize(screenSize.width, screenSize.height);
    frame.setVisible(true);  
  }
  
  public static void shop () {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    JPanel container = new JPanel ();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    
    Shop cap = new Shop ();  
    JScrollPane display = new JScrollPane (cap, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    Menu m = new Menu ();
    
    container.add (display);
    container.add (m);
    
    // create a basic JFrame  
    JFrame frame = new JFrame();  
    frame.add(container); 
    frame.setSize(screenSize.width, screenSize.height);
    frame.setVisible(true);  
  }
  
  public static void capital () {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    JPanel container = new JPanel ();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    
    Capital cap = new Capital ();  
    JScrollPane display = new JScrollPane (cap, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    Menu m = new Menu ();
    
    container.add (display);
    container.add (m);
    
    // create a basic JFrame  
    JFrame frame = new JFrame();  
    frame.add(container); 
    frame.setSize(screenSize.width, screenSize.height);
    frame.setVisible(true);  
  }
  
  public static void attack_port () {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    JPanel container = new JPanel ();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    
    AttackPort attackPort = new AttackPort ();  
    JScrollPane display = new JScrollPane (attackPort, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    Menu m = new Menu ();
    
    container.add (display);
    container.add (m);
    
    attackPort.rollInitiative ();
    
    // create a basic JFrame  
    JFrame attackPortFrame = new JFrame();  
    attackPortFrame.add(container); 
    attackPortFrame.setSize(screenSize.width, screenSize.height);
    attackPortFrame.setVisible(true);  
  }
  
  public static void bloodwell () {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    JPanel container = new JPanel ();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    
    BloodWell blood = new BloodWell ();  
    JScrollPane display = new JScrollPane (blood, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    Menu m = new Menu ();
    
    container.add (display);
    container.add (m);
    
    blood.rollInitiative ();
    
    // create a basic JFrame  
    JFrame shantaloreFrame = new JFrame();  
    shantaloreFrame.add(container); 
    shantaloreFrame.setSize(screenSize.width, screenSize.height);
    shantaloreFrame.setVisible(true);  
  }
  
  public static void shantalore () {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    JPanel container = new JPanel ();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    
    Shantalore shant = new Shantalore ();  
    JScrollPane display = new JScrollPane (shant, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    Menu m = new Menu ();
    
    container.add (display);
    container.add (m);
    
    shant.rollInitiative ();
    
    // create a basic JFrame  
    JFrame shantaloreFrame = new JFrame();  
    shantaloreFrame.add(container); 
    shantaloreFrame.setSize(screenSize.width, screenSize.height);
    shantaloreFrame.setVisible(true);  
  }
    
  
  
  public static void main(String [] args) { 
    
    Scanner obj = new Scanner (System.in);
    String input; 
    
    while (true) {
      input = obj.nextLine ();
      
      if (input.compareTo ("attack port") == 0) {
        attack_port ();
      }
      else if (input.compareTo ("capital") == 0) {
        capital ();
      }
      else if (input.compareTo ("shantalore") == 0) {
        shantalore ();
      }
      else if (input.compareTo ("blood well") == 0) {
        bloodwell ();
      }
      else if (input.compareTo ("shop") == 0) {
        shop ();
      }
      else if (input.compareTo ("tavern") == 0) {
        tavern ();
      }
      
      else if (input.compareTo ("end") == 0) {
        break;
      }
    }
  }  
  
}  