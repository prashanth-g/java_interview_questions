package prashanth.java.interview.hackerrank.sort;

import java.util.Arrays;

public class FraudulantNotifications {

  public static void main(String[] args) {
    int[] expenditure = {5, 4, 2, 1, 3};
    int trailingDays = 4;

    System.out.println(activityNotifications(expenditure, trailingDays));
  }

  static int activityNotifications(int[] expenditure, int trailingDays) {
    int[] frequency = new int[6]; // Since expenditure range is 0 - 200
    int i = 0;
    int j = trailingDays; // Trailing day's current position

    // Generate Frequency table till the trailing days
    for (; i < j; i++) {
      frequency[expenditure[i]] += 1;
    }
    i = 0;

    int notifications = 0;

    // Median position in the trailing days
    int medianPosition = (trailingDays % 2 != 0) ? (trailingDays / 2) + 1 : trailingDays / 2;

    while (j < expenditure.length) {
      double median = getMedian(frequency, trailingDays, medianPosition);
      if (expenditure[j] >= (median * 2)) {
        notifications += 1;
      }

      // Shift the trailing days positions by 1
      frequency[expenditure[i]] -= 1;
      frequency[expenditure[j]] += 1;
      i++;
      j++;
    }

    return notifications;
  }

  static double getMedian(int[] frequencyArray, int trailingDays, int medianPosition) {
    int count = 0, i = 0, j = 0;

    // count - gets the position of the element in the given array
    for (; count < medianPosition; i++) {
      count += frequencyArray[i];
    }

    j = i;
    i -= 1;
    // If count > medianPosition i.e. the given array consists same number
    //    which is more than the median position like {3,4,4,4,4,5} then return the number i
    // If trailing days is odd number then return the number at median with respect to the frequency table
    //    which is i
    if (count > medianPosition || trailingDays % 2 != 0) {
      return i;
    }

    // If consecutive numbers are not found(which is 0 in frequencyArray) in the given array then go till
    // you find a number. Then return the middle number between median position to the numbder found
    // which is (i + j) / 2
    for (; frequencyArray[j] == 0; j++) {
      ;
    }

    return (i + j) / 2d;
  }

  static int activityNotificationsArrayCopy(int[] expenditure, int d) {
    if (expenditure.length <= d) {
      return 0;
    }

    int numberOfExpenditureDays = expenditure.length - d;
    int startIndex = 0;
    int notifications = 0;
    for (int i = 0; i < numberOfExpenditureDays; i++) {
      int[] tempArray = new int[d];
      System.arraycopy(expenditure, startIndex, tempArray, 0, d);
      Arrays.sort(tempArray);
      int median = tempArray[ d / 2];
      if (expenditure[startIndex + d] >= 2 * median) {
        notifications++;
      }
      startIndex++;
    }

    return notifications;
  }
}
