import java.util.Scanner;
public class BaekJoon_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		
		if (n == 4 || n == 7) { // 정확하게 n키로로 못 나눈는 경우는 4와 7일 때 
			cnt = -1;
		}
		else if (n % 5 == 0) {
			cnt = (n / 5); //5의 배수인 경우 
		}
		else if (n % 5 == 1 || n % 5 == 3) {  //5의 나눈 나머지가 1 or 3인경우 
			cnt =  (n / 5) + 1; 
		}
		else if (n % 5 == 2 || n % 5 == 4) { // 5로 나눈 나머지가 2 or 4인 경우 
			cnt = (n / 5) + 2;
		}
		System.out.println(cnt);
			
		}
	}


