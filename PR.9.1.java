import java.util.*;
abstract class Ticket {
    static final double FEE = 20;
    int count;
    Ticket(int count){ this.count = count; }
    abstract double getPrice();
    double getAmount(){ return count * (getPrice() + FEE); }
}
class Regular extends Ticket {
    Regular(int c){ super(c); }
    double getPrice(){ return 150; }
}
class Premium extends Ticket {
    Premium(int c){ super(c); }
    double getPrice(){ return 250; }
}
class Recliner extends Ticket {
    Recliner(int c){ super(c); }
    double getPrice(){ return 400; }
}
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for(int i=0;i<n;i++){
            String type = sc.next();
            int cnt = sc.nextInt();
            Ticket t = null;
            if(type.equals("REGULAR")) t = new Regular(cnt);
            else if(type.equals("PREMIUM")) t = new Premium(cnt);
            else if(type.equals("RECLINER")) t = new Recliner(cnt);
            double amt = t.getAmount();
            total += amt;
            System.out.printf("%s: %.2f\n", type, amt);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}