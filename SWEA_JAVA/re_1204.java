import java.util.Scanner;

//1000명의 수학 성적을 입력받아 최빈수를 출력하는 프로그램 0~100사이의 값  

public class re_1204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[101];
			
			for(int j = 0; j <= 1000 ;j++) {
				arr[sc.nextInt()]++;
				
			}
			
			int max = 0;
			int index = 0;
			
			for (int k = 0; k < arr.length; k++) {
				if(max <= arr[k]) {
					max = arr[k];
					index = k;
				}			
				
			}
			System.out.println("#"+ n + index );
		}
		
		
		

	}

}
