import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;

public class BloodElf extends Character implements MouseListener {
  
  public BloodElf(String imagePath, String n, int h, int a, Attack [] att, Spell [] sp) {
    
    super (imagePath, n, h, a, att, sp);
    
  }
  
  /*@Override
  public void attacks (ActionEvent e) {
    attack = new JPopupMenu();
    JMenuItem option1 = new JMenuItem("A1");
    JMenuItem option2 = new JMenuItem("A2");
    
    attack.add(option1);
    attack.add(option2);
  }*/
  
  /*@Override
  public void spells (ActionEvent e) {
    
    JMenuItem option1 = new JMenuItem("S1");
    JMenuItem option2 = new JMenuItem("S2");
    
    spell.add(option1);
    spell.add(option2); 
    
    
  }*/
  
}