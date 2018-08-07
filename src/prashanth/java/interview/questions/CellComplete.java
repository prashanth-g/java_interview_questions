package prashanth.java.interview.questions;

import java.util.ArrayList;
import java.util.List;

// Neighbour cells,Colony cells, Cells complete
public class CellComplete {

    public static void main(String[] args) {
        int[] cellStates = {1, 1, 0, 1, 1, 1, 1, 1, 0, 1};
        int days = 5;
        System.out.println(changeStates(cellStates, days));
    }

    private static List<Integer> changeStates(int[] states, int days) {

        List<Integer> newStates = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            newStates.clear();
            for (int j = 0; j < states.length; j++) {

                int previousCell, nextCell, activeStatus;

                if (j == 0) { // handle edge cases - initial cell
                    previousCell = 0;
                    nextCell = states[1];
                } else if (j == states.length - 1) { // handle edge cases - last cell
                    previousCell = states[states.length - 2];
                    nextCell = 0;
                } else {
                    previousCell = states[j - 1];
                    nextCell = states[j + 1];
                }

                if (previousCell == nextCell) {
                    activeStatus = 0;
                } else {
                    activeStatus = 1;
                }

                newStates.add(activeStatus);
            }

            // if `days` is more than one day refresh both states and newStates
            if (days > 1) {
                for (int k = 0; k < states.length; k++) {
                    states[k] = newStates.get(k);
                }
            }
        }
        return newStates;
    }
}
