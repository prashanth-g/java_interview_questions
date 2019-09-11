package prashanth.java.interview.hackerrank.strings;

import java.util.stream.IntStream;

public class MakingAnagrams {

  public static void main(String[] args) {
    String a = "fcrxzwscanmligyxyvym";
    String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

    System.out.println(makeAnagram(a, b));
  }

  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b) {
    int count = 0;

    int[] letters = new int[26];

    // Find difference between chars in both string
    a.chars().forEach(c -> { letters[c - 'a']++; });
    b.chars().forEach(c -> { letters[c - 'a']--; });

    // Just sum it
    count = IntStream.of(letters).map( i -> Math.abs(i)).sum();

    return count;
  }
}
