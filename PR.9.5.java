import java.util.*;
interface SaverMode { double applySaver(double u); }
abstract class Appliance { abstract double getPower(); double getUnits(double h){return getPower()*h/1000.0;} }
class Fridge extends Appliance { double getPower(){return 150;} }
class AC extends Appliance implements SaverMode { double getPower(){return 1500;} public double applySaver(double u){return u*0.75;} }
class TV extends Appliance { double getPower(){return 100;} }
class Washer extends Appliance implements SaverMode { double getPower(){return 500;} public double applySaver(double u){return u*0.75;} }

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine(); double totalCost=0;
        for(int i=0;i<n;i++){
            String line=sc.nextLine().trim();
            String[] p=line.split(" ");
            String type=p[0]; double hrs=Double.parseDouble(p[1]);
            boolean saver=p.length==3;
            Appliance app=null;
            if(type.equals("FRIDGE")) app=new Fridge();
            else if(type.equals("AC")) app=new AC();
            else if(type.equals("TV")) app=new TV();
            else if(type.equals("WASHER")) app=new Washer();

            if(saver &&!(app instanceof SaverMode)){
                System.out.printf("%s: saver mode not supported\n",type);
                continue;
            }
            double units=app.getUnits(hrs);
            if(saver) units=((SaverMode)app).applySaver(units);
            double cost=units*8;
            totalCost+=cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f\n",type,units,cost);
        }
        System.out.printf("Total Cost: %.2f\n",totalCost);
    }
}