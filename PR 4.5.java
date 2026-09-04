import java.util.Arrays;

public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) return nums;
        k = k % nums.length;
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        // copy back to original as per task
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1,2,3,4,5,6,7}, 3))); // [5,6,7,1,2,3,4]
        System.out.println(Arrays.toString(rotateArray(new int[]{1,2}, 3))); // [2,1]
    }
}