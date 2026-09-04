import java.util.*;
public class RPSGame {
    static String playRound(String player, String computer){
        if(player.equals(computer)) return "Draw";
        if((player.equals("Rock") && computer.equals("Scissors")) ||
           (player.equals("Scissors") && computer.equals("Paper")) ||
           (player.equals("Paper") && computer.equals("Rock")))
            return "Player Wins";
        return "Computer Wins";
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] moves = {"Rock","Paper","Scissors"};
        Random r = new Random();
        int n=5, wins=0, loss=0, draw=0;
        String[][] table = new String[n][4];

        for(int i=0;i<n;i++){
            System.out.print("Round "+(i+1)+" Enter Rock/Paper/Scissors: ");
            String p = sc.nextLine();
            String c = moves[r.nextInt(3)];
            String res = playRound(p,c);
            table[i][0]=String.valueOf(i+1); table[i][1]=p; table[i][2]=c; table[i][3]=res;
            if(res.equals("Player Wins")) wins++;
            else if(res.equals("Computer Wins")) loss++;
            else draw++;
            System.out.println("Player: "+p+", Computer: "+c+" -> "+res);
        }
        System.out.println("\nRound | Player | Computer | Result");
        for(String[] row: table) System.out.println(Arrays.toString(row));
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",wins,loss,draw,(wins*100.0/n));
    }
}