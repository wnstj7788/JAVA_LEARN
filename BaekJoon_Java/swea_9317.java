
import java.util.*;

public class swea_9317 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int cnt = 0; //총 카운트하는 놈
			int num = sc.nextInt();
			String title = sc.next();
			String notitle = sc.next();
			for(int i = 0; i < num; i++) {
				char a = title.charAt(i);
				char b = notitle.charAt(i);
				if (a == b) {
					cnt +=1;
				}
			}
		System.out.println("#"+ t +" " + cnt);
		}
	}

}
