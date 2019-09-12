package prashanth.java.interview.hackerrank.strings;

public class AlternatingCharacters {

  public static void main(String[] args) {
    String s = "AAABBBAABB";
    System.out.println(alternatingCharacters(s));
  }

  static int alternatingCharacters(String s) {
    char[] chars = s.toCharArray();
    char currentLetter = chars[0];
    int currentLetterCount = 1;
    int lettersToBeRemoved = 0;
    for (int i = 1; i < chars.length; i++) {
      if(currentLetter == chars[i]) {
        currentLetterCount++;
      } else {
        currentLetter = chars[i];
        lettersToBeRemoved += currentLetterCount - 1;
        currentLetterCount = 1;
      }
    }
    if(currentLetterCount > 1) {
      lettersToBeRemoved += currentLetterCount - 1;
    }
    return lettersToBeRemoved;
  }
}
