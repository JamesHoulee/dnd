import java.util.Random;

public class Spell {
  
  protected String name;
  protected int baseDmg;
  protected String diceDmg;
  protected String description;
  
  Spell (String n, int base, String dice, String desc) {
    name = n;
    baseDmg = base;
    diceDmg = dice;
    description = desc;
    
  }
  
  public String print () {
    return name + ": " + description;
  }
  
  private int roll (String dice) {
    Random random = new Random();
    int randomNumber = -1;
    int total = 0;
    
    
    int numRolls = Integer.parseInt(dice.substring (0,1));
    String type = dice.substring (1);
    
    System.out.print ("Rolled ");
    for (int i = 0; i < numRolls; i++) {
      if (type.compareTo ("d4") == 0) {
        randomNumber = random.nextInt(4) + 1;
        System.out.print (randomNumber);
        System.out.print (" + ");
      }
      total += randomNumber;
    }
    return total;
  }
  
  public int use () {

    int damage = roll(diceDmg) + baseDmg;
    System.out.print (baseDmg);
    System.out.print (" = ");
    System.out.println (damage);
    
    return damage;
  }
}
    