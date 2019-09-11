package prashanth.java.interview.hackerrank.sort;

public class CountingInversions {

  public static void main(String[] args) {
    int[] arr = { 2,1,3,1,2 };
    System.out.println(countInversions(arr));
  }
  // Complete the countInversions function below.
  static long countInversions(int[] arr) {
    long swaps = mergesort(arr, new int[arr.length], 0, arr.length - 1);
    return swaps;
  }

  static long mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
    if(leftStart >= rightEnd) {
      return 0;
    }

    int middle = (leftStart + rightEnd) / 2;
    long inversions = mergesort(array, temp, leftStart, middle) +
        mergesort(array, temp, middle + 1, rightEnd) +
        mergeHalves(array, temp, leftStart, rightEnd);
    return inversions;
  }

  static long mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
    int leftEnd = (rightEnd + leftStart) / 2;
    int rightStart = leftEnd + 1;
    int size = rightEnd  - leftStart + 1;
    long inversions = 0;
    int left = leftStart;
    int right = rightStart;
    int index = leftStart;

    while(left <=  leftEnd && right <= rightEnd) {
      if(array[left] <= array[right]) {
        temp[index] = array[left];
        left++;
      } else {
        temp[index] = array[right];
        inversions += (leftEnd - left + 1);
        right++;
      }

      index++;
    }

    System.arraycopy(array, left, temp, index, leftEnd - left + 1);
    System.arraycopy(array, right, temp, index, rightEnd - right + 1);
    System.arraycopy(temp, leftStart, array, leftStart, size);

    return inversions;
  }
}
