package Shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.w3c.dom.Node;

public class BOJ_1504 {
	public static final int INF = Integer.MAX_VALUE;
	public static int n ,m , start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	public static int distance[];
	public static boolean[] visited;  //방문 배열 선언 2,3 노드는 반드시 방문해야함 
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = 1; // 시작은 무조건 1번에서 시작함 
		
		distance[] = new int[n +1];
		
		Arrays.fill(distance,INF);
		
		for(int i =0 ; i < n ; i++) {
			
			
			
			
		}
		
	}
	

}
