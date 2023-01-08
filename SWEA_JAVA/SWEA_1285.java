import java.util.Arrays;
import java.util.Scanner;
public class SWEA_1285 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int num = sc.nextInt();
			int [] arr = new int[num]; //던지는 인원만큼 배열 만들기 
			for(int i = 0; i < num; i++) {	
				int a = sc.nextInt();
				if(a < 0) {
					a = -(a); // 음수라면 양수로 변경 (절댓값)
				}
				arr[i] = a;
							
			}
			Arrays.sort(arr);// 배열 정렬 
			
			int headnum = arr[0];  // 정렬 후 첫번 째 요소가 가장 가까운 요소
			
			int cnt = 1;
			for(int j = 1; j < arr.length; j++) { //2번째 요소부터 검사를하여 첫번째 요소와 값이 같은게 있다면 cnt += 1
				if(arr[j] == headnum) {
					cnt += 1;
				}else {
					break;
				}
			}
			System.out.println("#" + t +" "+ headnum + " "+ cnt);
		}
		

	}

}
