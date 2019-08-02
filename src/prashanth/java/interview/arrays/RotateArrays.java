package prashanth.java.interview.arrays;

public class RotateArrays {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int leftShift = 4;
    int[] rotated = rotLeft(arr, leftShift);
    for (int i = 0; i < rotated.length; i++) {
      if(i > 0) {
        System.out.print(" ");
      }
      System.out.print(rotated[i]);
    }
  }

  static int[] rotLeft(int[] a, int d) {
    int[] resultArray = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      int data = a[i];
      int toBeMoved = (i - d) < 0 ? (i - d) + a.length : (i - d);
      resultArray[toBeMoved] = data;
    }
    return resultArray;
  }

}
