import java.util.Arrays;
import java.util.Scanner;

public class BJ_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long m = sc.nextInt();

		long  arr[] = new long [n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		binarySerch(arr, m);

	}

	public static void binarySerch(long arr[], long k) {
		int max = arr.length;
		long lower = 0;
		long upper = arr[max - 1];
		long mid = 0;

		while (lower < upper) {
			long sum = 0;
			mid = (lower + upper) / 2;
			for (int i = 0; i < max; i++) {
				if (arr[i] - mid > 0) {
					sum += (arr[i] - mid);
				}
			}
			// System.out.println(mid);
			// System.out.println(sum);
			if (k > sum) {
				upper = mid;
//				System.out.println(ans);
//				System.out.println("나 이프 안에있다 ");
			} else {
				lower = mid + 1;
			}
		}
		System.out.println(upper - 1 );
	}

}