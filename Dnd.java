import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Dnd {
  
      public static void main(String [] args) {  
        
        JPanel container = new JPanel ();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        AttackPort un = new AttackPort ();
        
        JScrollPane display = new JScrollPane (un, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        Menu m = new Menu ();
       

        
        container.add (display);
        container.add (m);
        
        un.rollInitiative ();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // create a basic JFrame  
        JFrame f = new JFrame();  
        f.add(container); 
        f.setSize(screenSize.width, screenSize.height);
        f.setVisible(true);  
      }  

}  