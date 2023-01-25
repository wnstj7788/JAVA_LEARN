import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2439 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i= 1; i <= n;i ++) {
			for(int j =1; j <= n-i ; j++) {
				System.out.printf(" ");
			}
			for(int k =1; k <= i; k++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
	}

}
