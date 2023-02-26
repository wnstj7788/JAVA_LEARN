import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.omg.CORBA.INTERNAL;

public class AdjListTest2 {
	

	static ArrayList<Integer>[]  adjList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		adjList = new ArrayList[V]; // head가ㅣ 모두 null인 상태 
		
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		
		int from, to;
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			// 안에가 null이면 nullpoint 뜬다 위에 for문에서 정리 
			adjList[from].add(to);
			adjList[to].add(from);
		}
		print();

	}
	
	
	static void print() {
		for(ArrayList<Integer> list : adjList) { // list 각 인접 리스트의 해드 
			System.out.println(list);
		}
	}
	

}
