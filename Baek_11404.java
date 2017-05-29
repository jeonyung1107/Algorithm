import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baek_11404 {

	public static void main(String[] args) {
		int cityNum;
		int busNum;
		int n;
		int t;
		int c;
		Scanner sc = new Scanner(System.in);
		cityNum = sc.nextInt();
		busNum = sc.nextInt();
		ArrayList<city> graph = new ArrayList<city>();
		
		for(int i = 0; i<cityNum; i++){
			graph.add(new city(i));
		}
		for(int i = 0; i<busNum; i++){
			n = sc.nextInt()-1;
			t = sc.nextInt()-1;
			c = sc.nextInt();
			graph.get(n).line.add(new bus(t,c));
		}
		for(int i = 0; i<cityNum; i++){
			dijkstra(graph, i, cityNum, busNum);
		}
	}
	//TODO ±¸Çö
	public static void dijkstra(ArrayList<city> graph,int start, int cityNum, int busNum){
		ArrayList<city> copy = new ArrayList<city>();
		
		for(int i = 0; i<cityNum; i++){
			try{
			copy.add((city)graph.get(i).clone());
			}catch(CloneNotSupportedException e){}
			copy.get(i).distance = -1;
		}
		for(int i = 0 ; i<cityNum; i++){
			copy.get(i).line = new PriorityQueue<bus>();
			copy.get(i).line.addAll(graph.get(i).line);
		}
		PriorityQueue<city> use = new PriorityQueue<city>();
		copy.get(start).distance = 0;
		use.add(copy.get(start));
		while(!use.isEmpty()){
			city now = use.poll();
			bus nBus;
			int len = now.line.size();
			for(int i = 0; i<len;i++){
				nBus = now.line.poll();
				if(copy.get(nBus.to).distance ==-1||(copy.get(nBus.to).distance > now.distance + nBus.cost)){
				copy.get(nBus.to).distance = now.distance + nBus.cost;
				use.add(copy.get(nBus.to));
				}
			}
		}
		for(int i= 0; i<cityNum; i++){
			if(copy.get(i).distance ==-1){
				copy.get(i).distance =0;
			}
			System.out.print(copy.get(i).distance+" ");
		}
		System.out.println();
		
	}
	
	public static void an(int[] a){
		for(int i = 0; i<a.length; i++){
			a[i] = i+10;
		}
	}
}
class city implements Comparable<city>, Cloneable {
	int cityNo;
	int distance = 0;
	
	PriorityQueue<bus> line = new PriorityQueue<bus>();
	
	city(int n){
		cityNo = n;
	}
	
	@Override
	public int compareTo(city target){
		if(this.distance>target.distance) return 1;
		else if(this.distance<target.distance) return -1;
		else return 0;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
class bus implements Comparable<bus>{
	int to;
	int cost;
	
	bus(int t, int c){
		to = t;
		cost = c;
	}
	@Override
	public int compareTo(bus target){
		if(this.cost>target.cost) return 1;
		else if(this.cost<target.cost) return -1;
		else return 0;
	}
}
