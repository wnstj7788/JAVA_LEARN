import java.util.Arrays;
import java.util.Scanner;

public class Solution_Flatten_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10;
		for(int tc=1; tc<=TC; tc++) {
			int dump = sc.nextInt();
			
			int[] boxes = new int[100];
			for(int i=0; i<100; i++) {
				boxes[i] = sc.nextInt();
			} // end input
			
			for(int d=0; d<dump; d++) { // 최대 dump횟수 진행 가능.
				Arrays.sort(boxes);
				
				boxes[99]--; // 상자 옮기기
				boxes[0]++;
				
				if(boxes[99]-boxes[0]<=1) break; // 이미 평탄화 완료라 덤프횟수 다 할 필요 없음.
			}
			
			// 마지막 덤프 수행 이후 최고높이와 최저높이 달라졌을 테니 다시 확인해서 높이차 출력하기.
			Arrays.sort(boxes);
			System.out.println("#"+tc+" "+(boxes[99]-boxes[0]));
		}			
	}
}