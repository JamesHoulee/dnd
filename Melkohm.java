import java.awt.event.*;
import java.util.*;

public class Melkohm extends Character implements MouseListener {
  
  public Melkohm(String imagePath, int level) {

    super (imagePath, "Melkohm", 48, 17, new Attack [1], new Spell [1]);
    
    ArrayList<Attack> a = new ArrayList<Attack> ();
    a.add (new Attack ("Battleaxe", 2, "1d8", 4, "Swing the Axe!"));
    a.add (new Attack ("Unarmed Strike", 2, "0d4", 3, "Strike!"));
    
    ArrayList<Spell> s = new ArrayList<Spell> ();
    s.add (new Spell ("Cure Wounds", 0, "1d8", "Heal for amount rolled."));
    
    attackList = a;
    spellList = s;
    
  }
  
}