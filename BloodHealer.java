import java.awt.event.*;
import java.util.*;

public class BloodHealer extends Character implements MouseListener {
  
  
  public BloodHealer (String imagePath, String n, int level) {
    
    super (imagePath, n, 27, 14, new Attack [1], new Spell [1], 12, 10, 14, 14, 16, 14);
    
    ArrayList<Attack> a = new ArrayList<Attack> ();
    a.add(new Attack ("Unarmed Strike", 1, "1d4", 0, ""));
    
    ArrayList<Spell> s = new ArrayList<Spell> ();
    s.add(new Spell ("Transfer Blood", 4, "1d8", "1d8+4 of health moves from one creature to another. Half dmg if const save > 12"));
    
    attackList = a;
    spellList = s;
    
  }
  
}