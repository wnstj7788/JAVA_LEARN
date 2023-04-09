package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWEA_2112_보호필름 {
	static int D, W, K;
	static int map[][];
	static boolean isSelected[];
	static int cards[];
	static int result;

	// 애도 비슷한 문제다

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			isSelected = new boolean[D];

			// 0 => A , 1=> B
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			result = Integer.MAX_VALUE;

			for (int card = 0; card <= D; card++) {

				cards = new int[card];
				isSelected = new boolean[D];
				comb(0, 0, card);

			}
			System.out.println("#" + tc + " " + result);

		}

	}

	private static void comb(int idx, int start, int card) {
		if (idx == card) {
//			System.out.println(Arrays.toString(cards));

			cheak(cards); // 여기서 체크해주면 끝남
			return;
		}

		for (int i = start; i < D; i++) {
			isSelected[i] = true;
			cards[idx] = i;
			comb(idx + 1, i + 1, card);
			isSelected[i] = false;
		}

	}

	private static void cheak(int[] cards) {
		// 여기서 체크만 해주면 끝남
		// 아무것도 안고른 경우는 체크 안해주나?
		// 해줘야겠지... 이걸 어떻게 처리할거냐
		// 연산을 중복해서 하기 싫으니까 comb 들어오기전에 아무것도 안하고 진행하는 경우를 진행 한 후 시작을 하자
		// 0이 연속 3개이면 다음거 가고 여기서 아니라면 멈춰
		// 1이 연속 3개이면 다음거 가고 여기서 아니라면 멈춰
		// 전부다 아니라면 다음 경우의 수를 진행해야함
		// 이거 하드코딩해야하는 부분인가?
		// 다 고려한거 맞아??

		for (int medi = 0; medi <= 1; medi++) {
			int copyMap[][] = deepCopy();
			if (medi == 0) {
				for (int i = 0; i < cards.length; i++) {
					for (int j = 0; j < 2; j++) {
						if (j == 0) {
							Arrays.fill(copyMap[cards[i]], 0);
							resultset(copyMap);
						} else {
							Arrays.fill(copyMap[cards[i]], 1);
							resultset(copyMap);
						}

					}
				}
//				for(int temp[] : copyMap) {
//					System.out.println(Arrays.toString(temp));
//				}
//				System.out.println("+++++++++++++++++++++++++++++++++++++++++");

			} else if (medi == 1) {
				for (int i = 0; i < cards.length; i++) {
					for (int j = 0; j < 2; j++) {
						if (j == 0) {
							Arrays.fill(copyMap[cards[i]], 1);
							resultset(copyMap);
						} else {
							Arrays.fill(copyMap[cards[i]], 0);
							resultset(copyMap);
						}

					}
				}
			}

		}

		if (cards.length == 0) {
			resultset(map);
		}
	}

	private static void resultset(int copyMap[][]) {
		for (int i = 0; i < W; i++) {
			int cnt = 1;
			boolean flag = false;
			for (int j = 1; j < D; j++) {
				if (copyMap[j][i] == copyMap[j - 1][i]) {
					cnt++;
					if (cnt == K) {
						flag = true;
						break;
					}
					if (cnt > K) {
						flag = false;
					}

				} else if (K == 1) {
					if (copyMap[j][i] != copyMap[j - 1][i]) {
						result = 0;
					}

				}

				else {
					cnt = 1;

				}

			}
			if (!flag) {
				break;
			}
			// 행을 다 돌았는데 false면 그냥 종료

			if (i == W - 1) {
				if (flag == true) {
//						System.out.println("나 들어옴 " +cards.length );
					int len = cards.length;

//						System.out.println( result  + "result   " + "len" + len);
					result = Math.min(result, len);
//						System.out.println(result + "나 결과 ");
				}

			}

		}

	}

	private static int[][] deepCopy() {
		int copyMap[][] = new int[D][W];
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}

}
