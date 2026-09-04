import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < n) result[k++] = arr1[i++];
        while (j < m) result[k++] = arr2[j++];
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1,3,5}, new int[]{2,4,6})));
    }
}