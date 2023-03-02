package Samsung_Type_A_Test;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* 각 대륙을 하나의 노드로 파악하여 모든 노드가 연결되는 최소신장 트리로 접근 
 * 클루스칼 or prim으로 해결 가능한 문제
 * 결론은 모든 노드가 이어지는 것
 * bfs 탐색을 통해 대륙의 계수를 파악 후 해당 대륙에서 다른 대륙까지 2이상으로 갈 수 있는 모든 경우를  저장한 뒤
 * 크루스칼로 해결하기 
 */

public class BOJ_17472_다리만들기2 {

	static int map[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int land;
	static int N, M, landnum;
	static boolean visited[][];
	static PriorityQueue<node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		} // input end
		landnum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 현재 위치가 1이고 방문한 적이 없다면 bfs연산
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j, landnum);
					landnum++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (map[i][j] != 0) {
					findnode(i, j, map[i][j]);
				}
			}
		}

		// 간선 정보 들어오면 가중치 정렬하고
		// Arrays.sort(?);
		landnum--;
	
		makeSet();
		int result = shortestPath();
		System.out.println( result == 0 ? -1 : result);
		
	}// main end

	// 섬의 개수 찾기 및 넘버링
	static void bfs(int si, int sj, int num) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(si, sj));
		visited[si][sj] = true; // 현재 위치 방문처리 해주기

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int i = 0; i < dx.length; i++) {
				int nx = now.x + dx[i];// 4방 탐색
				int ny = now.y + dy[i];
				// 4방 탐색 결과 범위 이내에 있다면 q에 넣어주기
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 0 && !visited[nx][ny]) {
					map[nx][ny] = num;
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		} // while end

	}// bfs end

	static ArrayList<node> nodeList = new ArrayList<>();
	static int[] parents;

	// 섬의 수 만큼 대장 만들어주기
	static void makeSet() {
		parents = new int[landnum];
		for (int i = 0; i < landnum; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a<b) {
			parents[b]=a;
		}
		else {
			parents[a] =b;
		}
	}
	static int shortestPath() {
		int sum =0;
		int size = pq.size();
		for(int i=0; i< size; i++) {
			node node = pq.poll();
			int x = node.nodeA;
			int y = node.nodeB;
			
			if(findSet(x) != findSet(y)) {
				sum += node.weight;
				union(x,y);
			}
		}
		
		int rx = parents[1];
		for(int i=2; i<landnum; i++) {
			if(rx != findSet(parents[i])) {
				// System.out.println("연결 x ");
				return 0;
			}
		}
		
		return sum;
	}

	static void findnode(int x, int y, int idx) {
		// 간선 정보를 입력 받고 싶은데 우찌 받냐 진짜로,,,,,,,,,,,,,,,,,
		// 2중 for문 돌면서 체크하기
		Queue<node> edge = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < dx.length; i++) {
			edge.add(new node(x, y, 0));
			visit[x][y] = true;

			// bfs탐색을 통해 다음 섬까지 갈 수 있는지 확인
			// 1. 4방 탐색 중 가고자 하는 방향의 다음칸이 0인가>?
			// 1이라면 못 가는거고 0이라면 출발 나중엥 wegiht가 1이라면 해당 간선은 추가하지 않음

			while (!edge.isEmpty()) { // 모든 노드를 넣어두고 시작
				node now = edge.poll();

				int nx = now.nodeA + dx[i];
				int ny = now.nodeB + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) { // 다음 칸이 0인경우만 다리를
					if (map[nx][ny] == idx) {
						if (map[nx][ny] != 0) {
							// 만들 수 있음
							int from = idx - 1;
							int to = map[nx][ny] - 1;
							int len = now.weight;
							// 2이상이면
							if (len > 1) {
								pq.add(new node(from, to, len));
								break;
							}
						} else {
							edge.add(new node(nx, ny, now.weight + 1));
							visit[nx][ny] = true;
						}

					}

				}
				edge.clear();
			}

		}
	}

	static class node implements Comparable<node> {
		int nodeA;
		int nodeB;
		int weight;

		public node(int nodeA, int nodeB, int weight) {
			super();
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.weight = weight;
		}

		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}
}
