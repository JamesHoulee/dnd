import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;
import java.awt.Image;

import java.util.Scanner;
import java.io.FileNotFoundException;

import java.util.*;


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
  
  protected int size;
  
  private int initiativeBonus;
  
  private int [] stats; //strength, dexterity, constitution, intelligence, wisdom, charisma
  
  protected ArrayList<Attack> attackList;
  protected ArrayList<Spell> spellList;

  
  public Character(String imagePath, String n, int h, int a, Attack [] att, Spell [] sp, int s) {
    name = n;
    maxHealth = h;
    currHealth = h;
    ac = a;
    
    attackList = new ArrayList<Attack> ();
    spellList = new ArrayList<Spell> ();
    
    for (int i = 0; i < att.length; i++) {
      attackList.add (att[i]);
    }
    for (int i = 0; i < sp.length; i++) {
      spellList.add (sp[i]);
    }
    
    size = s;
    
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
      image = ImageIO.read(new File(imagePath));
      Image scaledImage = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
      JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
      panel.add(imageLabel, BorderLayout.CENTER); // Add the image to the center of the panel
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    add(panel, BorderLayout.CENTER);
    
    // Set label properties
    panel.setOpaque(false);
    setBackground(Color.white);

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
  
  public Character (String imagePath, String n, int h, int a, Attack [] att, Spell [] sp, int str, int dex, int cons, int intel, int wis, int rizz, int s) {
    this (imagePath, n, h, a, att, sp, s);
    
    stats[0] = str;
    stats[1] = dex;
    stats[2] = cons;
    stats[3] = intel;
    stats[4] = wis;
    stats[5] = rizz;
  }
  
  public Character (String imagePath, String n, int h, int a, Attack [] att, Spell [] sp, int str, int dex, int cons, int intel, int wis, int rizz) {
    this (imagePath, n, h, a, att, sp, str, dex, cons, intel, wis, rizz, 50);
  }
  
  public Character(String imagePath, String n, int h, int a, Attack [] att, Spell [] sp) {
    this (imagePath, n, h, a, att, sp, 50);
  }
  
  public Character (String fileName, String [] charInfo) {
    this (charInfo[0], charInfo[1], 0, 0, new Attack [0], new Spell [0], Integer.parseInt(charInfo[2]));
    
    String delim = "[,]";
    
    try {
      File myFile = new File (fileName);
      Scanner myReader = new Scanner (myFile);
      
      // skip the first line
      String input = myReader.nextLine();
      
      // gets hp,ac
      input = myReader.nextLine ();
      charInfo = input.split(delim);
      maxHealth = Integer.parseInt (charInfo[0]);
      currHealth = Integer.parseInt (charInfo[0]);
      ac = Integer.parseInt (charInfo[1]);
      
      
      // gets stats
      input = myReader.nextLine ();
      String [] s = input.split (delim);
      for (int i = 0; i < 6; i++) {
        stats[i] = Integer.parseInt (s[i]);
      }
      
      // gets attacks
      String attackInfo;
      
      if (myReader.hasNextLine ()) {
        input = myReader.nextLine ();
      
        while (myReader.hasNextLine() && input.charAt(0) == 'a') {
          System.out.println (input);
          
          String [] attInfo = input.split(delim);
          attackList.add(new Attack (attInfo[1], Integer.parseInt(attInfo[2]), attInfo[3], Integer.parseInt(attInfo[4]), attInfo[5]));
          
          input = myReader.nextLine ();
          
          if (!myReader.hasNextLine()) {
            attInfo = input.split(delim);
            attackList.add(new Attack (attInfo[1], Integer.parseInt(attInfo[2]), attInfo[3], Integer.parseInt(attInfo[4]), attInfo[5]));
          }
        }
        
        while (myReader.hasNextLine() && input.charAt(0) == 's') {
          System.out.println (input);
          
          String [] spInfo = input.split(delim);
          spellList.add(new Spell (spInfo[1], Integer.parseInt(spInfo[2]), spInfo[3], spInfo[4]));
          
          input = myReader.nextLine ();
          
          if (!myReader.hasNextLine() && input.length() != 0) {
            spInfo = input.split(delim);
            spellList.add(new Spell (spInfo[1], Integer.parseInt(spInfo[2]), spInfo[3], spInfo[4]));
          }
        }
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  public int rollInitiative () {
    Random random = new Random();
    int randomNumber = random.nextInt(20) + 1;
    
    System.out.println ("Initiative: " + randomNumber + " + " + initiativeBonus);
    
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
    System.out.println (attackList.get(Integer.parseInt (j.getText().substring (0,1))).getName ());
    return attackList.get(Integer.parseInt (j.getText().substring (0,1))).use();
  }
  
  private int rollToHit (JMenuItem j) {
    return attackList.get(Integer.parseInt (j.getText().substring (0,1))).hit();
  }
  
  public void attacks (ActionEvent e) {
    attack = new JPopupMenu();
    
    for (int i = 0; i < attackList.size(); i++) {
      final JMenuItem item = new JMenuItem (i + ". " + attackList.get(i).print());
      
      item.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
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
    System.out.println (spellList.get(Integer.parseInt (j.getText().substring (0,1))).getName ());
    return spellList.get(Integer.parseInt (j.getText().substring (0,1))).use();
  }
  
  public void spells (ActionEvent e) {
    spell = new JPopupMenu();
    
    for (int i = 0; i < spellList.size(); i++) {
      final JMenuItem item = new JMenuItem (i + ". " + spellList.get(i).print());
      
      item.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
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