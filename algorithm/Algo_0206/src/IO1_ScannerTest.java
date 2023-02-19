
import java.util.Scanner;

/**
 * @author THKim
 */
/*
9
구레잇
 */
public class IO1_ScannerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("몇 기? : ");
		System.out.println("==> SSAFY : "+sc.nextInt());
		
		System.out.print("우리 기수를 나타내는 한마디 ? : ");
		//System.out.print("==> 한마디 :"+sc.next()+"!"); // 구레잇 9기 하면 구레잇만 호출된다 = 개행 문자까지만 읽어드림 
		
		
		sc.nextLine(); // 처리해줘야함
		System.out.print("==> 한마디 :"+sc.nextLine()+"!");
		// 기수를 입력 받으면 끝나버림 개행 문자를 고려 하지 않았기 때문에!
//		System.out.print("==> 한마디 :"+sc.nextLine()+"!");
		
		sc.close();
	}
}
