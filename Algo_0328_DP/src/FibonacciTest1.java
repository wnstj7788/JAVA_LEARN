import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest1 {
	
	private static long callCnt1,callCnt2;
	
	
	
	
	
	
	//non - memo 
	private static long fibo1(int n) {
		callCnt1++;
		//기저
		if(n <=1) return n;
		//유도
		return fibo1(n-1) + fibo1(n-2);
	}
	
	
	
	
	
	//n항에 대한 값을 메모
	// n(index) : 원소(값)
	private static long[] memo;
	private static long fibo2(int n) {
		callCnt2++;
		if(memo[n] == -1) {
			//메모가 되지 않은 상태 -> 메모해야함 
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		memo = new long[n+1];
		Arrays.fill(memo, -1);
		// 메모되지 않은 값을 세팅해줌 (초기화)
		memo[0] = 0; // 피보나치 첫 값 세팅 
		memo[1] = 1;
		
		
		System.out.println(fibo2(n));
		System.out.println(callCnt2);
		System.out.println("---------------------------------------");
//		System.out.println(fibo1(n));
//		System.out.println(callCnt1);
	}

}
