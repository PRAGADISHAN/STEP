import java.util.*;

interface BusUser {
    default double getTransportFee(){ return 12000; }
}
abstract class Student {
    String name;
    Student(String n){ name=n; }
    abstract double getTuition();
    double getTotalFee(){
        double fee = getTuition();
        if(this instanceof BusUser) fee += ((BusUser)this).getTransportFee();
        return fee;
    }
}
class DayScholar extends Student implements BusUser {
    DayScholar(String n){ super(n); }
    double getTuition(){ return 40000; }
}
class Hosteller extends Student {
    Hosteller(String n){ super(n); }
    double getTuition(){ return 40000+60000; }
}
class Scholar extends Student implements BusUser {
    Scholar(String n){ super(n); }
    double getTuition(){ return 20000; }
}

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        double total=0;
        for(int i=0;i<n;i++){
            String line=sc.nextLine();
            String[] parts=line.split(" ",2);
            String type=parts[0];
            String name=parts[1];
            Student s=null;
            if(type.equals("DAY_SCHOLAR")) s=new DayScholar(name);
            else if(type.equals("HOSTELLER")) s=new Hosteller(name);
            else if(type.equals("SCHOLAR")) s=new Scholar(name);
            double fee=s.getTotalFee();
            total+=fee;
            System.out.printf("%s: %.2f\n", name, fee);
        }
        System.out.printf("Total Collected: %.2f\n", total);
    }
}