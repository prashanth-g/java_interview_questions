package prashanth.java.interview.hackerrank.strings;

/**
 * LCS as per https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */
public class LCS {

  public static void main(String[] args) {
    String s1 = "HARRY";
    String s2 = "SALLY";

    System.out.println("\n Length of Longest Common Subsequence: " +getLCSLength(s1, s2));
  }

  static int getLCSLength(String s1, String s2) {
    int size = s1.length() + 1;
    int[][] matrix = new int[size][size];
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          matrix[i + 1][j + 1] = 1 + matrix[i][j];
        } else {
          matrix[i + 1][j + 1] = java.lang.Math
              .max(matrix[i][j + 1], matrix[i + 1][j]);
        }
        System.out.print("\t " + matrix[i + 1][j + 1]);
      }
      System.out.print("\n ");
    }

    return matrix[s1.length()][s2.length()];
  }
}
