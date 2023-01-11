import java.util.Arrays;
import java.util.Scanner;
public class BaekJoon_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); //줄 서 있는 인원 입
		
		
		int[] arr = new int[num];//인원 크기만큼의 배열 
		
		for(int i = 0; i <num; i++) {
			arr[i] = sc.nextInt(); //배열에 입력 받기
			}
		
		Arrays.sort(arr);// 배열 정렬  
		
		int total_time = 0;
		int sum = 0;
		for(int i =0; i < num; i++) {
			total_time += arr[i] + sum; //전체 시간은 전체시간 + 배열의 i번째 요소  + 현재 더하고 있는 값 
			sum += arr[i]; // 현재 더해지고 있는 
			
//		int num = sc.nextInt();
//		
//		
//		int[] arr = new int[num];
//		
//		for(int i = 0; i <num; i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//		Arrays.sort(arr);
//		
//		int total_time = 0;
//		int sum = 0;
//		for(int i =0; i < num; i++) {
//			total_time += arr[i] + sum;
//			sum += arr[i];

			
			
		}
		//1 2 3 3 4
		System.out.println(total_time);
		
		

		

	}

}
