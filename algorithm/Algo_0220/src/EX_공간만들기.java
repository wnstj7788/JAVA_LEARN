

import java.util.Scanner;

/**
 * @author THKim
 */
public class EX_공간만들기 {
	static int white = 0;
	static int green = 0;
	static int[][] spaces;

	// 주어진 영역의 공간의 셀 체크하여 모두 초록색이나 하얀색으로 이루어져있는지 확인 후
	// 4개로 쪼개기.
	// 하얀색 0 , 초록색 1
	static void cut(int r, int c, int size) {

		int sum = 0;
		for (int i = 0, rEnd = r + size; i < rEnd; i++) {
			for (int j = 0, cEnd = c + size; j < cEnd; j++) {

				sum += spaces[i][j];
			}
		}

		if (sum == size * size) {// 초록 모두
			green++;
		} else if (sum == 0) {
			white++;
		} else { // 색상 홍합 상황
			// 4분할 하기

			int half = size / 2;
			cut(r, c, half);
			cut(r, c + half, half);
			cut(r + half, c, half);
			cut(r + half, c + half, half);

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		spaces = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}
		cut(0,0,n);
		System.out.println(white);
		System.out.println(green);
		sc.close();
	}
}
