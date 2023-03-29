import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2294_동전2 {

	private static int cointype[];
	private static int coin[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		cointype = new int[N];
		coin = new int[K + 1];
		for (int i = 0; i < N; i++) {
			cointype[i] = sc.nextInt();
		}
		Arrays.fill(coin, 100000);
		coin[0] = 0;

		cal(N, K);
//		System.out.println(Arrays.toString(cointype));
//		System.out.println(Arrays.toString(coin));
//		System.out.println(coin[K -1]);
		if(0 <= coin[K] && coin[K] <= K) {
			System.out.println(coin[K]);
		}else {
			System.out.println(-1);
		}

	}

	private static void cal(int n, int k) {
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= cointype[j] ) {
//					System.out.println("왜 안들어옴?"+cointype[j] +"  j :"+  j +" i : " + i );
//					System.out.println(coin[i - 1]  + "coin + 1");
//					System.out.println(coin[i-cointype[j]] +1 +"연산 후  ");
					
					coin[i] = Math.min(coin[i] ,coin[i-cointype[j]] +1 );
//					System.out.println("coin[i]의 값" + coin[i] + "i" +i);
				}
				
			}

		}

	}

}
