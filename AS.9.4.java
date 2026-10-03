import java.util.*;

interface NightService {
    default double applyNightCharge(double fare){ return fare*1.2; }
}
abstract class Cab {
    abstract double getRate();
    double calculateFare(double km){
        double fare = km*getRate();
        return Math.max(fare, 100);
    }
}
class Mini extends Cab { double getRate(){ return 10; } }
class Sedan extends Cab implements NightService { double getRate(){ return 14; } }
class SUV extends Cab implements NightService { double getRate(){ return 18; } }

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++){
            String cabType=sc.next();
            double km=sc.nextDouble();
            String time=sc.next();
            Cab cab=null;
            if(cabType.equals("MINI")) cab=new Mini();
            else if(cabType.equals("SEDAN")) cab=new Sedan();
            else if(cabType.equals("SUV")) cab=new SUV();

            if(time.equals("NIGHT") &&!(cab instanceof NightService)){
                System.out.printf("%s: night service not available\n", cabType);
                continue;
            }
            double fare=cab.calculateFare(km);
            if(time.equals("NIGHT")) fare=((NightService)cab).applyNightCharge(fare);
            total+=fare;
            System.out.printf("%s: %.2f\n", cabType, fare);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}