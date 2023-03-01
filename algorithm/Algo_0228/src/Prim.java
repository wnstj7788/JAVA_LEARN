import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
	static int V;
	static int[][] adjArr;// 인접행렬

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		adjArr = new int[V][V];
		for (int i = 0; i <V; i++) {
			for (int j = 0; j < V; j++) {
				adjArr[i][j] = sc.nextInt();
				
			}
		}
		
		int result  = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 1));
		boolean[] visit = new boolean[V];
		
		int cnt = 0;
		while(!pq.isEmpty() && cnt < V) {
			Edge now = pq.poll();
			
			if(visit[now.num]) continue;
			
			visit[now.num] = true;
			cnt++;
			result += now.weight;
			
			
			for (int i = 0; i < V; i++) {
				if(!visit[i] && adjArr[now.num][i] > 0 ) {// 영업안된 친구있>
					pq.add(new Edge(adjArr[now.num][i], i));
					
				}
			}
		}
		
		System.out.println(result);
		
	}

	private static void prim() {
	
		
	}

	static class Edge implements Comparable<Edge> {
		int weight, num;

		public Edge(int weight, int num) {
			super();
			this.weight = weight;
			this.num = num;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

}
