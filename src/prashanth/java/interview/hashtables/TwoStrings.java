package prashanth.java.interview.hashtables;

import java.util.HashMap;
import java.util.Iterator;

public class TwoStrings {

  public static void main(String[] args) {
    System.out.println(twoStrings("hackerrankcommunity", "cdecdecdecde"));
  }

  static String twoStrings(String s1, String s2) {
    HashMap<Character, Integer> charCountA = new HashMap<>();
    HashMap<Character, Integer> charCountB = new HashMap<>();
    for (Character c : s1.toCharArray()) {
      if (charCountA.get(c) == null) {
        charCountA.put(c, 1);
      } else {
        charCountA.put(c, charCountA.get(c) + 1);
      }
    }

    for (Character c : s2.toCharArray()) {
      if (charCountB.get(c) == null) {
        charCountB.put(c, 1);
      } else {
        charCountB.put(c, charCountB.get(c) + 1);
      }
    }

    Iterator<Character> iterator = charCountA.keySet().iterator();
    String status = "No";
    while (iterator.hasNext()) {
      Character key = iterator.next();
      if (!charCountB.containsKey(key)) {
        continue;
      } else {
        status = "Yes";
      }
    }

    return status;
  }

  // Less memory, compute time with O(n)
  static String twoStringsChar(String s1, String s2) {
    String status = "No";
    for (int i = 97; i < (97 + 25); i++) {
      if (s1.indexOf(i) != -1 && s2.indexOf(i) != -1) {
        status = "Yes";
        break;
      }
    }
    return status;
  }
}
