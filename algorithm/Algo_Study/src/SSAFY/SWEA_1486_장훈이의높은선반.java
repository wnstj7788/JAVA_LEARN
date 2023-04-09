package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWEA_1486_장훈이의높은선반 {

	// 조합을 통해 뽑은 수들을 전부 더 했을 때 작다면? 더 이상 진행하지 않음
	// 모든 조합을 수행해도 되는 문제인가?
	// 2초에 256MB 제공 최대 10,000명의 키 정보를 알려줌
	// 최악의 경우 2의 10000제곱 잘못 본거임  20이였음 
	// 백트래킹이 필요
	// 부분집합을 작은거부터 꺼내서 첫번째로 작은 수가 나온다면 break한다면 시작 절약가능\
	// 그냥 조합을 이용한다면?
	// 1자리 조합, 2자리 조합, 3자리 조합을 만들어 -> 그럼 작은거 부터 나오고
	// 작은게 나오면 바로 멈춰버리면될 것 같다.
	// start idx 를 for을 전체 길이만큼 for문 돌면서 + 1로 idx를 늘려줌
	// 가능할지도?
	static boolean isSelected[];
	static int cards[];
	static int tail[];
	static int B;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			tail = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tail[i] = Integer.parseInt(st.nextToken()); // 재료 넣어줌
			}
			result = Integer.MAX_VALUE;
			// 조합의 크기를 계속 생성해줌
			for (int combSize = 1; combSize <= N; combSize++) {
				cards = new int[combSize]; // 담을 수 있는 사이즈는 한개
				isSelected = new boolean[N]; // 뽑을 수 있는 재료는 5개
				comb(0, 0, combSize);
				
//				if (result != Integer.MAX_VALUE) {
//					break;
//				}

			}
			System.out.println("#" + tc + " " + result);

		}
	}

	private static void comb(int idx, int start, int size) {
		if (idx == size) {
			//System.out.println(Arrays.toString(cards));
			cal(cards);
			return;
		}

		for (int i = start; i < isSelected.length; i++) {
			isSelected[i] = true;
			cards[idx] = i;
			comb(idx + 1, i + 1, size);
			isSelected[i] = false;
		}

	}

	private static void cal(int[] cards) {
		int sum = 0;
		for (int i = 0; i < cards.length; i++) {
			sum += tail[cards[i]];
		}

		if (sum >= B) {
			result = Math.min(result,  sum - B);
		}
	}

}
