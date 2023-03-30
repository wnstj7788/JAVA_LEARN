import java.util.Scanner;

public class KnapsackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 물건의 수
		int W = sc.nextInt();// 가방의 목표 무게

		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}

		int[][] D = new int[N + 1][W + 1];

		// 초기 값 세팅: int [][]배열의 자동 초기화 이용

		for (int i = 1; i <= N; i++) { // 물건
			for (int w = 1; w <= W; w++) { // 가방의 무게
				// 해당 물건의 무게가 w를 초과하는지
				if (weights[i] > w) { // 못 넣을 떄
					D[i][w] = D[i - 1][w];
				} else { // 넣을 수 있을 때 -> 넣고 안넣고를 비교
					D[i][w] = Math.max(D[i - 1][w], D[i - 1][w - weights[i]] + profits[i]);
				}

			}
		}
		System.out.println(D[N][W]);

	}
	
	 

}
