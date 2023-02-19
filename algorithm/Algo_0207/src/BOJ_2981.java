import java.util.Scanner;

public class BOJ_2981 {
	static int  a;
	static int  b;
	static int arr_1[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		//뺀 값을 저장하는 배열 선언
		
		arr_1 = new int[n-1];
		// 4개 5개 6개의 수를 한번에 비교하고 싶어..
		
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < arr_1.length; i++) {
			arr_1[i] = arr[i] - arr[i + 1];
		}
		
		
		System.out.println(euclidGCD(arr_1[0], arr_1[1])); // 1번 2번 인덱스 빼기 
					//2 번 인덱스 1번 인덱스 빼기  
		
		
	}
	
	
	public static int euclidGCD(int a, int b){
		int idx = 1;
		// a > b로 만들어주는 과정
		int tmp;
		if(a < b){
			tmp = b;
			b = a;
			a = tmp;
		}
		
		if(b == arr_1.length){     // b가 0일때 
			return a;     // a값은 최대공약수
		}
		System.out.println("1");
		return euclidGCD(a, arr_1[idx +1]);    // b와 a%b를 파라미터로 재귀호출
	}

}
