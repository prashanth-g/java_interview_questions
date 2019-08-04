package prashanth.java.interview.arrays;

public class ArrayManipulation {

  public static void main(String[] args) throws Exception {

    int[][] queries = new int[3][3];
    int queryStringStartIndex = 0;
    String[] queryStrings = "1,2,100,2,5,100,3,4,100".split(",");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        queries[i][j] = Integer.parseInt(queryStrings[queryStringStartIndex++]);
      }
    }
    int n = 5;
    long result = arrayManipulation(n, queries);
    System.out.println(result);
  }

  // O(n^2)
  static long arrayManipulationWithCompleteArrayUpdate(int n, int[][] queries) {
    int[] resultArray = new int[n];
    for (int i = 0; i < queries.length; i++) {
      int startIndex = queries[i][0] - 1;
      int endIndex = queries[i][1] - 1;
      int numberToBeAdded = queries[i][2];
      for (int k = 0; k < resultArray.length; k++) {
        if (k >= startIndex && k <= endIndex) {
          resultArray[k] = resultArray[k] + numberToBeAdded;
        }
      }
    }

    long max = resultArray[0];
    for (int i = 1; i < resultArray.length; i++) {
      if (resultArray[i] > max) {
        max = resultArray[i];
      }
    }

    return max;
  }

  // O(n)
  static long arrayManipulation(int n, int[][] queries) {
    long[] resultArray = new long[n + 1];
    for (int i = 0; i < queries.length; i++) {
      int startIndex = queries[i][0];
      int endIndex = queries[i][1];
      int numberToBeAdded = queries[i][2];
      resultArray[startIndex] += numberToBeAdded;
      if (endIndex + 1 <= n) {
        resultArray[endIndex + 1] -= numberToBeAdded;
      }
    }

    long max = 0;
    int temp = 0;
    for (int i = 1; i < n; i++) {
      temp += resultArray[i];
      if (temp > max) {
        max = temp;
      }
    }
    return max;
  }
}
