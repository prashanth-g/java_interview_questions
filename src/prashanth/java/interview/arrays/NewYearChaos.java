package prashanth.java.interview.arrays;

public class NewYearChaos {

  public static void main(String[] args) {
    int[] queue = {2, 1, 5, 3, 4};
    minimumBribes(queue);
  }

  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {
    int bribeCount = 0;

    for (int i = q.length - 1; i >= 0; i--) {
      if(q[i] - (1 + i) > 2) {
        System.out.println("Too chaotic");
        return;
      }

      for (int j = Math.max(0, q[i] - 2); j < i; j++) {
        if(q[j] > q[i]) {
          bribeCount++;
        }
      }
    }

    System.out.println(bribeCount);
  }
}
