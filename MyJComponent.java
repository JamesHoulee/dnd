import java.awt.*;
import javax.swing.*;

class MyJComponent extends JComponent {  
      public void paint(Graphics g) {  
        g.setColor(Color.green);  
        g.fillRect(30, 30, 100, 100);  
      }  
}