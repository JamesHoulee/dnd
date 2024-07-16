import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Dnd {
  
      public static void main(String [] args) {  
        
        JPanel container = new JPanel ();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        Undercity un = new Undercity ();
        Menu m = new Menu ();
       

        
        container.add (un);
        container.add (m);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // create a basic JFrame  
        JFrame f = new JFrame();  
        f.add(container); 
        f.setSize(screenSize.width, screenSize.height);
        f.setVisible(true);  
      }  

}  