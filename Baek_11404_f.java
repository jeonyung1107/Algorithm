import java.util.Scanner;

public class Baek_11404_f {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int city = sc.nextInt();
		int bus = sc.nextInt();
		int max = Integer.MAX_VALUE/2;
		// √ ±‚»≠
		int[][] D = new int[city][city];
		int[][] P = new int[city][city];
		for (int i = 0; i < bus; i++) {
			int s = sc.nextInt() - 1;
			int d = sc.nextInt() - 1;
			int c = sc.nextInt();
			if(D[s][d] ==0)D[s][d] = c;
			else if(D[s][d]!=0&&D[s][d]>c) D[s][d] = c;
			P[s][d] = s;
		}
		for (int i = 0; i < city; i++) {
			for (int j = 0; j < city; j++) {
				if (i != j && D[i][j] == 0)
					D[i][j] = max;
			}
		}
 
		for (int i = 0; i < city; i++) {
			for (int j = 0; j < city; j++) {
				for (int k = 0; k < city; k++) {
					if (D[j][k] > D[j][i] + D[i][k]) {
						D[j][k] = D[j][i] + D[i][k];
						P[j][k] = i;
					}
				}
			}
		}
		for (int i = 0; i < city; i++) {
			for (int j = 0; j < city; j++){
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
	}
}
