package prashanth.java.interview.hackerrank.warmup;

public class JumpingClouds {

  public static void main(String[] args) {
    String cloudsString = "0 0 0 0 1 0";
    String[] cloudStringArray = cloudsString.split(" ");
    int[] clouds = new int[cloudStringArray.length];
    for (int i = 0; i < cloudStringArray.length; i++) {
      clouds[i] = Integer.parseInt(cloudStringArray[i]);
    }
    System.out.println("Total Jumps: " + jumpCalculator(0, clouds));
  }

  static int jumpCalculator(int cPos, int[] clouds) {
    int length = clouds.length;
    if(length == 0 || cPos == length - 1) {
      return 0;
    }

    if(cPos + 2 < length && clouds[cPos + 2] != 1) {
      cPos = cPos + 2;
      return 1 + jumpCalculator(cPos, clouds);
    } else {
      cPos = cPos + 1;
      return 1 + jumpCalculator(cPos, clouds);
    }
  }

}
