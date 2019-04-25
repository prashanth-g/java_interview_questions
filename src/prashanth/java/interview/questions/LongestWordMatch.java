package prashanth.java.interview.questions;

import java.util.Arrays;

// Find longest word in dictionary that is a subsequence of a given string
public class LongestWordMatch {

    public static void main(String[] args) {
        String stringSequence = "keauroonmra";
        String[] availableWords = {"able", "ale", "apple", "bale", "kangaroo", "abplee", "karma"};
        int maxLength = 0;
        String maxString = "";
        // Brute force - O(n^2)
        for (int i = 0; i < availableWords.length; i++) {
            char[] aChars = availableWords[i].toCharArray();
            char[] sChars = stringSequence.toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean traversed = true;
            for (int j = 0; j < aChars.length; j++) {
                boolean matched = false;
                int matchCount = 0;
                for (int k = 0; k < sChars.length; k++) {
                    if(aChars[j] == sChars[k]) {
                        sb.append(sChars[k]);
                        matched = true;
                        matchCount++;
                        break;
                    }
                }
                if(matched == true) {
                    sChars = Arrays.copyOfRange(stringSequence.toCharArray(), j+1,
                            stringSequence.toCharArray().length);
                } else if(matchCount == 0 && matched == false) {
                    traversed = false;
                    break;
                }
            }
            if(traversed) {
                if(sb.length() > maxLength) {
                    maxLength = sb.length();
                    maxString = sb.toString();
                }
            }
        }

        // Print max matching string - only one max match string
        System.out.println(maxString);
    }
}