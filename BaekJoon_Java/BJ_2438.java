import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2438 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// String s = bf.readLine(); //문자열 입력
		int n = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= n; i++) { // i = 1
			for (int j = 1; j <= i; j++) { // i가 늘어날 수록 지속적으로 반복
				System.out.printf("*");
			}
			System.out.println();
		}

	}
}
