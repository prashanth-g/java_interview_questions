package prashanth.java.interview.hackerrank.sort;

import java.io.IOException;
import java.util.Arrays;

public class Toys {

  static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int totalExpense = 0;
    int toys = 0;
    for (int i = 0; i < prices.length; i++) {
      if(totalExpense + prices[i] > k) {
        break;
      } else {
        totalExpense += prices[i];
        toys++;
      }
    }
    return toys;
  }

  public static void main(String[] args) throws IOException {
    int[] priceList = {1, 12, 5, 111, 200, 1000, 10};
    int totalMoney =  50;
    System.out.println(maximumToys(priceList, totalMoney));
  }
}
