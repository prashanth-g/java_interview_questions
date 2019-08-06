package prashanth.java.interview.gfg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FindAnagramCount{

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int totalStrings = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int i = 0; i < totalStrings; i++) {
      String givenString = scanner.nextLine();
      String anagramString = scanner.nextLine();
      System.out.println(findOccurencesOfAnagrams(givenString, anagramString));
    }
    scanner.close();
  }

  static int findOccurencesOfAnagrams(String givenString,
      String anagramString) {
    int matchingAnagramCount = 0;
    Map<Character, Integer> anagramStringMap = getCharacterMap(anagramString);
    for (int i = 0; i <= givenString.length() - anagramString.length(); i++) {
      int charMatchCount = 0;
      String subString = givenString.substring(i, i + (anagramString.length()));
      Map<Character, Integer> subStringMap = getCharacterMap(subString);
      Iterator<Character> iterator = subStringMap.keySet().iterator();
      while (iterator.hasNext()) {
        Character c = iterator.next();
        if (anagramStringMap.get(c) != subStringMap.get(c)) {
          break;
        } else if (anagramStringMap.get(c) == null) {
          break;
        } else {
          charMatchCount += anagramStringMap.get(c);
        }
      }
      if (charMatchCount == anagramString.length()) {
        matchingAnagramCount++;
      }
    }
    return matchingAnagramCount;
  }

  static Map<Character, Integer> getCharacterMap(String str) {
    Map<Character, Integer> map = new HashMap<>();
    char[] charA = str.toCharArray();
    for (char c : charA) {
      if (map.get(c) != null) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    return map;
  }
}
