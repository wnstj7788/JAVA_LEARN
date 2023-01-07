import java.util.Scanner;

public class SWEA_1209 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int testcase = 1; testcase <=10; testcase ++) { //테스트 케이스 말은 문제에 없지만 답안 제출시 10번 테스트를 하기에 추가해줘야함 
			int testNum = sc.nextInt(); 
			
			int[][] arr = new int[100][100]; //100 * 100 2차원 배열 선
			
			
			for(int r = 0; r < 100; r++) {  //2차원 배열에 값 입력 받아 넣
				for(int c = 0; c < 100; c++) { 
					arr[r][c] = sc.nextInt(); 
				}
			}
			
	
			int rowSum = 0, rowMax = 0, colSum = 0, colMax = 0, diaMax = 0, totalMax = 0; // 각 행 열 대각선의 합을 저장하고 최대값과 비교하기 위한 변수 선
			
			for(int i = 0; i < 100; i++) { 
				rowSum = 0; colSum =0;// 다른 행으로 넘어가기 위해 다시 초기와 
				for(int j = 0; j < 100; j++) {
					rowSum += arr[i][j]; //행의 값을 더
					colSum += arr[j][i];
				}
				if(rowMax < rowSum) {
					rowMax = rowSum; //비교 후 최대값 넣기 
				}
				if(colMax < colSum) {
					colMax = colSum; //비교 후 최대값 넣기 
				}
				
			}
//			for(int i = 0; i < 100; i++) {
//				colSum = 0; // 다른 열으로 넘어가기 위해 초기화  
//				for(int j = 0; j < 100; j++) {
//					colSum += arr[j][i]; //열의 값을 더함 
//				}
//				if(colMax < colSum) {
//					colMax = colSum;
//				}			
//			}
			for(int i =0; i <100; i++) {
				diaMax += arr[i][i]; // 대각선 연산은 한번 
			}
			
			totalMax = rowMax;
			if(totalMax < colMax) totalMax = colMax; 
			if(totalMax < diaMax) totalMax = diaMax; // 가장 큰 값을 totalMax에 삽
			System.out.println("#" + testNum + " "+ totalMax);
		}
		
		
	}	
}
