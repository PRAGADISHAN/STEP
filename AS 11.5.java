import java.util.Arrays;
public class DiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int v : rolls) {
            if (v >= 1 && v <= 6) {
                count[v]++;
            }
        }
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + " ");
        }
        System.out.println();
        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[idx++] = v;
            }
        }
        System.out.println("Sorted: " + Arrays.toString(sorted));
        return sorted;
    }
    public static void main(String[] args) {
        int[] r1 = {4, 1, 6, 4, 2, 1, 4};
        diceSort(r1);
    }
}