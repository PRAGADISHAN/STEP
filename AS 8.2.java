import java.util.*;

abstract class Vehicle { abstract double getCharge(int hrs); }
class Bike extends Vehicle { double getCharge(int h){ return h*10; } }
class Car extends Vehicle { double getCharge(int h){ return h==1?30:30+(h-1)*20; } }
class Truck extends Vehicle { double getCharge(int h){ return Math.max(100, h*50); } }

public class ParkingCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            int hrs=sc.nextInt();
            Vehicle v = type.equals("BIKE")?new Bike(): type.equals("CAR")?new Car(): new Truck();
            double charge = v.getCharge(hrs);
            total+=charge;
            System.out.printf("%s: %.2f\n", type, charge);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}