import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1209_bu {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < TC; tc++) {
			char[] input = br.readLine().toCharArray();

			char[] result = new char[input.length];

			Arrays.fill(result, '0');
			int ans = 0;
			for (int i = 0; i < input.length; i++) {
				if (input[i] != result[i]) {
					Arrays.fill(result, i, result.length, input[i]);
				}
				ans++;
			}

			System.out.println("#" + tc + " " + ans);
		}

	}
}
