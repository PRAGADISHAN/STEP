public class InsertPositionSortedList {
    public static int searchInsertPosition(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid] < target) l = mid+1;
            else r = mid-1;
        }
        return l;
    }
    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(searchInsertPosition(new int[]{1,3,5,6}, 2)); // 1
    }
}
