import java.util.Arrays;
import java.util.Scanner;

// 입력으로 주사위 던저기 모드를 받는다 (1,2,3,4)
// 던지는 주사위 수도 입력 받는다.( 1<= N <=10) 

public class Ex_DiceTest {

	static int N; // 던지는 주사위 수
	static int[] numders; // 각각의 주사위 눈
	static int totalCnt; // 경우의 수
	static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		N = sc.nextInt();

		numders = new int[N];

		switch (mode) {
		case 1: // 중복순열
			dice1(0);
			break;
		case 2: // 순열
			used = new boolean[7]; // 0 1 2 3 4 5 6 -> 0번 인덱스 사용을 안하기 위해서
			// 자동 초기화가 발생 : false
			dice2(0);

			break;

		case 3: // 중복 조합
			dice1(0);
			break;
		case 4: // 조합
			dice4(0, 1);
			break;

		}
		System.out.println(" 총 경우의 수 : " + totalCnt);
	}

	private static void dice1(int cnt) {// cnt: 기존까지 던져진 주사위 수 ==> 현재 주사위의 수를 기록하기 위한 인덱스로 사용

		if (cnt == N) {// 던져진 주사위가 목표 수가 되었다면 더이상 던질 주사위 없음
			System.out.println(Arrays.toString(numders));
			totalCnt++; // 뭔 의미임?
			return;
		}

		// 주사위의 눈은 1- 6의 경우가 있음
		for (int i = 1; i <= 6; i++) {

			numders[cnt] = i;
			// 다음 주사위던지러 가기
			// cnt += 1; 이렇게 하면 안된다 why? 한번 던질 때마다 카운트가 올라가게 되는거임 1 2 3 4 5 6
			dice1(cnt + 1);
		}

	}

	private static void dice2(int cnt) {
		if (cnt == N) {
			System.out.println(Arrays.toString(numders));
			totalCnt++;
			return;
		}

		for (int i = 1; i <= 6; i++) {
			// 중복체크
			if (used[i])
				continue; // 사용되고 있으면 사용안함

			numders[cnt] = i;
			used[i] = true;
			dice2(cnt + 1);
			used[i] = false;
		}

	}

	// 중복 조합
	private static void dice3(int cnt, int start) { // cnt: 기존까지 던져진 주사위 수 , start : 현 주사위의 눈의 시작
		if (cnt == N) {
			System.out.println(Arrays.toString(numders));
			totalCnt++;
			return;
		}
		for (int i = start; i <= 6; i++) {
			numders[cnt] = i;
			dice3(cnt + 1, i);

		}
	}

	// 조합
	private static void dice4(int cnt, int start) { // cnt: 기존까지 던져진 주사위 수 , start : 현 주사위의 눈의 시작
		if (cnt == N) {
			System.out.println(Arrays.toString(numders));
			totalCnt++;
			return;
		}
		for (int i = start; i <= 6; i++) {
			numders[cnt] = i;
			dice4(cnt + 1, i + 1);

		}
	}

}
