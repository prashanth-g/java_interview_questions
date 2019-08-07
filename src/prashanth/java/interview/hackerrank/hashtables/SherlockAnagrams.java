package prashanth.java.interview.hackerrank.hashtables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SherlockAnagrams {

  public static void main(String[] args) {
    String str = "kkkk";
    System.out.println(sherlockAndAnagrams(str));
  }

  static int sherlockAndAnagrams(String str) {
    int temp = 1;
    String s1 = null;
    String s2 = null;
    int anagramCount = 0;
    for (int k = 1; k < str.length(); k++) {
      int increasedIndex = 0;
      for (int i = 0; i < str.length(); i++) {
        if (k + increasedIndex <= str.length()) {
          s1 = str.substring(i, k + increasedIndex);
          for (int j = i + 1; j < str.length(); j++) {
            if (j + k <= str.length()) {
              s2 = str.substring(j, j + k);
              // System.out.println("[" + s1 + "," + s2 + "]");
              if (isAngaram(s1, s2)) {
                anagramCount++;
              }
            }
          }
        }
        increasedIndex++;
      }
      temp++;
    }
    return anagramCount;
  }

  static boolean isAngaram(String s1, String s2) {
    Map<Character, Integer> mapS1 = getCharMap(s1);
    Map<Character, Integer> mapS2 = getCharMap(s2);
    Iterator<Character> iterator = mapS2.keySet().iterator();
    while (iterator.hasNext()) {
      Character c = iterator.next();
      if (mapS1.get(c) == null) {
        return false;
      } else if (mapS2.get(c) > mapS1.get(c)) {
        return false;
      }
    }
    return true;
  }

  static Map<Character, Integer> getCharMap(String s1) {
    Map<Character, Integer> charMap = new HashMap<>();
    for (Character c : s1.toCharArray()) {
      if (charMap.get(c) == null) {
        charMap.put(c, 1);
      } else {
        charMap.put(c, charMap.get(c) + 1);
      }
    }
    return charMap;
  }
}
