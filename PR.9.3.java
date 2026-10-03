import java.util.*;
interface BusUser { default double getBusFee(){return 12000;} }
abstract class Student { String name; Student(String n){name=n;} abstract double getTuition(); }
class DayScholar extends Student implements BusUser { DayScholar(String n){super(n);} double getTuition(){return 40000;} }
class Hosteller extends Student { Hosteller(String n){super(n);} double getTuition(){return 100000;} }
class Scholar extends Student implements BusUser { Scholar(String n){super(n);} double getTuition(){return 20000;} }

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine(); double total=0;
        for(int i=0;i<n;i++){
            String[] s=sc.nextLine().split(" ",2);
            String type=s[0]; String name=s[1]; Student st=null;
            if(type.equals("DAY_SCHOLAR")) st=new DayScholar(name);
            else if(type.equals("HOSTELLER")) st=new Hosteller(name);
            else if(type.equals("SCHOLAR")) st=new Scholar(name);
            double fee=st.getTuition();
            if(st instanceof BusUser) fee+=((BusUser)st).getBusFee();
            total+=fee;
            System.out.printf("%s: %.2f\n",name,fee);
        }
        System.out.printf("Total Collected: %.2f\n",total);
    }
}