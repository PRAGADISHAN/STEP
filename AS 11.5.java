import java.util.*;
public class PairWithTargetSum {
    // Approach 2: HashSet - O(n) Time, O(n) Space - BEST
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true;
            seen.add(x);
        }
        return false;
    }
    // Approach 1: Brute Force - O(n^2) Time, O(1) Space
    public static boolean bruteForce(int[] nums, int target) {
        for (int i=0;i<nums.length;i++)
            for (int j=i+1;j<nums.length;j++)
                if (nums[i]+nums[j]==target) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2,7,11,15}, 9)); // true
        System.out.println(hasPairWithSum(new int[]{3,4,6}, 20)); // false
    }
}