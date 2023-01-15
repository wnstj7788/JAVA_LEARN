import java.util.*;

public class BaelJoon_1260 {

//	private static int N;
	//인접리스트  문제 해결하기에는 한계가 있나?
	//인접 리스트로 접근 시 작은 순서로 십입이 불가능? 
	public static boolean[] visited_dfs = new boolean[10000];
	public static boolean[] visited_bfs = new boolean[10000];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void dfs(int x) {
		visited_dfs[x] = true;
		System.out.print(x + " ");

		for (int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if (!visited_dfs[y])
				dfs(y);
		}
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);

		visited_bfs[start] = true;

		while (!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");
			for (int i = 0; i < graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if (!visited_bfs[y]) {
					q.offer(y);
					visited_bfs[y] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(), M = sc.nextInt(), V = sc.nextInt();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int j = 0; j < M; j++) {
			graph.get(sc.nextInt()).add(sc.nextInt());
			
			// 낮은게 먼저 들어가야 낮은걸 먼저 수행 할 수 있다.
		}
		graph.sort(null);

		dfs(V);
		System.out.println();
		bfs(V);

	}

}
// 고려사항 간선이라면 낮은 것 부터 
