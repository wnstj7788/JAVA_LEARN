import java.util.Scanner;


public class SWEA_1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //입력이 가능하게 선
		int test_case = sc.nextInt(); //테스트 케이스 정의 
		
		int N, M, totalMax, tempToal;
		
		int[] A, B; // 빈 배열 선언 
		
		for(int t = 0; t < test_case; t++) {
			totalMax = 0;
			N = sc.nextInt(); M = sc.nextInt(); // n,m 배열의 길이를 입력 
			A = new int[N]; B = new int[M]; // 길이 만큼의 배열을 선
			
			for(int i = 0; i < N ; i ++ ) {  //N길이 만큼 입력 
				A[i] = sc.nextInt(); //nextInt를 이용하면 공백과 줄바꿈 모두 입력 가능 
				
			}
			
			for(int j = 0; j < M; j++) {
				B[j] = sc.nextInt();
			}
			
			//N의 배열이 더 클 경우 배열을 바꿔줘야함 
			if(N > M) {
				int temp = N; N = M; M = temp; 
				int[] tempArr = A; A = B; B = tempArr;
			}
			
			for(int k = 0; k <= Math.abs(M - N); k ++) { // 긴배열에서 작은 배열만큼 뺀 절대값 만큼만 이동하기 
				tempToal = 0;
				for(int z = 0; z < N; z++) {
					tempToal += A[z] * B[k+ z];
				}
				if (totalMax < tempToal) {
					totalMax = tempToal;
				}
				
				
			}
		
			System.out.printf("#%d %d\n", t + 1, totalMax); //println은 엔터키 포함되어있어 사용불가능 
	
		}
		
		
		
		
	}

}
 