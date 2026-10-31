<<<<<<< HEAD
import java.util.*;
public class PairWithTargetSum {

    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true;
            seen.add(x);
        }
        return false;
    }
    
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
=======
import java.util.*;
public class PairWithTargetSum {

    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true;
            seen.add(x);
        }
        return false;
    }
    
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
>>>>>>> 29a2e889abae15a61dda82752b37adcb22a0cb1f
