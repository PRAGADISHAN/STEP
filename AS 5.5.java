import java.util.Arrays;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;
    double fantasyPoints;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
        this.fantasyPoints = battingAverage + (matchesPlayed * 2); // simple points logic
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10; // experienced enough
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 &&!injured; // borderline but fit
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.fantasyPoints, this.fantasyPoints); // descending
    }
}

public class FantasyLeagueAutoDraftRankingEngine {
    static String draftAndRank(Player[] players) {
        Player[] temp = new Player[players.length];
        int count = 0;
        for (Player p : players) {
            if (Player.isDraftable(p.matchesPlayed) || Player.isDraftable(p.matchesPlayed, p.injured)) {
                temp[count++] = p;
            }
        }
        Player[] draftable = Arrays.copyOf(temp, count);
        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            sb.append(i+1).append(". ").append(draftable[i].name);
            if (i < draftable.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] list = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(list)); // 1. Rahul | 2. Virat | 3. Dev
    }
}