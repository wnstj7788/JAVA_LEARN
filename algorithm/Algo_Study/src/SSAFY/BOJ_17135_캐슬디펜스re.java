package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스re {

	static class Bowman {
		int x, y;

		public Bowman(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static class monster implements Comparable<monster> {
		int x, y;

		public monster(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(monster o) {
			return this.y - o.y;
		}

	}

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int onemap[][];
	static int input[];
	static int N, M, D, monsterCnt, ans;
	static ArrayList<Bowman> attack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		onemap = new int[N][M];
		input = new int[3];
		monsterCnt = 0;
		ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					monsterCnt++;
				}
				onemap[i][j] = temp;
			}
		}
		comb(0, 0);
		if (ans == Integer.MIN_VALUE) {
			System.out.println(0);
		} else
			System.out.println(ans);

	}

	private static void comb(int idx, int start) {
		if (idx == 3) {
			// System.out.println(Arrays.toString(input));
			int temp = bfs(input);
			ans = Math.max(ans, temp);
			return;
		}

		for (int i = start; i < M; i++) {
			input[idx] = i;
			comb(idx + 1, i + 1);
		}

	}

	private static int bfs(int input[]) {
		int map[][] = deepcopy(onemap);
		Queue<Bowman> q = new LinkedList<>();
		attack = new ArrayList<>();
		int KillingCnt = 0;

		for (int i = 0; i < input.length; i++) {
			q.add(new Bowman(N, input[i]));
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				PriorityQueue<monster> mon = new PriorityQueue<>();

				Bowman now = q.poll();
				// 아래서 부터 index비교해서 쏠 수 있는 적을 확인하고
				// 큐에 넣기
				int dis = Integer.MAX_VALUE;
				int killing_X = -1;
				int Killing_Y = -1;
				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == 1) {// 거기 위치가 몬스터야?
							// 쏠 수 있는지 확인해
							int temp_dis = distance(now.x, i, now.y, j);
							if (D >= temp_dis) {
								dis = Math.min(dis, temp_dis);
								// min일 떄 값을 호출해야하는뎀 그렇지 못 하고 잇으니까 ㅋㅋ
							}
						}

					}
				} // 한명 공격 끝
				boolean flag = false;
				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == 1) {// 거기 위치가 몬스터야?
							// 쏠 수 있는지 확인해
							int temp_dis = distance(now.x, i, now.y, j);
							if (dis == temp_dis) {
								killing_X = i;
								Killing_Y = j;
								mon.add(new monster(killing_X, Killing_Y));
							}

						}

					}
				} // 한명 공격 끝

				if (killing_X != -1 && Killing_Y != -1) {
					monster nowMon = mon.poll();
					attack.add(new Bowman(nowMon.x, nowMon.y));
				}

				q.add(new Bowman(now.x, now.y));

			} // 1초 지났으면

			// 공격하고
			for (int i = 0; i < attack.size(); i++) {
				Bowman now = attack.get(i);
				if (map[now.x][now.y] == 1) {
					map[now.x][now.y] = 0;
					// System.out.println("now.x " + now.x + " now.y " + now.y);
					KillingCnt++;
					monsterCnt--;
				}
			}
			attack.clear();

//			System.out.println("****************************************");
//			for (int temp[] : map) {
//				System.out.println(Arrays.toString(temp));
//			}
//			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
//			 공격 끝났으면 비워

			// 애들 옮기고

			map = move(map);

			if (cheak(map)) {
				break;
			}

		}
		return KillingCnt;

	}

	private static boolean cheak(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					return false;
				}

			}
		}
		return true;
	}

	private static int[][] deepcopy(int[][] onemap2) {
		int copyMap[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = onemap2[i][j];
			}
		}
		return copyMap;
	}

	private static int distance(int i, int si, int j, int sj) {
		return Math.abs(i - si) + Math.abs(j - sj);

	}

	private static int[][] move(int tempMap[][]) {
		int temp[] = new int[M];
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				temp[j] = tempMap[i][j];
			}
			for (int j = 0; j < M; j++) {
				tempMap[i + 1][j] = temp[j];
			}
		}
		for (int i = 0; i < M; i++) {
			tempMap[0][i] = 0;

		}

		return tempMap;
	}

}
