public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // extend vs restart
            curr = Math.max(nums[i], curr + nums[i]);
            maxSoFar = Math.max(maxSoFar, curr);
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(maxSubArray(new int[]{-3,-1,-2})); // -1
    }
}