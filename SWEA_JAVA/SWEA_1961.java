import java.util.*;

public class SWEA_1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1; t <= test; t++) {
			int n = sc.nextInt();//n 크기의 2차원 배열을 만들기 위해 n을 입력받
			int[][] a = new int[n][n];  // n*n크기의 2차원 배열 선
			for(int i = 0; i < n; i++) { //2차원 배열의 행  1첫째 줄
				for(int j = 0; j < n; j++) { //2차원 배열의 열  1첫째 줄의 1첫번째 요소....n번째 요 
					a[i][j] = sc.nextInt(); //해당 위치에 값을 집어넣음 
				}
			}
			System.out.println("#" + t + " "); //출력 형식에 맞추기 위하여 출력
			
			
//			1) 90도인 경우
//
//			맨 아랫줄, 즉 i값이 n-1부터 0으로 올라오며 그 값을 각 문자열 배열의 첫 번째 값으로 적어준다. 이때 하나씩 적고 바로 다음 줄로 넘겨야 한다.
//
//			 
//
//			2) 180도인 경우
//
//			90도인 경우와는 다르게 한 줄에 j값을 n-1부터 다 적어준 후에 다음 줄로 넘어간다. i값은 동일하게 n-1부터 움직인다.
//
//			 
//
//			3) 270도인 경우
//
//			위의 경우들과 다르게 i값이 오름차순이며 90도인 경우와 동일하게 하나씩 적고 다음줄로 넘겨준다.
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(a[n-j-1][i]);
				}
				System.out.print(" ");
				for(int j = 0; j < n; j++) {
					System.out.print(a[n-i-1][n-j-1]);
				}
				System.out.print(" ");
				for(int j = 0; j < n; j++) {
					System.out.print(a[j][n-1-i]);
				}
				System.out.println();
			}
		}
	}
}