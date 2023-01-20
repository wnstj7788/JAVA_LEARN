
import java.util.Scanner;

public class BJ_4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
	
		for(int i =0; i < tc; i++) {
			int num = sc.nextInt();
			int arr[] = new int[num];
			int sum = 0;
			int cnt = 0;
			
			for(int j =0; j < num; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			double avg = sum / num;
		
			
			for(int j =0; j < num; j++) {
				if(arr[j] > avg) {
					cnt += 1;
				}
			}
			double result = 100.0 * cnt / num;
			
			System.out.println(String.format("%.3f", result) + "%" );
		}
		
	
	}
}
