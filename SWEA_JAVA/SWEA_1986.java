import java.util.Scanner;
public class SWEA_1986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt(); //테스트 케이스 입력 받기 
		
		for(int t=1; t <= testcase; t++) {
			int num = sc.nextInt();
			int result = 0; // 결과 저장하는 변수 작성 
			for(int i = 0; i <= num; i ++) {
				if(i % 2 == 0) { //i를 2로 나누어 0이라면 (짝수라면) 해당 수를 전체 값에서 뺸다 
					result -= i;	
				}else {  // 위의 경우가 아니라면 (홀수라면) 해당 수를 전체 값에 더한다 
					result += i;
					
				}
			}
			System.out.printf("#%d %d\n",t,result); // 전테 결과를 출력한다 
		}
	}

}
