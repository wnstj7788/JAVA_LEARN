import java.util.Scanner;

import javax.crypto.Cipher;

public class sliding_window {
	static int[] sushi, count;
	static int N, d, k, c; // 총 접시, 초밥번호, 연속 접시 수 , 쿠폰
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		c = sc.nextInt();

		sushi = new int[N];

		for (int i = 0; i < N; i++) {
			sushi[i] = sc.nextInt();
		}

		count = new int[d + 1]; // 초밥 번호가 d번까지 있음

		count[c]++;
		int tmp = 1; // 먹은 초밥 가지수 (쿠폰에 있는 초밥은 무조건 먹음)
		for (int i = 0; i < k; i++) {
			if (count[i] == 0) {
				tmp++; // 가지수 증가
			}

			count[sushi[i]]++; // 해당 초밥 카운트

		}

		for (int s = 1; s < N; s++) { // 이제 다음 구간의 시작위치를 s부터로 하자
			count[sushi[s - 1]]--; // 새로운 시작위치 바로 앞 접시 초밥 뱉엉
			if (count[sushi[s - 1]] == 0) // 이 초밥 딱 한번 먹었구낭
				tmp--;

			int newDish = (s + k - 1) % N;// 이제 저 뒤에 새로 먹게되는 접시 번호
			if (count[sushi[newDish]] == 0) {
				tmp++;
			}
			count[sushi[newDish]]++;

			ans = Math.max(ans, tmp);
		}

		System.out.println(ans);
	}

}
