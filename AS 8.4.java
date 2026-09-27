import java.util.*;

abstract class Employee {
    String name; double salary;
    Employee(String n,double s){name=n; salary=s;}
    abstract double getBonus();
}
class Fulltime extends Employee {
    Fulltime(String n,double s){super(n,s);}
    double getBonus(){return salary*0.10;}
}
class Parttime extends Employee {
    Parttime(String n,double s){super(n,s);}
    double getBonus(){return salary*0.05;}
}
class Intern extends Employee {
    Intern(String n,double s){super(n,s);}
    double getBonus(){return 2000;}
}

public class BonusCalculator {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        List<Employee> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String type=sc.next();
            String name=sc.next();
            double sal=sc.nextDouble();
            Employee e=null;
            if(type.equals("FULLTIME")) e=new Fulltime(name,sal);
            else if(type.equals("PARTTIME")) e=new Parttime(name,sal);
            else e=new Intern(name,sal);
            list.add(e);
        }
        for(Employee e:list){
            double b=e.getBonus();
            total+=b;
            System.out.printf("%s: %.2f\n", e.name, b);
        }
        System.out.printf("Total Bonus: %.2f\n", total);
    }
}