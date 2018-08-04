import java.util.Scanner;

public class BOJ1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int newNum = n;
        int cycle = 0;
        while(true){
            cycle++;

            int ten = newNum/10;
            int one = newNum%10;

            newNum = one * 10 + (ten + one)%10;

            if(newNum == n){
                break;
            }
        }

        System.out.println(cycle);
    }
}
