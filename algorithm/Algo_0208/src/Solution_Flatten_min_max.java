import java.util.Scanner;

public class Solution_Flatten_min_max {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10;
		for(int tc=1; tc<=TC; tc++) {
			int dump = sc.nextInt();
			
			int[] boxes = new int[100];
			for(int i=0; i<100; i++) {
				boxes[i] = sc.nextInt();
			} // end input
			
			int min=1000, max=0, minIdx=-1, maxIdx=-1;;
			
			for(int d=0; d<dump; d++) { // 최대 dump횟수 진행 가능.
				min=1000; max=0; minIdx=-1; maxIdx=-1;
				for(int i=0; i<100; i++) {
					if(min>boxes[i]) {
						min = boxes[i];
						minIdx = i;
					}
					if(max<boxes[i]) {
						max = boxes[i];
						maxIdx = i;
					}
				} // 100개의 상자높이 중에 최저위치, 최고위치 찾기.
				
				boxes[maxIdx]--; // 상자 옮기기
				boxes[minIdx]++;
				
				if(boxes[maxIdx]-boxes[minIdx]<=1) break; // 이미 평탄화 완료라 덤프횟수 다 할 필요 없음.
			}
			
			// 마지막 덤프 수행 이후 최고높이와 최저높이 달라졌을 테니 다시 확인해서 높이차 출력하기.
			min=1000; max=0; minIdx=-1; maxIdx=-1;
			for(int i=0; i<100; i++) {
				if(min>boxes[i]) {
					min = boxes[i];
					minIdx = i;
				}
				if(max<boxes[i]) {
					max = boxes[i];
					maxIdx = i;
				}
			} // 100개의 상자높이 중에 최저위치, 최고위치 찾기.
			System.out.println("#"+tc+" "+(max-min));
		}			
	}
}