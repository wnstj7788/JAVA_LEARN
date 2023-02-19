import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10972 {
	static int N;
	static boolean used[]; 
	static int nums[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i =0; i < N; i++) {
			nums[i] = i+1;
		}
		
		int test_arr[] = new int [N];
		
		
		
		for(int i =0; i < N; i++) {
			test_arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(test_arr));

	}
	
	
	
	public static void perm(int cnt) {
		
		if(cnt == N) {
			System.out.println(Arrays.toString(nums));
		}
		
		for(int i =0; i < N; i++) {
			if(used[i]) continue;
			
			nums[cnt] = i+1;
			used[i] = true;
			perm(cnt +1 );
			used[i] = false;
		}
		
	}
}
