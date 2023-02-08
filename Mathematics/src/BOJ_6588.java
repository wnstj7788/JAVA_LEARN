
import java.util.Arrays;

public class BOJ_6588 {

	public static int n = 1000000; // 2 ~ 100까지의 모든 수 소수 판별
	public static boolean[] arr = new boolean[n + 1];

	public static void main(String[] args) {
		Arrays.fill(arr, true); // 모든 수가 소수(true)라고 초기화
		
		// 에라토스테네스의 체 알고리즘
		for (int i = 2; i <= Math.sqrt(n); i++) { // 2부터 n의 제곱근까지의 모든 수 확인
			if (arr[i] == true) { // i가 소수면
				int j = 2; // i * 2, i * 3, ... i의 배수 지우기
				while (i * j <= n) {
					arr[i * j] = false; // 지워진 배수 false로
					j += 1;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (arr[i]) { // 소수(true)인 것만
				System.out.print(i + " "); // 출력
			}
		}
	}
}
