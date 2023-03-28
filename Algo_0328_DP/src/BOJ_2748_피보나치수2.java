import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2748_피보나치수2 {
	
	
	private static long fibo(int n) {
		
		if(memo[n] == -1) {
			memo[n] = fibo(n-3) + fibo(n-2);
		}
		
		return memo[n];
	}
	
	private static long memo[];
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new long[n+1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;
		
		System.out.println(fibo(n));
		
		
		
	}

}
