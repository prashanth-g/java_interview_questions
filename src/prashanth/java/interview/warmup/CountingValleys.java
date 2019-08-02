package prashanth.java.interview.warmup;

public class CountingValleys {

    public static void main(String[] args) {
        int result = countingValleys(100, "DDUDUDDUDDUDDUUUUDUDDDUUDDUUDDDUUDDUUUUUUDUDDDDUDDUUDUUDUDUUUDUUUUUDDUDDDDUDDUDDDDUUUUDUUDUUDUUDUDDD"); // 5
        System.out.println("Total valleys: " + result);
    }

    static int countingValleys(int n, String s) {
        int sum = 0;
        int valleyStarted = 0;
        int totalValleys = 0;
        for (int i = 0; i < s.length(); i++) {
          if(s.charAt(i) == 'U') {
            sum += 1;
          } else {
            sum -= 1;
          }
  
          if(sum < 0) {
            valleyStarted = 1;
          }
  
          if(valleyStarted == 1 && sum == 0) {
            totalValleys += 1;
            valleyStarted = 0;
          }
        }
        return totalValleys;
      }
}