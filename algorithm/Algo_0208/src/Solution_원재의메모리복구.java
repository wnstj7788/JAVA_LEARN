

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_원재의메모리복구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			char[] input = br.readLine().toCharArray();
			
			char[] result = new char[input.length];
			Arrays.fill(result, '0');
			
			int ans = 0;
			for(int i=0; i<input.length; i++) {
				if(input[i] != result[i]) {
					for(int j=i; j<result.length; j++) {
						result[j] = input[i];
					}
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ ans);
		}
	}
}
