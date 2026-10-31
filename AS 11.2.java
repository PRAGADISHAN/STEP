import java.util.Arrays;
public class PrizeTable {
    public static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }
    public static void main(String[] args) {
        int[] m1 = {45, 90, 60, 75};
        int s1 = prizeTable(m1);
        System.out.println(Arrays.toString(m1) + "  swaps = " + s1);
        int[] m2 = {80, 70, 60};
        int s2 = prizeTable(m2);
        System.out.println(Arrays.toString(m2) + "  swaps = " + s2);
    }
}