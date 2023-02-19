import java.util.Scanner;

public class SWEA_5215 {

	public static int food_ca[][];
	public static int calorie;
	public static int ingredient;
	public static int maxCalorire;

	public static void main(String[] args) {
		// 민기의 햄벅 재료에 대한 점수와 칼로리
		// 정해진 칼로리 안에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램 작성

		// 중복 조합을 통해 1 ~ 5개 사이의 재료 선택해서 도합 칼로리를 넘지 않으면 된다

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			ingredient = sc.nextInt();

//		food = new int[ingredient];
//		food_ca = new int[ingredient];
			// 2차원 배열로 만들기
			// 음식, 칼로리를 저장할 배열 생성

			food_ca = new int[ingredient][2];

			// 제한할 칼로리
			calorie = sc.nextInt();

			for (int i = 0; i < ingredient; i++) {
				food_ca[i][0] = sc.nextInt();
				food_ca[i][1] = sc.nextInt();
			}

			maxCalorire = 0;
			duplicate(0, 0, 0);

			System.out.println("#" + tc + " " + maxCalorire);

		}
	}

	public static void duplicate(int idx, int scr, int cal) {
		// 칼로리 초과
		if (cal > calorie)
			return;
		// 주어진 제한 칼로리 이하의 조합
		if (cal <= calorie)
			maxCalorire = Math.max(maxCalorire, scr);
		// 모두 조합을 확인
		if (idx == ingredient)
			return;

		// 재료 사용
		duplicate(idx + 1, scr + food_ca[idx][0], cal + food_ca[idx][1]);
		// 재료 사용 x

		duplicate(idx + 1, scr, cal);
	}
}
