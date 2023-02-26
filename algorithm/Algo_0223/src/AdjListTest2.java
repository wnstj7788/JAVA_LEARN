import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;


public class AdjListTest2 {

	static ArrayList<Integer>[] adjList;
	static int V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
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
		// print();
		bfs(0);

	}

	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[V];

		q.offer(start);
		visited[start] = true;
		int now = 0;

		while (!q.isEmpty()) {
			now = q.poll();
			System.out.println((char) (now + 65)); // 탐색해때 해야 할일

			for (int vertex : adjList[now]) {
				if (!visited[vertex]) {
					q.offer(vertex);
					visited[vertex] = true;
				}

			}

		}
	}

	static void print() {
		for (ArrayList<Integer> list : adjList) { // list 각 인접 리스트의 해드
			System.out.println(list);
		}
	}

}
