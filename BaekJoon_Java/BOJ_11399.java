import java.util.Scanner;

public class BOJ_11399 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int total = 0;
		int sum =0;
		int arr[] = new int[n];
		
		for(int i =0 ; i< n; i++) {
			arr[i] = sc.nextInt();
			}
		
		
		for(int i = 0; i <n-1; i++) {
			for(int j = 0; j< n-1-i ; j++) {
				
				if(arr[j]> arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		
		
		
		for(int i =0; i < n; i++) {
			total += arr[i] + sum; //전체 시간은 전체시간 + 배열의 i번째 요소  + 현재 더하고 있는 값 
			sum += arr[i]; // 현재 더해지고 있는 
		}
		 
		System.out.println(total);	
		
		
		
	}
	
	

}
