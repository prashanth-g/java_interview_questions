package prashanth.java.interview.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsecutiveOnesCount {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String binaryString = Integer.toBinaryString(n);
        HashSet<Integer> maxBinary = (HashSet<Integer>) Arrays.stream(binaryString.split("0"))
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .collect(Collectors.toSet());
        System.out.println(maxBinary.iterator().next());
        scanner.close();
    }
}
