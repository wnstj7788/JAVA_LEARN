import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[][] = new int[n + 1][3]; 
		int map[][] = new int[n + 1][3]; 

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = dp[0][1] = dp[0][2] = map[0][0] = map[0][1] = map[0][2] = 0;

		for (int i = 1 ; i <= n; i++) {                               
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0]; 
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1]; 
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2]; 
		}
		System.out.println(Math.min(dp[n][2],(Math.min(dp[n][0], dp[n][1]))));
	}
}