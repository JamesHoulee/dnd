import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;
import java.awt.Image;


public class WorldObject extends JPanel implements MouseListener, MouseMotionListener {
  protected int mouseX, mouseY; // Variables to store the mouse coordinates
  private BufferedImage image; // Variable to store the image
  private JPopupMenu popupMenu;

  private String name;
  private String clickText;
  
  private int size;
  
  public WorldObject (String imagePath, String n, String text, int s) {
    
    name = n;
    clickText = text;
    
    size = s;
    
    setLayout(new BorderLayout());
    
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    
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
    JMenuItem option1 = new JMenuItem("Use");
    
    popupMenu.add(option1);
    
    // Add action listeners to menu item
    option1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(WorldObject.this, clickText);
      }
    });
      
    
    // Add mouse listeners
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  
  public WorldObject (String imagePath, String n, String text) {
    this (imagePath, n, text, 50);
  }
  
  public String getName () {
    return name;
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
    System.out.println (newX + ", " + newY);
  }
  
  // Other mouse listener methods (not used in this example)
  @Override
  public void mouseClicked(MouseEvent e) {
    if (SwingUtilities.isRightMouseButton(e)) {
      popupMenu.show(this, e.getX(), e.getY());
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