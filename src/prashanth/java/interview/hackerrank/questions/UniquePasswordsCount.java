package prashanth.java.interview.hackerrank.questions;

import java.util.*;

// Given array of passwords
// Swap the password chars positions(i,j) i+j % == 0
// For example {"abcd", "cdba"} is given,
//   take the second one and swap it with i + j % == 0 rule. i and j are character positions
//   swapping the "cdba" with the logic will make the string to "abcd" which is already there. So only one unique. So the program should return 1.
// So find the unique passwords count
class UniquePasswordsCount {

    public static void main(String[] args) {
        // Return unique passwords count
        String[] passwords = {"abcd", "cdab", "rdbc", "bcrd"};
        System.out.println(getMathcedPasswords(passwords));
    }

    private static int getMathcedPasswords(String[] passwords) {
        List<String> uniquePasswords = new ArrayList<>();
        for (String password : passwords) {
            if(uniquePasswords.size() == 0) {
                uniquePasswords.add(password);
            } else {
                // Swap the current with i+j % 2 == 0 logic
                String swappedPassword = swapChars(password);
                if(!uniquePasswords.contains(swappedPassword)) {
                    uniquePasswords.add(password);
                }
            }
        }
        return uniquePasswords.size();
    }

    private static String swapChars(String password) {
        List<Integer> usedPositions = new ArrayList<>();
        char[] passwordChars = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            if(!usedPositions.contains(i)) {
                usedPositions.add(i);
                if(i+2 <  password.length()) {
                    char temp = passwordChars[i];
                    passwordChars[i] = passwordChars[i+2];
                    passwordChars[i+2] = temp;
                    usedPositions.add(i+2);
                }
            }
        }
        return new String(passwordChars);
    }
}
