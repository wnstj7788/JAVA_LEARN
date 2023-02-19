import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {
	static int N, R;
	static int[] numbers;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int [R];
		input = new int [N];
		isSelected = new boolean[N];
		
		for(int i = 0; i< N ;++i) {
			input[i] = sc.nextInt();
		}
		permutation(0);
	}

	private static void permutation(int cnt) {

		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}

}
