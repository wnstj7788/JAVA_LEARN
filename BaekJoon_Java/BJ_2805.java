import java.util.Arrays;
import java.util.Scanner;

public class BJ_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); //나무의 갯수를 입력 받는다 
		long m = sc.nextInt(); // 목표로하는 원하는 길이 

		long  arr[] = new long [n]; 

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr); //정렬하기 

		binarySerch(arr, m); 

	}

	public static void binarySerch(long arr[], long k) {
		int max = arr.length;
		long lower = 0; //시작은 0부터해야한다
		long upper = arr[max - 1]; //가장 큰 
		long mid = 0;

		while (lower < upper) {
			long sum = 0;
			mid = (lower + upper) / 2;
			for (int i = 0; i < max; i++) { 
				if (arr[i] - mid > 0) {
					sum += (arr[i] - mid);  //현재 mid값으로 잘랐을 때 챙겨갈 나무의 길이 
				}
			}
			// System.out.println(mid);
			// System.out.println(sum);
			if (k > sum) { //챙겨갈 나무의 길이가 목표로 하는것보다 작다면! 거기서 우리는 -1한 값이 우리가 원하는 정답 
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