import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Menu extends JPanel implements MouseListener, MouseMotionListener {
  
  private SpringLayout layout;
  private JPopupMenu howManyDice, diceType;
  
  protected int mouseX, mouseY;
  
  JMenuItem m1, m2;
  
  Menu () {
    layout = new SpringLayout ();
    setLayout (layout);
    
    m1 = new JMenuItem ("Roll");
    m2 = new JMenuItem ("Map");
    
    layout.putConstraint (layout.WEST, m1, 0, layout.WEST, this);
    layout.putConstraint (layout.WEST, m2, 0, layout.EAST, m1);
    
    add (m1);
    add (m2);
    
    m1.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        
        howManyDice = new JPopupMenu ();
        JMenuItem one = new JMenuItem("1");
        JMenuItem two = new JMenuItem("2");
        JMenuItem three = new JMenuItem("3");
        JMenuItem four = new JMenuItem("4");
        
        howManyDice.add (one);
        howManyDice.add (two);
        howManyDice.add (three);
        howManyDice.add (four);
        
        one.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            getDiceType (1);
          }
        });
        
        two.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            getDiceType(2);
          }
        });
        
        three.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            getDiceType(3);
          }
        });
        
        four.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            getDiceType(4);
          }
        });
        
        mouseX = e.getX();
        mouseY = e.getY();
        
        howManyDice.show (Menu.this, mouseX, mouseY-20);
      }
      
      @Override
      public void mouseReleased(MouseEvent e) {}
      @Override
      public void mousePressed(MouseEvent e) {}
      @Override
      public void mouseEntered(MouseEvent e) {}
      @Override
      public void mouseExited(MouseEvent e) {}
      
      
    });
    
     // Add mouse listeners
    addMouseListener(Menu.this);
    addMouseMotionListener(Menu.this);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setMinimumSize (new Dimension ((int) screenSize.width / 10,(int) screenSize.height / 10));
    
  }
  
  @Override
  public Dimension getPreferredSize() {
    // so that our GUI is big enough
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    return new Dimension((int) (screenSize.width / 10), (int) (screenSize.height / 10));
  }
  
  private void getDiceType (final int num) {
    System.out.println ("I should roll " + num + " dice");
    
    diceType = new JPopupMenu ();
    JMenuItem option1 = new JMenuItem("Roll d4");
    JMenuItem option2 = new JMenuItem("Roll d6");
    JMenuItem option3 = new JMenuItem("Roll d8");
    JMenuItem option4 = new JMenuItem("Roll d10");
    JMenuItem option5 = new JMenuItem("Roll d12");
    JMenuItem option6 = new JMenuItem("Roll d20");
    
    diceType.add(option1);
    diceType.add(option2);
    diceType.add(option3);
    diceType.add(option4);
    diceType.add(option5);
    diceType.add(option6);
    
    option1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        roll(num, 4);
      }
    });
    option2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        roll(num, 6);
      }
    });
    option3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        roll(num, 8);
      }
    });
    option4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        roll(num, 10);
      }
    });
    option5.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        roll(num, 12);
      }
    });
    option6.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        roll(num, 20);
      }
    });
    
    diceType.show (Menu.this, mouseX, mouseY);
  }
  
  private void roll (int numDice, int type) {
    Random random = new Random();
    int randomNumber = -1;
    
    String display = "Rolled ";
    int total = 0;
    
    for (int i = 0; i < numDice - 1; i++) {
      randomNumber = random.nextInt(type) + 1;
      System.out.println ("Rolled " + randomNumber);
      display = display + randomNumber + " + ";
      total += randomNumber;
    }
    randomNumber = random.nextInt(type) + 1;
    System.out.println ("Rolled " + randomNumber);
    display = display + randomNumber + " = ";
    total += randomNumber;
    
    display += total;
    System.out.println (display);
    
    JOptionPane.showMessageDialog(Menu.this, display);
    
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
    // Capture mouse press coordinates relative to the label
    System.out.println (e.getX() + "," + e.getY()); 
    mouseX = e.getX();
    mouseY = e.getY();
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {}
  @Override
  public void mouseEntered(MouseEvent e) {}
  @Override
  public void mouseExited(MouseEvent e) {}
   @Override
  public void mouseMoved(MouseEvent e) {}
    @Override
  public void mouseDragged(MouseEvent e) {}
  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println ("here");
    if (SwingUtilities.isLeftMouseButton(e)) {
      howManyDice.show(Menu.this, e.getX(), e.getY());
    }
  }
}
  