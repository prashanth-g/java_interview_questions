package prashanth.java.interview.hackerrank.warmup;

public class RepeatedString {

  public static void main(String[] args) {
    long n = Long.parseLong("1000000000000");
    System.out.println(repeatedString("a", n));
  }

  static long repeatedString(String s, long n) {
    int charCount = getCharCount(s);
    long numberOfTimes = n / s.length();
    String remaingString = s.substring(0, (int) (n - numberOfTimes * s.length()));
    return numberOfTimes * charCount + getCharCount(remaingString);
  }

  private static int getCharCount(String s) {
    int charCount = 0;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == 'a') {
        charCount++;
      }
    }
    return charCount;
  }
}
