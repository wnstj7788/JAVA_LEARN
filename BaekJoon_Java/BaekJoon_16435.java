import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_16435 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int L = sc.nextInt();

		int[] arr = new int[N]; //배열선언  

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt(); //배열 입력  
		}

		Arrays.sort(arr);// 배열 정렬   

		for (int i = 0; i < N; i++) {
			if (arr[i] <= L ) { //i값이 몸 길이보다 작거나 같다면 
				L++; //몸의 길이 늘리
				
			} else {
				break; //아니라면 멈추
			}
		}
		System.out.println(L);//몸 길이 출

	}
}

