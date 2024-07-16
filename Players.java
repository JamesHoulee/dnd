import java.awt.event.*;

public class Players extends Character implements MouseListener {
  
  public Players(String imagePath, String n, int h, int a, Attack [] att, Spell [] sp) {
    
    super (imagePath, n, h, a, att, sp);
    
  }
  
  public Players(String imagePath, String n, int h, int a, Attack [] att, Spell [] sp, int str, int dex, int cons, int intel, int wis, int rizz) {
    
    super (imagePath, n, h, a, att, sp, str, dex, cons, intel, wis, rizz);
    
  }
  
}