import java.util.*;
interface Insurable { double getInsurance(double v); }
abstract class Parcel { double w,v; Parcel(double w,double v){this.w=w;this.v=v;} abstract double getCharge(); }
class Standard extends Parcel { Standard(double w,double v){super(w,v);} double getCharge(){return 40+10*w;} }
class Express extends Parcel implements Insurable { Express(double w,double v){super(w,v);} double getCharge(){return 80+15*w;} public double getInsurance(double val){return val*0.02;} }
class Fragile extends Parcel implements Insurable { Fragile(double w,double v){super(w,v);} double getCharge(){return 40+10*w+50;} public double getInsurance(double val){return val*0.02;} }

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); double grand=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); double w=sc.nextDouble(); double v=sc.nextDouble();
            Parcel p=null; double ins=0;
            if(type.equals("STANDARD")) p=new Standard(w,v);
            else if(type.equals("EXPRESS")){p=new Express(w,v); ins=((Insurable)p).getInsurance(v);}
            else if(type.equals("FRAGILE")){p=new Fragile(w,v); ins=((Insurable)p).getInsurance(v);}
            double charge=p.getCharge(); double tot=charge+ins; grand+=tot;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n",type,charge,ins,tot);
        }
        System.out.printf("Grand Total: %.2f\n",grand);
    }
}