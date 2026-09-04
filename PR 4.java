import java.util.*;
public class FirstNonRepeating {
    static char findFirstNonRepeatingChar(String text){
        int[] freq = new int[256];
        for(char c: text.toCharArray()) freq[c]++;
        for(char c: text.toCharArray()) if(freq[c]==1) return c;
        return '\0';
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: "); String s = sc.nextLine();
        char ch = findFirstNonRepeatingChar(s);
        if(ch=='\0') System.out.println("No Non-Repeating Character Found");
        else System.out.println("First Non-Repeating Character: '"+ch+"'");
    }
}