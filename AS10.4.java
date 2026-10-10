import java.util.*;

public class Solution {
    static int lowerBound(int[] scores, int target) {
        int l = 0, r = scores.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (scores[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int upperBound(int[] scores, int target) {
        int l = 0, r = scores.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (scores[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int countInBand(int[] scores, int low, int high) {
        int first = lowerBound(scores, low);
        int last = upperBound(scores, high);
        return last - first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}