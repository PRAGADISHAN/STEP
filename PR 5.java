import java.util.Scanner;
public class ReverseName {
    static String reverseCustomerName(String name){
        return new StringBuilder(name).reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.println("Original Name: "+name);
        System.out.println("Reversed Name: "+reverseCustomerName(name));
    }
}