import java.util.Scanner; // 사용자로 부터 입력 받기 위해 Scanner불러오

public class SWEA_1204 { // 클래스 명정의 (SWEA의 클래스 Solutio이니 해당 부분 수

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in); // 스캐너의 별칭을 sc으로 정의하고 선언
		
		int test = sc.nextInt(); //test_case의 수를 입력 받
		
		for(int t = 1; t <= test; t++) { // 반복문 -> (초기값, 조건값, 증감범위) 
			
			int n = sc.nextInt();// 테스트 케이스 번호 입
			int[] arr = new int[101]; //101개의 빈 배열 선언 
			
			
			
			for(int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++; // 인덱스 넘버로 입력받고 바로 카운트하기 
			}
			int max = 0;
			int index = 0;
			
			for(int i = 0; i <arr.length; i++) { //arr의 길이만큼 반
				if(arr[i] >= max) { // arr[i]의 값이 max보다 크면 max값 변경 
					max = arr[i];
					index = i; // 해당 인덱스 출력 
				}
			}
			System.out.println("#%d" + n + " "+ index);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
