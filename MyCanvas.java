import java.awt.*;  
import javax.swing.JFrame;  
  
public class MyCanvas extends Canvas{  
      
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i = t.getImage("Undercity.png");  
        g.drawImage(i, 120,100,this);  
          
    }
}  