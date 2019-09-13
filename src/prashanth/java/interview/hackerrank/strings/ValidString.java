package prashanth.java.interview.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidString {

  public static void main(String[] args) {
    String s = "aabbc";
    System.out.println(isValid(s));
  }

  static String isValid(String s) {

    HashMap<Character, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      freqMap.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
    }

    Integer max = freqMap.values().stream()
        .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .get()
        .getKey();

    long anomaliesCount = freqMap.entrySet().stream()
        .filter(v -> !v.getValue().equals(max))
        .count();

    if(anomaliesCount != 0) {
      if(anomaliesCount > 1) {
        return "NO";
      } else {
        Integer anomaly = freqMap.entrySet().stream()
            .filter(v -> v.getValue() != max)
            .findFirst()
            .get()
            .getValue();
        if(anomaly - 1 == max || anomaly - 1 == 0) {
          return "YES";
        } else {
          return "NO";
        }
      }
    }

    return "YES";
  }
}
