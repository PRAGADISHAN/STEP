import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name; LocalDate start;
    Plan(String n, LocalDate s){name=n; start=s;}
    abstract LocalDate getRenewal();
}
class Basic extends Plan {
    Basic(String n, LocalDate s){super(n,s);}
    LocalDate getRenewal(){return start.plusDays(30);}
}
class Standard extends Plan {
    Standard(String n, LocalDate s){super(n,s);}
    LocalDate getRenewal(){return start.plusDays(90);}
}
class Premium extends Plan {
    Premium(String n, LocalDate s){super(n,s);}
    LocalDate getRenewal(){return start.plusDays(365);}
}

public class RenewalReminder {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String type=sc.next();
            String name=sc.next();
            String dateStr=sc.next();
            LocalDate start=LocalDate.parse(dateStr);
            Plan p=null;
            if(type.equals("BASIC")) p=new Basic(name,start);
            else if(type.equals("STANDARD")) p=new Standard(name,start);
            else p=new Premium(name,start);
            System.out.println(name+": "+p.getRenewal());
        }
    }
}