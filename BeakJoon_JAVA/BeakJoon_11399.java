import java.util.Arrays;
import java.util.Scanner;
public class BeakJoon_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		
		int[] arr = new int[num];
		
		for(int i = 0; i <num; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int total_time = 0;
		int sum = 0;
		for(int i =0; i < num; i++) {
			total_time += arr[i] + sum;
			sum += arr[i];
			
			
		}
		//1 2 3 3 4
		System.out.println(total_time);
		
		

		

	}

}
