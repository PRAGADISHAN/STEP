public class WarehouseBinGridScan {
    public static void warehouseSummary(int[][] grid) {
        int total = 0;
        int max = Integer.MIN_VALUE;
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")");
    }
    public static void main(String[] args) {
        int[][] grid = { {4, 9, 2}, {7, 1, 6}, {3, 12, 5} };
        warehouseSummary(grid); // total = 49, maxCoordinate = (2, 1)
    }
}
