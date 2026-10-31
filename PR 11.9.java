public class PairSumSortedArray {
    public static String pairSumSorted(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while (l<r) {
            int sum = nums[l]+nums[r];
            if (sum==target) return "(" + nums[l] + ", " + nums[r] + ")";
            else if (sum < target) l++;
            else r--;
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        System.out.println(pairSumSorted(new int[]{-4,-1,0,3,5,9}, 4)); // (-1, 5)
        System.out.println(pairSumSorted(new int[]{1,2,3}, 100)); // Not Found
    }
}
// If ignore sorted property: HashSet O(n) time O(n) space, Brute Force O(n^2) time
