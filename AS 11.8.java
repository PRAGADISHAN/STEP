
import java.util.*;
public class SpiralOrderTraversal {
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        if (grid.length==0) return res;
        int top=0, bottom=grid.length-1, left=0, right=grid[0].length-1;
        while (top<=bottom && left<=right) {
            for (int j=left;j<=right;j++) res.add(grid[top][j]); top++;
            for (int i=top;i<=bottom;i++) res.add(grid[i][right]); right--;
            if (top<=bottom) { for (int j=right;j>=left;j--) res.add(grid[bottom][j]); bottom--; }
            if (left<=right) { for (int i=bottom;i>=top;i--) res.add(grid[i][left]); left++; }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(grid)); // [1,2,3,6,9,8,7,4,5]
    }
}