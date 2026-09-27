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

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Employee> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String type=sc.next();
            String name=sc.next();
            double sal=sc.nextDouble();
            if(type.equals("FULLTIME")) list.add(new Fulltime(name,sal));
            else if(type.equals("PARTTIME")) list.add(new Parttime(name,sal));
            else list.add(new Intern(name,sal));
        }
        double total=0;
        for(Employee e:list){
            double b=e.getBonus();
            total+=b;
            System.out.printf("%s: %.2f\n", e.name, b);
        }
        System.out.printf("Total Bonus: %.2f\n", total);
    }
}