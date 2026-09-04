public class SignalStreak {
    static void findLongestStreak(String signalLog) {
        char maxChar = signalLog.charAt(0);
        int maxLen = 1, currLen = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i-1)) {
                currLen++;
            } else {
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxChar = signalLog.charAt(i-1);
                }
                currLen = 1;
            }
        }
        if (currLen > maxLen) { maxLen = currLen; maxChar = signalLog.charAt(signalLog.length()-1); }
        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxLen + " times");
    }
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}