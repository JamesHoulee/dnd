import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ClickableImage extends JLabel implements MouseListener, MouseMotionListener {
    private int mouseX, mouseY; // Variables to store the mouse coordinates
    private int X = 100, Y = 100; // Initial position of the circle
    private int imageWidth, imageHeight;
    private BufferedImage image;
     
    private boolean pressed = false;

    public ClickableImage() {
        try {
            image = ImageIO.read(new File("Gabe.png")); // Replace "image.png" with your image file path
            imageWidth = image.getWidth();
            imageHeight = image.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        setOpaque(true);
        setBackground(Color.white);
        
        // Add mouse listeners
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the image
        if (image != null) {
            g.drawImage(image, X, Y, this);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Check if the mouse click is inside the circle
      
      if (!pressed) {
        if (e.getX() >= X && e.getX() <= X+imageWidth && e.getY() >= Y && e.getY() <= Y + imageHeight) {
          pressed = true;
        }
        else {
          pressed = false;
        }
      }
      else {
        X = e.getX();
        Y = e.getY();
        pressed = false;
        repaint ();
      }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /*// Update circle position while dragging
        circleX = e.getX() - mouseX;
        circleY = e.getY() - mouseY;
        repaint(); // Repaint the panel to update the circle's position
        */
    }

    // Other mouse listener methods (not used in this example)
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Clickable Image");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new ClickableImage());
                frame.pack();
                frame.setLocationRelativeTo(null); // Center the frame
                frame.setVisible(true);
            }
        });
    }*/
}