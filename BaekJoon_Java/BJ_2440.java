import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2440 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i= 0; i < n;i ++) {
			for(int j = i + 1 ; j <= n ; j++) {
				System.out.printf("*");
			}
//			for(int k =0; k < i; k++) {
//				System.out.print(" ");
//			}
			System.out.println();
		}
		
	}

}
