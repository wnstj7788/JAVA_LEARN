import java.util.Scanner;

public class BOJ_11659_부분합구하기4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int arr[] = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		
		
		for (int i = 0; i <	M; i++) {
			int I = sc.nextInt();
			int J = sc.nextInt();
			
			System.out.println(arr[J] - arr[I-1]);
		}
		
	}

}
