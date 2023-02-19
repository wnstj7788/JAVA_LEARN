import java.util.Arrays;
import java.util.Scanner;

public class comb_perm_subset {

	static String cards[];
	static boolean used[];
	static String result[];
	static int N, M;
	static int count = 0;
	static String subsetResult[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		cards = new String[N];
		used = new boolean[N];
		result = new String[M];

		for (int i = 0; i < N; i++) {
			cards[i] = sc.next();
		}

//		perm(0);
		// comb(0,0);
		subset(0);
		System.out.println(count);

	}

	// 순열
	// 모든 경우의 수 : 순서가 의미가 있다 , 중복을 허용하지 않음
	// 1,2,3 3,2,1 2,1,3 이 모두 다른 경우를 의미 -> m개로 만들 수 있는 완전 탐색
	static void perm(int cnt) {
		if (cnt == M) {
			count++;
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < cards.length; i++) {
			if (used[i])
				continue;
			result[cnt] = cards[i];
			used[i] = true;
			perm(cnt + 1);
			used[i] = false;

		}
	}

	// 조합은 1,2 -> 2,1 순서를 고려하지 않는다 : 그냥 원소의 값이 같으면 같은거야
	// 중복을 허용하지 않아 -> 방문 체크를 해줘야해
	// START값을 늘리는게 아니고 I의 값을 늘려야한다는 것에 유의할 것
	static void comb(int cnt, int start) {
		if (cnt == M) {
			count++;
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = start; i < N; i++) {
			result[cnt] = cards[i];
			comb(cnt + 1, i + 1);

		}

	}

	// 부분 집합
	// 모든 경우의 수 0~M로 만들 수 있는 모든 경우의 수인데 중복은 허용되지 않음
	// 0 ,1,12,13,23,123 등

	static void subset(int cnt) {
		// 모든 경우를 고려하기 때문에 배열이 가득찾다면 반환하는 함수 작성
		if (cnt == N) {
			count++;
			for (int i = 0; i < N; i++) {
				if (used[i])// 해당 부분을 사용중이라면
					System.out.print(cards[i] + " ");
				else
					System.out.print("X " );
			}
			System.out.println();
			return;
		}

		used[cnt] = true;
		subset(cnt + 1); // 현재원소 사용해서 출발
		used[cnt] = false; //
		subset(cnt + 1); // 현재원소 사용한하고 출발

	}

}