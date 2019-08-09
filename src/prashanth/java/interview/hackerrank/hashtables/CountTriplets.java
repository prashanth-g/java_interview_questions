package prashanth.java.interview.hackerrank.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

  public static void main(String[] args) {
    List<Long> arr = Arrays.asList(1l, 5l, 5l, 25l, 125l);
    long r = 5;
    System.out.println(countTriplets(arr, r));
  }

  static long countTriplets(List<Long> arr, long r) {
    Map<Long, Long> map1 = new HashMap();
    Map<Long, Long> map2 = new HashMap();
    long count = 0;
    for (int i = arr.size() - 1; i >= 0; i--) {
      long a = arr.get(i);

      if (map2.containsKey(
          a * r)) { // if the map already has the number to form a triplet
        count += map2.get(a * r);
      }

      if (map1.containsKey(a * r)) {
        long c = map1.get(a * r);
        map2.put(a, map2.getOrDefault(a, 0L) + c);
      }

      map1.put(a, map1.getOrDefault(a, 0L) + 1); // add all numbers
    }
    return count;
  }

  static long countTripletsN3(List<Long> arr, long r) {
    long tripletCount = 0;
    for (int i = 0; i < arr.size(); i++) {
      Long initialNumber = arr.get(i);
      for (int j = i + 1; j < arr.size(); j++) {
        long numberToCompare = initialNumber;
        int numbersFound = 1;
        for (int k = j + 1; k < arr.size(); k++) {
          if (numbersFound == 1) {
            if (numberToCompare == (arr.get(j)) / r) {
              numbersFound++;
              numberToCompare = arr.get(j);
            }
          }
          if (numbersFound == 2) {
            if (numberToCompare == (arr.get(k)) / r) {
              tripletCount++;
            }
          }
        }
      }
    }
    return tripletCount;
  }

}
