import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;
import java.awt.Image;


public abstract class Character extends JPanel implements MouseListener, MouseMotionListener {
  protected int mouseX, mouseY; // Variables to store the mouse coordinates
  private BufferedImage image; // Variable to store the image
  private JPopupMenu popupMenu;
  private JTextField textField; // Text field for displaying text
  
  protected JPopupMenu attack;
  protected JPopupMenu spell;
  
  private String name;
  private int maxHealth;
  private int currHealth;
  protected int ac;
  
  private int initiativeBonus;
  
  private int [] stats; //strength, dexterity, constitution, intelligence, wisdom, charisma
  
  protected Attack [] attackList;
  protected Spell [] spellList;
  
  public Character(String imagePath, String n, int h, int a, Attack [] att, Spell [] sp) {
    name = n;
    maxHealth = h;
    currHealth = h;
    ac = a;
    spellList = sp;
    attackList = att;
    
    initiativeBonus = 0;
    
    int temp [] = {0,0,0,0,0,0};
    stats = temp;
    
    setLayout(new BorderLayout());
    
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    
    // Create text field and add to panel (above the image)
    textField = new JTextField(name);
    textField.setEditable(false); // Make text field read-only
    panel.add(textField, BorderLayout.NORTH);
    
    // Load the image
    try {
      /*image = ImageIO.read(new File(imagePath));
      Image scaledImage = image.getScaledInstance(50,50, Image.SCALE_SMOOTH);
      setIcon(new ImageIcon(scaledImage)); // Set the image as icon of the JLabel
      */
      image = ImageIO.read(new File(imagePath));
      Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
      panel.add(imageLabel, BorderLayout.CENTER); // Add the image to the center of the panel
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    add(panel, BorderLayout.CENTER);
    
    // Set label properties
    panel.setOpaque(false);
    setBackground(Color.white);
    
    //textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height));
    //panel.setPreferredSize(new Dimension(50, 50 + textField.getPreferredSize().height));
    
    // Create popup menu with options
    popupMenu = new JPopupMenu();
    JMenuItem option1 = new JMenuItem("Check/Save");
    JMenuItem option2 = new JMenuItem("Heal");
    JMenuItem option3 = new JMenuItem("Damage");
    JMenuItem option4 = new JMenuItem("Attacks");
    JMenuItem option5 = new JMenuItem("Spells");
    JMenuItem option6 = new JMenuItem("AC");
    popupMenu.add(option1);
    popupMenu.add(option2);
    popupMenu.add(option3);
    popupMenu.add(option4);
    popupMenu.add(option5);
    popupMenu.add(option6);
    
    // Add action listeners to menu items
    option1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JPopupMenu subMenu = new JPopupMenu();
        JMenuItem subOption1 = new JMenuItem("Strength");
        JMenuItem subOption2 = new JMenuItem("Dexterity");
        JMenuItem subOption3 = new JMenuItem("Constitution");
        JMenuItem subOption4 = new JMenuItem("Intelligence");
        JMenuItem subOption5 = new JMenuItem("Wisdom");
        JMenuItem subOption6 = new JMenuItem("Charisma");
        
        subMenu.add(subOption1);
        subMenu.add(subOption2);
        subMenu.add(subOption3);
        subMenu.add(subOption4);
        subMenu.add(subOption5);
        subMenu.add(subOption6);
        
        subOption1.addActionListener (new ActionListener () {
          @Override
          public void actionPerformed (ActionEvent e) {
            save (0);
          }
        });
        
        subOption2.addActionListener (new ActionListener () {
          @Override
          public void actionPerformed (ActionEvent e) {
            save (1);
          }
        });
        
        subOption3.addActionListener (new ActionListener () {
          @Override
          public void actionPerformed (ActionEvent e) {
            save (2);
          }
        });
        
        subOption4.addActionListener (new ActionListener () {
          @Override
          public void actionPerformed (ActionEvent e) {
            save (3);
          }
        });
        
        subOption5.addActionListener (new ActionListener () {
          @Override
          public void actionPerformed (ActionEvent e) {
            save (4);
          }
        });
        
        subOption6.addActionListener (new ActionListener () {
          @Override
          public void actionPerformed (ActionEvent e) {
            save (5);
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
            System.out.println ("Healed " + number + " hp. " + currHealth + "/" + maxHealth);
            
            if (currHealth > 0) {
              textField.setText(name);
            }
            
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
            System.out.println ("Took " + number + " damage. " + currHealth + "/" + maxHealth);
            
            if (currHealth == 0) {
              textField.setText ("dead");
            }
            else {
              textField.setText(name);
            }
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
    
    option6.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(Character.this, "AC: " + ac);
      }
    });
      
    
    // Add mouse listeners
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  
  public Character (String imagePath, String n, int h, int a, Attack [] att, Spell [] sp, int str, int dex, int cons, int intel, int wis, int rizz) {
    this (imagePath, n, h, a, att, sp);
    
    stats[0] = str;
    stats[1] = dex;
    stats[2] = cons;
    stats[3] = intel;
    stats[4] = wis;
    stats[5] = rizz;
  }
  
  public int rollInitiative () {
    Random random = new Random();
    int randomNumber = random.nextInt(20) + 1;
    
    System.out.println ("Rolled: " + randomNumber + " + " + initiativeBonus);
    
    return randomNumber + initiativeBonus;
  }
  
  public void setInitiativeBonus (int b) {
    initiativeBonus = b;
  }
  
  public String getName () {
    return name;
  }
  
  private void save (int type) {
    Random random = new Random();
    int randomNumber = random.nextInt(20) + 1;
    
    int bonus = (stats[type] - 10) / 2;
    
    System.out.println ("Rolled: " + randomNumber + " + " + bonus);
    JOptionPane.showMessageDialog(Character.this, "Rolled: " + randomNumber + " + " + bonus);
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