import java.awt.event.*;

public class Error extends Character implements MouseListener {
  
  public Error () {
    super ("error.png", "error", -1, -1, new Attack [0], new Spell [0], 0);
    System.out.println ("Something went wrong");
  }
}