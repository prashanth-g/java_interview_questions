package prashanth.java.interview.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;

public class SpecialStrings {

  public static void main(String[] args) {
    String s = "asasd";
    System.out.println(substrCount(s.length(), s));
  }

  // Naive O(n^2)
  static long substrCount(int n, String s) {
    long subStrCount = 0;

    for (int i = 0; i < s.length(); i++) {
      for (int j = 1; j <= s.length() - i; j++) {
        String str = s.substring(i, j + i);
        if (str.length() == 1) {
          subStrCount++;
        } else {
          HashMap<Character, Integer> charMap = new HashMap<>();
          for (int k = 0; k < str.length(); k++) {
            charMap.compute(str.charAt(k), (l, v) -> v == null ? 1 : v + 1);
          }
          // Special case 1
          if (charMap.size() == 2) {
            if (charMap.entrySet().stream().mapToInt(v -> v.getValue()).sum()
                > 2) {
              Map.Entry<Character, Integer> tempMap = charMap.entrySet()
                  .stream()
                  .min(Map.Entry.comparingByValue())
                  .get();

              int middle = str.length() % 2 == 0 ? (str.length() / 2 - 1)
                  : str.length() / 2;

              // If min is 1 and it is in the middle of String
              if (tempMap.getValue() == 1 && str.charAt(middle) == tempMap
                  .getKey()) {
                subStrCount++;
              }
            }
          } else if (charMap.size() == 1) {
            subStrCount++;
          }
        }
      }
    }
    return subStrCount;
  }

  // O(n)
  static long substrCountA(int n, String s) {
    long subStrCount = 0;
    for (int i = 0; i < n; i++) {

      int offset = 1;
      while (i - offset >= 0 &&
             i + offset < n &&
             s.charAt(i - offset) == s.charAt(i - 1) &&
             s.charAt(i + offset) == s.charAt(i - 1)) {
        subStrCount++;
        offset++;
      }

      int repeats = 0;
      while (i + 1 < n &&
             s.charAt(i) == s.charAt(i + 1)) {
        repeats++;
        i++;
      }
      subStrCount += repeats * (repeats + 1) / 2;
    }
    return subStrCount + n;
  }
}
