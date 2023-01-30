import java.util.Scanner;

public class SWEA_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			int sum = 0; // 전체 합을 저장할 변
			int n = sc.nextInt();
			int map[][] = new int[n][n]; // 저장할 데이터

			for (int i = 0; i < n; i++) {
				String str = sc.next(); // 공백 없이 들어오기 때문에 문자열로 저장
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j) - '0'; // int형으로 저장하기 
				}
			}

			// 상단 삼각형 순회하며 더하기
			for (int i = 0; i < n / 2; i++) {
				for (int j = n / 2 - i; j <= (n / 2 + i); j++) {
					sum += map[i][j];
				}

			}
			// 하단 삼각형 순회하며 더하기 
			for (int i = n / 2; i >= 0; i--) {
				for (int j = n / 2 - i; j <= n / 2 + i; j++) {
					sum += map[n - i - 1][j];
				}
			}
			System.out.printf("#%d %d", t+1, sum);
			System.out.println("");
		}				

	}

}
