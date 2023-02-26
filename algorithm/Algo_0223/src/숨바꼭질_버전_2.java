import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_버전_2 {

	static int N;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		System.out.println(bfs());

	}

	private static int bfs() {

		Queue<Point> q = new LinkedList<>();
		boolean[] visit = new boolean[100001];

		q.add(new Point(N)); // 출발점은 연산횟수 없이 그냥 만들어진 수임

		visit[N] = true; // 큐에 넣을 때 표기하기

		int cnt = 0;// 이게 현재 큐에 들어오는 애들을 만들기 위한 연산수행 횟수임

		while (!q.isEmpty()) { // 방문 스케쥴이 남은게 있으면 계쏙하자
			
			int size = q.size(); // 큐 사이즈 만큼 카운트 미친  아이디어 !~
			cnt ++;
			for (int s = 0; s < size; s++) {

				Point now = q.poll();

				if (now.num == K) {
					return cnt; // now.num이 되기까지 연산을 면ㅊ번 수행했느가?> 그게 답이다
				}

				if (now.num + 1 <= 100000 && !visit[now.num + 1]) { // +1연상를 수행해서 만들 수 있는 인접 행렬
					q.add(new Point(now.num + 1));
					visit[now.num + 1] = true;
				}

				if (now.num - 1 >= 0 && !visit[now.num - 1]) { // -1연상를 수행해서 만들 수 있는 인접 행렬
					q.add(new Point(now.num - 1));
					visit[now.num - 1] = true;
				}

				if (now.num * 2 <= 100000 && !visit[now.num * 2]) { // *2 연상를 수행해서 만들 수 있는 인접 행렬
					q.add(new Point(now.num * 2));
					visit[now.num * 2] = true;
				}
			}// for end 
			
		}
		return -1;

	}

	static class Point {
		int num; // 정점

		public Point(int num) {
			this.num = num;

		}

	}
}
