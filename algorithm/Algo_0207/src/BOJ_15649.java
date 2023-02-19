import java.util.Scanner;

public class BOJ_15649 {
	public static boolean[] used;
	public static int arr[];
	public static int result[];
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		arr = new int[N];
		used = new boolean[N];
		result = new int [R];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		perm(0);

	}

	public static void perm(int idx) {
		if (idx == R) {
			for(int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
			
		}

		for (int i = 0; i < arr.length; i++) {
			if(used[i]) continue; // 사용중이라면 무시하기 
			
			result[idx] = arr[i]; // 사용중인 숫자를 빼고 다른 숫자로 출력 
			used[i] = true;
			
			perm(idx +1);
			
			used[i] = false;
			
			
		}

	}
}
