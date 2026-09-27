import java.util.*;

abstract class Room { abstract double getBill(); }
class Single extends Room {
    int units; Single(int u){units=u;}
    double getBill(){ return units * 8.0; }
}
class Shared extends Room {
    int units, occ; Shared(int u,int o){units=u; occ=o;}
    double getBill(){ return (units * 6.0) / occ; }
}
class AC extends Room {
    int units; AC(int u){units=u;}
    double getBill(){ return units * 10.0 + 200; }
}

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            Room r=null;
            if(type.equals("SINGLE")) r=new Single(sc.nextInt());
            else if(type.equals("SHARED")) r=new Shared(sc.nextInt(), sc.nextInt());
            else if(type.equals("AC")) r=new AC(sc.nextInt());
            
            double bill=r.getBill();
            total+=bill;
            System.out.printf("%s: %.2f\n", type, bill);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}