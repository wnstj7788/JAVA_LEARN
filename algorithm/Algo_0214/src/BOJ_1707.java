import java.io.*;
import java.util.*;

public class BOJ_1707 {
	static int v, e;
	static ArrayList<Integer>[] arr;
	static int visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visit = new int[v + 1];
			arr = new ArrayList[v + 1];

			for (int i = 0; i <= v; i++)
				arr[i] = new ArrayList<Integer>();

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				arr[p1].add(p2); //양방향 그래프이기 떄문에 
				arr[p2].add(p1);
			}
			YesOrNo(); //판정 함수 호출 
		}
	}
// 트리는 사이클을 갖지 않는다를 생각해!
// 인접 노드들이 0이라면 1 ,2 를 부여하고 현재 노드와 연결 노드의 수가 같다면 사이클이 존재하는 것이라고 생
	
	public static void YesOrNo() {
		Queue<Integer> q = new LinkedList<Integer>();
		//BFS 탐색 시작 
		for (int i = 1; i <= v; i++) {
			if (visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}

			while (!q.isEmpty()) {
				int now = q.poll();

				for (int j = 0; j < arr[now].size(); j++) { // 현재 나의 자식들 확인  
					if (visit[arr[now].get(j)] == 0) {
						q.add(arr[now].get(j)); // 큐에 넣어줘 
					}

					if (visit[arr[now].get(j)] == visit[now]) { // 인접 노드의 방문 수랑 현재 노드의 방문 수가 같다면 컷 
						System.out.println("NO");
						return;
					}

					if (visit[now] == 1 && visit[arr[now].get(j)] == 0)// 지금 자신의 방문이 1번이면서 자식 노드의 방문 수가 0이라면 자식 노드의방문 수를 2로 수정 
						visit[arr[now].get(j)] = 2;
					else if (visit[now] == 2 && visit[arr[now].get(j)] == 0) // 반대로 현재 내가 2인데 자식의 방문회수가 0이라면 자식 노드의 수를 1로 변경 
						visit[arr[now].get(j)] = 1;
				}
			}
		}

		System.out.println("YES");
	}

}