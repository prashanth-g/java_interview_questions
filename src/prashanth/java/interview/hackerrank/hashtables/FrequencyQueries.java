package prashanth.java.interview.hackerrank.hashtables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrequencyQueries {

  public static void main(String[] args) {
    int[][] queries = new int[4][2];
    String[] qString = { "3,4", "2,1003", "1,16", "3,1"};
    for (int i = 0; i < 4; i++) {
      String[] str = qString[i].split(",");
      for (int j = 0; j < 2; j++) {
        queries[i][j] = Integer.parseInt(str[j]);
      }
    }
    System.out.println(freqQuery(queries, 4));
  }

  static List<Integer> freqQuery (int[][] arr, int q)  {
    HashMap<Integer, Integer> valuesToCounts = new HashMap<>();
    HashMap<Integer, Set<Integer>> countsToValues = new HashMap<>();
    ArrayList<Integer> results = new ArrayList<>();
    int size = q;
    for (int i = 0; i < q; i++) {
      int[] query = arr[i];
      int operation = query[0];
      int number = query[1];
      int oldCount = valuesToCounts.getOrDefault(number, 0);
      int newCount;

      if (operation == 1) {
        newCount = oldCount + 1;
        valuesToCounts.put(number, newCount);

        if (countsToValues.containsKey(oldCount)) {
          countsToValues.get(oldCount).remove(number);
        }
        countsToValues.putIfAbsent(newCount, new HashSet<>());
        countsToValues.get(newCount).add(number);
      }

      if (operation == 2) {
        newCount = (oldCount > 1) ? oldCount - 1 : 0;
        valuesToCounts.put(number, newCount);

        if (countsToValues.containsKey(oldCount)) {
          countsToValues.get(oldCount).remove(number);
        }

        countsToValues.putIfAbsent(newCount, new HashSet<>());
        countsToValues.get(newCount).add(number);
      }

      if (operation == 3) {
        if (number > size) results.add(0);
        else {
          results.add((number == 0 || countsToValues.getOrDefault(number, Collections
              .emptySet()).size() > 0) ? 1 : 0);
        }
      }
    }
    return results;
  }
}
