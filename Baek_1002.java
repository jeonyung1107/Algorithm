import java.util.Scanner;
public class Baek_1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] x1, x2, r1, y1,y2, r2;
		x1 = new int[num];
		y1 = new int[num];
		r1 = new int[num];
		x2 = new int[num];
		y2 = new int[num];
		r2 = new int[num];
		
		for(int i = 0; i<num; i++){
			x1[i] = sc.nextInt();
			y1[i] = sc.nextInt();
			r1[i] = sc.nextInt();
			x2[i] = sc.nextInt();
			y2[i] = sc.nextInt();
			r2[i] = sc.nextInt();
		}
		for(int i= 0; i<num; i++){
			System.out.println(Baek_1002.calPoint(x1[i],y1[i],r1[i],x2[i],y2[i],r2[i]));
		}
	}
	
	public static int calPoint(int x1,int y1,int r1,int x2,int y2,int r2){
		int result = 0;
		double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		if(distance ==0){
			if(r1==r2) result =-1;
			else result = 0;
		}
		else{
			if(r1>distance+r2) result = 0;
			else if(r2>distance+r1) result = 0;
			else if(distance>r1+r2) result = 0;
			else if(distance == r1+r2) result = 1;
			else if(r2 ==distance+r1) result = 1;
			else if(r1 == distance +r2) result = 1;
			else if(distance<r1+r2) result = 2;
		}
		return result;
	}
	
}
