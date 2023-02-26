import java.util.Scanner;

//제곱 연산의 차이 확인하기 위한 작업 
//2의 100승을 보면 1은 100번  2는 7번만에 결과를 호출 할 수 있다 


public class DivideTest {

	private static int callcnt1, callcnt2;

	private static long exp1(long x, long n) {
		callcnt1++;

		if (n == 1)
			return x;
		return x * exp1(x, n - 1);

	}

	private static long exp2(long x, long n) {
		callcnt2++;

		if (n == 1)
			return x;

		long y = exp2(x, n / 2);

		return n % 2 == 0 ? y * y : y * y * x;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int n = sc.nextInt();
		
		
		System.out.println(exp1(x,n));
		System.out.println(callcnt1);
		System.out.println(exp2(x,n));
		System.out.println(callcnt2);

	}

}
