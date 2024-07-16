import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;


public abstract class Character extends JLabel implements MouseListener, MouseMotionListener {
  protected int mouseX, mouseY; // Variables to store the mouse coordinates
  private BufferedImage image; // Variable to store the image
  private JPopupMenu popupMenu;
  private JTextField textField; // Text field for displaying text
  
  protected JPopupMenu attack;
  protected JPopupMenu spell;
  
  private String name;
  private int maxHealth;
  private int currHealth;
  private int ac;
  
  protected Attack [] attackList;
  protected Spell [] spellList;
  
  public Character(String imagePath, String n, int h, int a, Attack [] att, Spell [] sp) {
    name = n;
    maxHealth = h;
    currHealth = h;
    ac = a;
    spellList = sp;
    attackList = att;
    
    setLayout(new BorderLayout());
    
    // Create text field and add to panel (above the image)
    textField = new JTextField(name + ": " + currHealth + "/" + maxHealth + "Hp, " + ac + "AC");
    textField.setEditable(false); // Make text field read-only
    add(textField, BorderLayout.NORTH);
    
    // Load the image
    try {
      image = ImageIO.read(new File(imagePath));
      setIcon(new ImageIcon(image)); // Set the image as icon of the JLabel
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // Set label properties
    setOpaque(true);
    setBackground(Color.white);
    
    // Create popup menu with options
    popupMenu = new JPopupMenu();
    JMenuItem option1 = new JMenuItem("Roll");
    JMenuItem option2 = new JMenuItem("Heal");
    JMenuItem option3 = new JMenuItem("Damage");
    JMenuItem option4 = new JMenuItem("Attacks");
    JMenuItem option5 = new JMenuItem("Spells");
    popupMenu.add(option1);
    popupMenu.add(option2);
    popupMenu.add(option3);
    popupMenu.add(option4);
    popupMenu.add(option5);
    
    // Add action listeners to menu items
    option1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JPopupMenu subMenu = new JPopupMenu();
        JMenuItem subOption1 = new JMenuItem("Roll d4");
        JMenuItem subOption2 = new JMenuItem("Roll d6");
        JMenuItem subOption3 = new JMenuItem("Roll d8");
        JMenuItem subOption4 = new JMenuItem("Roll d10");
        JMenuItem subOption5 = new JMenuItem("Roll d12");
        JMenuItem subOption6 = new JMenuItem("Roll d20");
        
        subMenu.add(subOption1);
        subMenu.add(subOption2);
        subMenu.add(subOption3);
        subMenu.add(subOption4);
        subMenu.add(subOption5);
        subMenu.add(subOption6);
        
        subOption1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int randomNumber = random.nextInt(4) + 1;
            JOptionPane.showMessageDialog(Character.this, "Random number: " + randomNumber);
          }
        });
        subOption2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int randomNumber = random.nextInt(6) + 1;
            JOptionPane.showMessageDialog(Character.this, "Random number: " + randomNumber);
          }
        });
        subOption3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int randomNumber = random.nextInt(8) + 1;
            JOptionPane.showMessageDialog(Character.this, "Random number: " + randomNumber);
          }
        });
        subOption4.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int randomNumber = random.nextInt(10) + 1;
            JOptionPane.showMessageDialog(Character.this, "Random number: " + randomNumber);
          }
        });
        subOption5.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int randomNumber = random.nextInt(12) + 1;
            JOptionPane.showMessageDialog(Character.this, "Random number: " + randomNumber);
          }
        });
        subOption6.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int randomNumber = random.nextInt(20) + 1;
            JOptionPane.showMessageDialog(Character.this, "Random number: " + randomNumber);
          }
        });
        
        
        subMenu.show(Character.this, mouseX+20, mouseY);
      }
    });
    
    option2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(Character.this, "How much:");
        if (input != null) {
          try {
            int number = Integer.parseInt(input);
            currHealth += number;
            if (currHealth > maxHealth) {
              currHealth = maxHealth;
            }
            textField.setText(name + ": " + currHealth + "/" + maxHealth + "Hp, " + ac + "AC");
            repaint(); // Refresh the drawing after the input is received
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(Character.this, "Invalid number entered. Please try again.");
          }
        }
      }
    });
    
    option3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(Character.this, "How much:");
        if (input != null) {
          try {
            int number = Integer.parseInt(input);
            currHealth -= number;
            if (currHealth < 0) {
              currHealth = 0;
            }
            textField.setText(name + ": " + currHealth + "/" + maxHealth + "Hp, " + ac + "AC");
            repaint(); // Refresh the drawing after the input is received
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(Character.this, "Invalid number entered. Please try again.");
          }
        }
      }
    });
    
    option4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        attacks(e);
        attack.show(Character.this, mouseX + 20, mouseY);
      }
    });
    
    option5.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        spells(e);
        spell.show(Character.this, mouseX + 20, mouseY);
      }
    });
      
    
    // Add mouse listeners
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
    // Capture mouse press coordinates relative to the label
    mouseX = e.getX();
    mouseY = e.getY();
  }
  
  @Override
  public void mouseDragged(MouseEvent e) {
    // Calculate new position of the label
    int newX = getX() + e.getX() - mouseX;
    int newY = getY() + e.getY() - mouseY;
    setLocation(newX, newY); // Update label's position
  }
  
  // Other mouse listener methods (not used in this example)
  @Override
  public void mouseClicked(MouseEvent e) {
    if (SwingUtilities.isRightMouseButton(e)) {
      popupMenu.show(this, e.getX(), e.getY());
    }
  }
  
  private int useAttack (JMenuItem j) {
    return attackList [Integer.parseInt (j.getText().substring (0,1))].use();
  }
  
  private int rollToHit (JMenuItem j) {
    return attackList [Integer.parseInt (j.getText().substring (0,1))].hit();
  }
  
  public void attacks (ActionEvent e) {
    attack = new JPopupMenu();
    
    for (int i = 0; i < attackList.length; i++) {
      final JMenuItem item = new JMenuItem (i + ". " + attackList[i].print());
      
      item.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.out.println ("I made it " );
            
            int hit = rollToHit (item);
            
            int option = JOptionPane.showOptionDialog(null, 
                                                  "Does " + hit + " hit?", 
                                                  "Option Dialog", 
                                                  JOptionPane.YES_NO_OPTION, 
                                                  JOptionPane.QUESTION_MESSAGE, 
                                                  null, 
                                                  new Object[]{"Yes", "No"}, 
                                                  "Yes");
            
            if (option == JOptionPane.YES_OPTION) {
              int damage = useAttack (item);
              JOptionPane.showMessageDialog(Character.this, "Did this much damage " + damage);
            }
          }
        });
      
      attack.add (item);
    }
  }
  
  private int useSpell (JMenuItem j) {
    return spellList [Integer.parseInt (j.getText().substring (0,1))].use();
  }
  
  public void spells (ActionEvent e) {
    spell = new JPopupMenu();
    
    for (int i = 0; i < spellList.length; i++) {
      final JMenuItem item = new JMenuItem (i + ". " + spellList[i].print());
      
      item.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.out.println ("I made it " );
            int damage = useSpell (item);
            JOptionPane.showMessageDialog(Character.this, "Did this much damage " + damage);
          }
        });
      
      spell.add (item);
    }
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {}
  @Override
  public void mouseEntered(MouseEvent e) {}
  @Override
  public void mouseExited(MouseEvent e) {}
  @Override
  public void mouseMoved(MouseEvent e) {}
 
}