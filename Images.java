import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SpringLayout;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.io.File;
import java.awt.Toolkit;
import java.awt.Image;

/**
 * The Images class is a subclass of the JLabel class. It imports an image with
 * a specified name to be used in the program. The image is then added to a
 * JLabel, which itself is added to the class.
 * 
 * <p>
 * <b>Instance Variables: </b>
 * <p>
 * <b>imageWidth </b> This variable represents the width of the image
 * <p>
 * <b>imageHeight </b> This variable represents the height of the image
 * <p>
 * <b>layout </b> This variable represents the layout of the JLabel
 * <p>
 * <b>image </b> This variable represents an object of the BufferedImage class
 * <p>
 * <b>imageLabel </b> This variable represents the image on a JLabel
 * <p>
 * 
 * @author James Houle and Juan Diego Castano
 * @Version 1 05.28.19
 */
public class Images extends JLabel {

  private int imageWidth, imageHeight;
  private SpringLayout layout;
  private BufferedImage image;
  private JLabel imageLabel;
  
  private Boolean isBackground;

  /**
   * This is the constructor for the Images class. It sets the image width and
   * height to the provided values and sets the layout of the class to be a spring
   * layout. Then it tries to read an image using the provided name of the file.
   * It then adds the image to imageLabel which is instantiated with the
   * parameters of a new ImageIcon. This label is then added to the class.
   * 
   * @param img       is a String object that contains the location of the image
   *                  file
   * @param imgWidth  contains the width of the image
   * @param imgHeight contains the height of the image
   */
  public Images(String img) {
    
    isBackground = true;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    imageWidth = screenSize.width;
    imageHeight = screenSize.height;

    layout = new SpringLayout();
    setLayout(layout);

    setVisible(true);

    // This block of code was modified based on the code from
    // https://github.com/HCastano/FelixGame/blob/master/src/felixgame/SplashScreen.java
    try {
      image = ImageIO.read(new File(img));
      Image scaledImage = image.getScaledInstance((int) (9 * imageHeight / 10),(int) (9 * imageHeight / 10), Image.SCALE_SMOOTH);
      imageLabel = new JLabel(new ImageIcon(scaledImage));
      add(imageLabel);
    } catch (IOException e) {
    }
    // End of cited code
  }
  
  public Images(String img, int imgWidth, int imgHeight) {

    isBackground = false;
    
    imageWidth = imgWidth;
    imageHeight = imgHeight;

    layout = new SpringLayout();
    setLayout(layout);

    setVisible(true);
    
    try {
      image = ImageIO.read(new File(img));
      Image scaledImage = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
      imageLabel = new JLabel(new ImageIcon(scaledImage));
      add(imageLabel);
    } catch (IOException e) {
    }
  }

  /**
   * The getPreferredSize method returns the dimensions for the image as specified
   * when the Images object was instantiated
   * 
   * @return the dimensions of the image
   */
  @Override
  public Dimension getPreferredSize() {
    // so that our GUI is big enough
    
    if (isBackground) {
      return new Dimension((int) (9 * imageHeight / 10),(int) (9 * imageHeight / 10));
    }
    return new Dimension(imageWidth, imageHeight);
  }
}