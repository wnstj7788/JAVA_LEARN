import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2798_블랙잭_조합_반복 {
	static int[] cards;
	static int[] result;
	static int N, M;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			cards[n] = Integer.parseInt(st.nextToken());
		} // end input
		
		ans = Integer.MIN_VALUE;

		result = new int[3]; // 세개의 카드를 여기 뽑아놓는 조합
		comb(0,0);
		System.out.println(ans);
	}

	static void comb(int idx, int start) {
		if(idx==3) {
			int tmp = 0;
			for(int i=0; i<3; i++)
				tmp += result[i];
			
			if(tmp<=M)
				ans = Math.max(ans, tmp);
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[idx] = cards[i];
			comb(idx+1, i+1);
		}
	}
}