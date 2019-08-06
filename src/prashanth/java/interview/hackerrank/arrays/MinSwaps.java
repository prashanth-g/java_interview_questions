package prashanth.java.interview.hackerrank.arrays;

public class MinSwaps {

  public static void main(String[] args) {
    int[] arr = {2, 1, 5, 3, 4};
    System.out.println(minimumSwaps(arr));
  }

  static int minimumSwaps(int[] arr) {
    int swapCount = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == i + 1) { // no swap
        continue;
      } else {
        int temp = arr[i];
        arr[i] = arr[temp - 1];
        arr[temp - 1] = temp;
        swapCount++;
        i--;
      }
    }
    return swapCount;
  }
}
