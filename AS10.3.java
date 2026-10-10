import java.util.*;

public class Solution {
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) return names;
        k = k % n;
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            int newPos = (int)((i + k) % n);
            rotated[newPos] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        long k = sc.nextLong();
        String[] ans = rotateRoster(names, k);
        System.out.print("[");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            if (i < ans.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        sc.close();
    }
}