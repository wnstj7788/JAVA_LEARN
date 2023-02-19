import java.util.Scanner;

public class BOJ_10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		
		int cnt =0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == M) cnt ++;
		}
		
		System.out.println(cnt);
		
	}

}

