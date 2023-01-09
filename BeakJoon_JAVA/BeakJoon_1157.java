import java.util.Scanner;
public class BeakJoon_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		String k = s.toUpperCase(); //대문자로의 전
		
		//ASCII CODE  A = 65
		
		int[] arr = new int[26];// 알파벳에 해당하는 배열  
		
		for(int i = 0; i < k.length(); i++) {
			arr[k.charAt(i) - 'A' ]++;
		}
		
		int max = -1;
		char ch = '?';
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] > max) {
				max = arr[j]; //맥스값 지
				ch = (char) (j + 65); // 대문자 출력을 위해 65를 더해준다 65가 A 66이 B ........ 
			}
			else if(arr[j] == max) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
	}

}
	