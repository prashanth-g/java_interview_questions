package prashanth.java.interview.hackerrank.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LuckBalance {

  public static void main(String[] args) {
    int[][] arr = {{5, 1}, {4, 0}, {6, 1}, {2, 1}, {8, 0}};
    int importantContestsBalance = 2;
    System.out.println(luckBalance(importantContestsBalance, arr));
  }

  static int luckBalance(int k, int[][] contests) {
    Arrays.sort(contests, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
      }
    });

    int importantExams = 0;
    for (int i = 0; i < contests.length; i++) {
      importantExams += contests[i][1];
    }

    int luckBalance = 0;
    for (int i = 0; i < contests.length; i++) {
      luckBalance += contests[i][0];
    }

    if (k < importantExams) {
      for (int i = 0; i < contests.length; i++) {
        if (contests[i][1] == 1) {
          importantExams--;
          luckBalance -= 2 * contests[i][0];
        }
        if (importantExams == k) {
          break;
        }
      }
    }

    return luckBalance;
  }
}
