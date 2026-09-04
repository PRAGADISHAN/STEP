import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double finalScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.finalScore = (cgpa * 10) + (codingScore * 0.5);
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        if (cgpa < 6.5) return false;
        return codingScore >= 60;
    }

    public int compareTo(Candidate other) {
        if (this.finalScore < other.finalScore) return 1;
        if (this.finalScore > other.finalScore) return -1;
        return 0;
    }
}

public class PlacementEngine {
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] temp = new Candidate[candidates.length];
        int n = 0;
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) || Candidate.isEligible(c.cgpa, c.codingScore)) {
                temp[n++] = c;
            }
        }
        Candidate[] shortlisted = Arrays.copyOf(temp, n);
        Arrays.sort(shortlisted);

        String out = "";
        for (int i = 0; i < shortlisted.length; i++) {
            out += (i+1) + ". " + shortlisted[i].name + " (" + shortlisted[i].finalScore + ")";
            if (i < shortlisted.length - 1) out += " | ";
        }
        return out;
    }

    public static void main(String[] args) {
        Candidate[] list = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(list));
    }
}