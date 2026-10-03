import java.util.*;

interface Insurable {
    double getInsurance(double declaredValue);
}

abstract class Parcel {
    double weight, value;
    Parcel(double w, double v){ weight=w; value=v; }
    abstract double getCharge();
}

class Standard extends Parcel {
    Standard(double w, double v){ super(w,v); }
    double getCharge(){ return 40 + 10*weight; }
}
class Express extends Parcel implements Insurable {
    Express(double w, double v){ super(w,v); }
    double getCharge(){ return 80 + 15*weight; }
    public double getInsurance(double declaredValue){ return declaredValue*0.02; }
}
class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v){ super(w,v); }
    double getCharge(){ return 40 + 10*weight + 50; }
    public double getInsurance(double declaredValue){ return declaredValue*0.02; }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand=0;
        for(int i=0;i<n;i++){
            String type=sc.next();
            double w=sc.nextDouble();
            double v=sc.nextDouble();
            Parcel p=null;
            double insurance=0;
            if(type.equals("STANDARD")) p=new Standard(w,v);
            else if(type.equals("EXPRESS")){ p=new Express(w,v); insurance=((Insurable)p).getInsurance(v); }
            else if(type.equals("FRAGILE")){ p=new Fragile(w,v); insurance=((Insurable)p).getInsurance(v); }
            double charge=p.getCharge();
            double total=charge+insurance;
            grand+=total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", type, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grand);
    }
}