import java.util.*;

public class Solution {

    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int longest = 0;
        int currentStreak = 0;

        for (int d : days) {
            if (d == 1) {
                present++;
                currentStreak++; // grows on every 1
                if (currentStreak > longest) {
                    longest = currentStreak; // remember largest
                }
            } else {
                currentStreak = 0; // resets to 0 on every 0
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        int[] ans = attendanceSummary(days);
        System.out.println("Present: " + ans[0] + ", Longest streak: " + ans[1]);
        sc.close();
    }
}