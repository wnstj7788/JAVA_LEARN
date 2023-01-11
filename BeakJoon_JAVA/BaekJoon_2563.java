
import java.util.Arrays;

import java.util.Scanner;

public class BaekJoon_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean map[][] = new boolean[100][100]; //100 * 100 맵 생

		int p = sc.nextInt();


		for (int pn = 0; pn < p; pn++) {
			int r = sc.nextInt(); 
			int c = sc.nextInt();

			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					map[i][j]= true; //색종이가 있는 구역이라면 해당 부분을 true로 변경 

				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == true) {
					cnt += 1;// 색종이 부분 카운트 
					

					
				}
			}
		}

		System.out.println(cnt);
	}

}
// 처음 접근 방식 int형 배열을 생성 한 뒤 +2가 되는 부분을 전체에서 마이너스 
// 위의 방식은 2장이 겹쳐있을 떄는 가능하지만 3장 4장이 겹쳐있다면 불가능한 방식임
//  boolean방식으로 배열 선언 후 색종이가 있는 위치를  True로 바꾸고 해당 값을 전체 카운트