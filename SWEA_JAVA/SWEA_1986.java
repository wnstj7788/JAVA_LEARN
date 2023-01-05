import java.util.Scanner;
public class SWEA_1986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int t=1; t <= testcase; t++) {
			int num = sc.nextInt();
			int result = 0;
			for(int i = 0; i <= num; i ++) {
				if(i % 2 == 0) {
					result -= i;	
				}else { 
					result += i;
					
				}
			}
			System.out.printf("#%d %d\n",t,result);
		}
	}

}
