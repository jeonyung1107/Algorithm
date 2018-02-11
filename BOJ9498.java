import java.util.Scanner;

public class BOJ9498 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();

        char grade = 'F';
        if(score>=60) {grade = 'D';}
        if(score>=70) {grade = 'C';}
        if(score>=80) {grade = 'B';}
        if(score>=90) {grade = 'A';}

        System.out.println(grade);

    }
}
