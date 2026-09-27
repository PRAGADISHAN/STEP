import java.util.*;

abstract class Customer {
    abstract double calculate(double amount);
}
class Student extends Customer {
    double calculate(double amount) { return amount * 0.90; }
}
class Staff extends Customer {
    double calculate(double amount) { return amount * 0.95; }
}
class Guest extends Customer {
    double calculate(double amount) { return amount + 10; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Customer c;
            if (type.equals("STUDENT")) c = new Student();
            else if (type.equals("STAFF")) c = new Staff();
            else c = new Guest();
            
            double finalAmt = c.calculate(amt);
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f\n", type, finalAmt);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}