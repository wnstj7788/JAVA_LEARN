import java.nio.charset.MalformedInputException;
import java.util.Scanner;



public class BOJ_9372_상근이의여행 {
	static class fly{
		 int NodeA, NodeB;

		public fly(int nodeA, int nodeB) {
			super();
			NodeA = nodeA;
			NodeB = nodeB;
		}

		 
	}
	static int N,M;
	static int parents[];
	static fly flylist[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int TC = sc.nextInt();
		 for (int tc = 0; tc < TC; tc++) {
			 N = sc.nextInt();
			 M  = sc.nextInt();
			 flylist = new fly[M];
			 
			 for (int i = 0; i < M; i++) {
				 flylist[i] = new fly(sc.nextInt(), sc.nextInt());
			}
			 makeSet();
			
		}
		
		
	}
	
	
	static void makeSet(){ // 나라 대표로 만들어봥 
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
				
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true; 
		
		
	}
	
	
}
