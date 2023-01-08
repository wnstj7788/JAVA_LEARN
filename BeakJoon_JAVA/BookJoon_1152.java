import java.util.*;
import java.util.Scanner;
//공백 하나 입력을 고려 
public class BookJoon_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();

		
		String trimstr = str.trim();// 앞뒤 공백 
			
		String[] list = trimstr.split(" ");
		
		if(list[0].equals("")){ // 리스트의 첫 요소가 공백이라면 
			System.out.println("0");
		}else {
		
			System.out.println(list.length);
		
		}
	}
}
	


	



