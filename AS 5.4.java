public class MatchDayGridAnalyzer {
    static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int r : row) sum += r;
        return (double) sum / row.length;
    }
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String type = avg >= threshold? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(type);
            if (i < runsPerOver.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[][] grid = {{4,6,8},{10,12,14},{2,3,1}};
        System.out.println(classifyMatches(grid, 8));
    }
}