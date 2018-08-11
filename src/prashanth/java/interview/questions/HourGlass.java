package prashanth.java.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HourGlass {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Expected input size
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        List<Integer> maxSum = new ArrayList<>();

        for (int k = 0; k < arr.length - 2; k++) {
            int hourGlassTop;
            int hourGlassCenter;
            int hourGlassBottom;
            for (int l = 0; l < arr[k].length - 2; l++) {
                hourGlassTop = arr[k][l] + arr[k][l + 1] + arr[k][l + 2];
                hourGlassCenter = arr[k + 1][l + 1];
                hourGlassBottom = arr[k + 2][l] + arr[k + 2][l + 1] + arr[k + 2][l + 2];

                maxSum.add(hourGlassTop + hourGlassCenter + hourGlassBottom);
            }
        }
        System.out.println(Collections.max(maxSum));
    }
}
