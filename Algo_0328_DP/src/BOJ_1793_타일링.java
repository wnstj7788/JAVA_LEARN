import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1793_타일링 {

	
	private static long memo[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(sc.hasNextInt()){
	           int n = Integer.parseInt(sc.next());
	   		memo = new long[n+1];
			Arrays.fill(memo, -1);
			memo[0] = 0;
			memo[1] = 1;
			memo[2] = 3;
			
	          System.out.println(memo[n]);
	    }
		

		
		

		
		
		
	}
	
	private static long  cal(int n) {
		
		if(memo[n] == -1) {
			memo[n] = cal(n-1) + cal(n-2)*2;
		}
		return memo[n];
		
	}
}
