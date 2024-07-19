import java.util.*;

public class CharacterList {
  
  private String [] characterTypes = {
    "FemaleBH", //0
    "MaleBH",
    "Valentezna",
    "BloodOgre",
    "Melkohm",
    "Ogre", // 5
    "OrcWarrior", 
    "Players"};
  
  private int indexOf (String name) {
    for (int i = 0; i < characterTypes.length; i++) {
      if (characterTypes[i].compareTo (name) == 0) {
        return i;
      }
    }
    return -1;
  }
  
  public Character getCharacterType (String [] parameters) {
    int index = indexOf (parameters[1]);
    
    System.out.println (parameters);
    if (index == 0 || index == 1 || index == 2) {
      
      return new BloodHealer (parameters[3], parameters[2], Integer.parseInt (parameters[4]));
    }
    
    return new Error ();
  }
}
    