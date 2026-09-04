public class PalindromeChecker {
    static boolean isPalindromeIterative(String s){
        int l=0, r=s.length()-1;
        while(l<r){ if(s.charAt(l++)!=s.charAt(r--)) return false; }
        return true;
    }
    static boolean isPalindromeRecursive(String s){
        if(s.length()<=1) return true;
        if(s.charAt(0)!=s.charAt(s.length()-1)) return false;
        return isPalindromeRecursive(s.substring(1,s.length()-1));
    }
    static boolean isPalindromeArrayReversal(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }
    public static void main(String[] args){
        String[] tests = {"madam","hello"};
        for(String t: tests){
            System.out.println(t+" -> Iterative: "+(isPalindromeIterative(t)?"Palindrome":"Not Palindrome")+
            " | Recursive: "+(isPalindromeRecursive(t)?"Palindrome":"Not Palindrome")+
            " | Reversal: "+(isPalindromeArrayReversal(t)?"Palindrome":"Not Palindrome"));
        }
    }
}