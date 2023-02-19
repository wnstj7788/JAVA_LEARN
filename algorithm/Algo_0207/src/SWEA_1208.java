import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1 ; i <= 10; i++ ) {
			int dump = sc.nextInt();
			
			int arr[] = new int[100];
			
			for(int j = 0; j < 100; j++) {
				arr[j] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			for(int k = 0; k < dump ; k++) {
				arr[0] ++;
				arr[99] --;
				Arrays.sort(arr);
			}
			
			
			System.out.println("#" + i + " " + (arr[99] - arr[0]));
			
			
			
		}
		
		
	}
}
