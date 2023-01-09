import java.util.Scanner;
public class BeakJoon_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		String k = s.toUpperCase();
		System.out.println(k);
		
		//ASCII CODE  A = 65
		
		int[] arr = new int[26];// 알파벳에 해당하는 배열  
		
		for(int i = 0; i < k.length(); i++) {
			arr[k.charAt(i) - 'A' ]++;
		}
		
		int max = -1;
		char ch = '?';
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] > max) {
				max = arr[j];
				ch = (char) (j + 65); 
			}
			else if(arr[j] == max) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
	}

}
	