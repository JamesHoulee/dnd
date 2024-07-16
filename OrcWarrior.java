import java.awt.event.*;

public class OrcWarrior extends Character implements MouseListener {
  
  
  public OrcWarrior (String imagePath, String n, int level, boolean isTank) {
    
    super (imagePath, n, 40, 16, new Attack [1], new Spell [1], 16, 8, 14, 8, 10, 8);
    
    Attack a [] = new Attack [2];
    a[0] = new Attack ("Unarmed Strike", 1, "1d4", 4, "");
     
     if (!isTank) {
      a[1] = new Attack ("Sword", 4, "1d10", 4, "");
    }
    else {
      a[1] =  new Attack ("Sword", 3, "1d8", 4, "");
      ac = 19;
    }
    
    attackList = a;
    
  }
  
}