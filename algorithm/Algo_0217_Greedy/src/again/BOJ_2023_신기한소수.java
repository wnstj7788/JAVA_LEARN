package again;

import java.util.Scanner;

public class BOJ_2023_신기한소수 {
	static int N;
	
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		
		sb = new StringBuilder();
		
		perm(2,1); // 붙여야되는 재료 주며서 현재 소수의 길이 전달
		perm(3,1);
		perm(5,1);
		perm(7,1);
		
		
		System.out.println(sb.toString());
	}
	
	static void perm (int num,int cnt) {
		
		if(cnt ==N) {
			sb.append(num+"\n");
			return;
		}
		
		for(int i =1; i< 10; i+=2) {
			//1,3,5,7,9를 하나하나 붙여보고 싶음
			if(isPrime(num *10 +i)) // 소수인지 확인
				perm(num*10+i, cnt +1);
		}
		
	}
	
	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num %i == 0) return false; // 약수 있으면 거절한다.
		}
		return true;
	}

}
