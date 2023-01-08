import java.util.Scanner;
public class BeakJoon_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		
		if (n == 4 || n == 7) {
			cnt = -1;
		}
		else if (n % 5 == 0) {
			cnt = (n / 5);
		}
		else if (n % 5 == 1 || n % 5 == 3) {
			cnt =  (n / 5) + 1;
		}
		else if (n % 5 == 2 || n % 5 == 4) {
			cnt = (n / 5) + 2;
		}
		System.out.println(cnt);
			
		}
	}


