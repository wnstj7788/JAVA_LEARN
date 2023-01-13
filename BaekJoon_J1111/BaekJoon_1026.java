import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BaekJoon_1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] arr_a = new int[n];
		int [] arr_b = new int[n];
		
		for(int i = 0; i <n ; i++) {
			arr_a[i] = sc.nextInt();
		}
		for(int i = 0; i <n ; i++) {
			arr_b[i] = sc.nextInt();
		}
		
		Arrays.sort(arr_a);
		Integer[] arr_b2 = Arrays.stream(arr_b).boxed().toArray(Integer[]::new);
		Arrays.sort(arr_b);
		int sum = 0;
		for(int i = 0; i <n; i++) {
			sum += arr_a[i] * arr_b[n-1 - i];
		}
		System.out.println(sum);
	}

}