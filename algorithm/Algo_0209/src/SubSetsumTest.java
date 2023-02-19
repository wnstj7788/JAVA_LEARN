import java.util.Scanner;

public class SubSetsumTest {

	static int N, S, totalCnt; // 경우의 수
	static int[] input; // 입력받은 수 들
	static boolean[] isSelected; // 각 원소가 부분집합의 구성에 포함되었는지 여부

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt(); // 목표 합

		input = new int[N];

		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		generateSubSet(0, 0);

		System.out.println("총 경우의 수 " + totalCnt);
	}

	private static void generateSubSet(int cnt, int sum) {// Cnt : 직전까지 고려된 원소 수

		if (cnt == N  ) {
			if (sum == S) {

				totalCnt++;
				for (int i = 0; i < N; i++) {
					if (isSelected[i])
						System.out.print(input[i] + "\t");
				}
				System.out.println();

			}
			return;
		}

		// 유도 파트
		// 현재 원소를 부분집합의 구성에 포함
		isSelected[cnt] = true;

		generateSubSet(cnt + 1, sum + input[cnt]);

		// 현재 원소를 부분집합의 구성에 미포함
		isSelected[cnt] = false;
		generateSubSet(cnt + 1, sum);
	}

//	private static void generateSubSet(int cnt) {// Cnt : 직전까지 고려된 원소 수
//
//		if (cnt == N) {
//			int sum = 0;
//			// 부분집합의 요소들의 합 구하기
//			for (int i = 0; i < N; i++) {
//				if (isSelected[i])
//					sum += input[i]; // 그 녀석이 부분집합에 포함되어있다면 더할 것임
//			}
//
//			if (sum == S) {
//
//				totalCnt++;
//				for (int i = 0; i < N; i++) {
//					if (isSelected[i]) System.out.print(input[i] + "\t");
//				}
//				System.out.println();
//
//			}
//			return;
//		}
//
//		// 유도 파트
//		// 현재 원소를 부분집합의 구성에 포함
//		isSelected[cnt] = true;
//
//		generateSubSet(cnt + 1);
//
//		// 현재 원소를 부분집합의 구성에 미포함
//		isSelected[cnt] = false;
//		generateSubSet(cnt + 1);
//	}

}
