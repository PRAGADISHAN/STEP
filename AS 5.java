public class ReviewProfiler {
    static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortC = 0, mediumC = 0, longC = 0;
        for (String w : words) {
            // remove punctuation
            String clean = w.replaceAll("[^a-zA-Z]", "");
            int len = clean.length();
            if (len >= 1 && len <= 4) shortC++;
            else if (len >= 5 && len <= 8) mediumC++;
            else if (len >= 9) longC++;
        }
        System.out.println("Short: " + shortC + " | Medium: " + mediumC + " | Long: " + longC);
    }
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}