import java.awt.event.*;

public class BloodFighter extends Character implements MouseListener {
  
  
  public BloodFighter (String imagePath, String n, int level) {
    
    super (imagePath, n, 27, 14, new Attack [1], new Spell [1], 12, 10, 14, 14, 16, 14);
    
    Attack a [] = {new Attack ("Unarmed Strike", 1, "1d4", 0, "")};
    
    Spell s [] = {new Spell ("Transfer Blood", 4, "1d8", "1d8+4 of health moves from one creature to another. Half dmg if const save > 12")};
    
    attackList = a;
    spellList = s;
    
  }
  
}