import java.util.*;
class Student {
    String name;
    int[] marks;
    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    double average() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }
    String getGrade(double avg) {
        if (avg >= 75) return "B";
        else if (avg >= 40 && avg <= 59) return "D";
        else if (avg >= 60) return "C";
        else return "F";
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) marks[i] = sc.nextInt();
        Student s = new Student(name, marks);
        double avg = s.average();
        String grade = s.getGrade(avg);
        System.out.printf("%s: Average %.1f, Grade %s\n", s.name.toUpperCase(), avg, grade);
        sc.close();
    }
}