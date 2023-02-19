import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {

	
	//nPn상황에서만 가능하다 ㅋ ㅋ ㅋ ㅋ ㅋ ㅋ ㅋ ㅋ ㅋ 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] input = new int[N];

		for (int i = 0; i < N; ++i) {
			input[i] = sc.nextInt();
		}
		// 전처리 오름차순
		Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
			
		} while (np(input));
	}
	
	
	private static boolean np(int[] input) {
		
		int n = input.length;
		
		//step1. 뒷쪽부터 꼭대기를 찾는다 ( 꼭대기 바로 앞이 교환할 자리 )
		int i  = n-1;
		while(i > 0 && input[i-1] >= input[i]) --i;
		if(i == 0 ) return false;
		
		//step2. 꼭대기 바로 앞(i-1 자리에 교환할 값을 뒤쪽부터 찾는다.
		 int j = n -1;
		 
		 while(input[i-1]>=input[j]) --j; 
		 
		 //stepp3. 꼭대기 바로 앞 (i-1) 자리와 그 자리 값보다 한단계 큰 자리(j)수와 교환
		swap(input,i-1,j);
		
		//step4.  꼭대기부터 매 ㄴ뒤까지 오름차순으로 정렬하자 
		int k = n-1;
		while(i < k) {
			swap(input, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;

	}

}
