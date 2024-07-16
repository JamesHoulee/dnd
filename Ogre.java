import java.awt.event.*;

public class Ogre extends Character implements MouseListener {
  
  
  public Ogre (String imagePath, String n) {
    
    super (imagePath, n, 100, 15, new Attack [1], new Spell [1], 16, 12, 14, 14, 14, 8, 100);
    
    Attack a [] = {
      new Attack ("Pummel", 4, "2d6", 4, "Smacks with both hands"),
      new Attack ("Stomp", 2, "1d8", 4, "Hits everyone within 10ft"),
      new Attack ("Club", 5, "1d10", 4, "Hit everyone 10ft x 10ft in front"),
      new Attack ("ThrowClub", 5, "1d10", 4, "Hits everyone in a 10ft wide line. If roll > 14 dex, then dodged"),
      new Attack ("Grab", 0, "0d4", 0, "Grabs target if they roll < 14 dex. Once grabbed, must roll >= 14 strength to get out"),
      new Attack ("Toss", 6, "2d10", 20, "Tosses target up to 40ft. Roll dex >= 15 to take half dmg.")
    };
    
    attackList = a;
    
  }
  
}