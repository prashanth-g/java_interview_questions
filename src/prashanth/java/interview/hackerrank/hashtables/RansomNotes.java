package prashanth.java.interview.hackerrank.hashtables;

import java.util.Enumeration;
import java.util.Hashtable;

public class RansomNotes {

  public static void main(String[] args) {
    String[] magazine = "give me one grand today night".split(" ");
    String[] notes = "give one grand today".split(" ");
    checkMagazine(magazine, notes);
  }

  static void checkMagazine(String[] magazine, String[] note) {
    // Set words and its count
    Hashtable<String, Integer> wordsCount = new Hashtable<>();
    for (String word : magazine) {
      if (wordsCount.get(word) == null) {
        wordsCount.put(word, 1);
      } else {
        wordsCount.put(word, wordsCount.get(word) + 1);
      }
    }

    Hashtable<String, Integer> notesCount = new Hashtable<>();
    for (String word : note) {
      if (notesCount.get(word) == null) {
        notesCount.put(word, 1);
      } else {
        notesCount.put(word, notesCount.get(word) + 1);
      }
    }

    Enumeration<String> enumeration = notesCount.keys();
    while (enumeration.hasMoreElements()) {
      String key = enumeration.nextElement();
      if (wordsCount.get(key) == null) {
        System.out.println("No");
        return;
      } else {
        if (notesCount.get(key) > wordsCount.get(key)) {
          System.out.println("No");
          return;
        }
      }
    }
    System.out.println("Yes");
  }
}
