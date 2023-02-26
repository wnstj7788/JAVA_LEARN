import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_6987_월드컵 {
	static int total;
	static int win;
	static int defeat;
	static int draw;
	static int cnt = 0;
	static int drawArr[] = new int[6];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int N = 0; N < 4; N++) {
			win = 0;
			defeat = 0;
			draw = 0;
			cnt = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (j == 0)
						win += sc.nextInt();
					else if (j == 1) {
						int A = sc.nextInt();
						draw += A;
						drawArr[cnt] = A;
						cnt++;
						// System.out.println("cnt" + cnt);
					} else
						defeat += sc.nextInt();

				}
			}

			//System.out.println(Arrays.toString(drawArr));
			if (win + defeat + draw == 30 && win == defeat && OkOrNo(drawArr)) {
				// draw가 분산되어있는지 확인해야지 = 쌍을 이루는지
				System.out.print("1" + " ");
			} else
				System.out.print("0" + " ");
		}

	}

	static boolean OkOrNo(int arr[]) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < 6; i++) {
			if (arr[i] != 0) {
				sum += arr[i];
				count += 1;
			}

		}
		if (count == 1) {
			return false;

		}
		if (cnt % 2 != 0) {
			if (sum % 2 != 0) {
				return false;
			}
		}
		return true;

	}

}