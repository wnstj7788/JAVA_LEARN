import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1]; 

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1; // 1로 뻬기

			if (i % 3 == 0) // 3으로 나누어 떨어진다면
				dp[i] = Math.min(dp[i], dp[i / 3] + 1) ;
			if (i % 2 == 0) //2로 나누어 떨어진다면 
				dp[i] = Math.min(dp[i], dp[i / 2] + 1) ;
			

		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}
}
