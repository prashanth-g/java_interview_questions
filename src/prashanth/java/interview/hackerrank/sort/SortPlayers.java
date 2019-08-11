package prashanth.java.interview.hackerrank.sort;

import java.util.Arrays;
import java.util.Comparator;
import prashanth.java.interview.hackerrank.sort.SortPlayers.Player;

public class SortPlayers {

  public static void main(String[] args) {

    Player p1 = new Player("amy", 100);
    Player p2 = new Player("david", 100);
    Player p3 = new Player("heraldo", 50);
    Player p4 = new Player("aakansha", 75);

    Player[] playerArray = new Player[4];
    playerArray[0] = p1;
    playerArray[1] = p2;
    playerArray[2] = p3;
    playerArray[3] = p4;

    Checker checker = new Checker();

    Arrays.sort(playerArray, checker);

    for (int i = 0; i < playerArray.length; i++) {
      System.out.println(playerArray[i]);
    }
  }

  static class Player {

    String name;
    int score;

    public Player(String name, int score) {
      this.name = name;
      this.score = score;
    }

    @Override
    public String toString() {
      return "[" + this.name + "-" + this.score + "]";
    }
  }
}

class Checker implements Comparator<Player> {
  @Override
  public int compare(Player a, Player b) {
    if(b.score == a.score) {
      return a.name.compareTo(b.name);
    } else {
      return b.score - a.score;
    }
  }
}

