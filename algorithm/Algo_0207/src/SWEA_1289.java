import java.util.Scanner;

public class SWEA_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int ans = 0;
			String d = sc.next();
			char c = '0';
			for (int k = 0; k < d.length(); k++) {
				if (c != d.charAt(k)) {
					ans++;
					c = d.charAt(k);
				}
			}
			System.out.println("#" + i + " " + ans);
		}
		sc.close();
	}
}