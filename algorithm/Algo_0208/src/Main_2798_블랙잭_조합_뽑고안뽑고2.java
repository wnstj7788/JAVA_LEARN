import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2798_블랙잭_조합_뽑고안뽑고2 {
	static int[] cards;
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

		comb(0,0,0);
		System.out.println(ans);
	}

	static void comb(int idx, int cnt, int tmp) {
		if(cnt==3) {
			if(tmp<=M)
				ans = Math.max(ans, tmp);
			return;
		}
		if(idx == cards.length) return; // 앞에 재귀들이 너무 false, false 해서 총 3개를 못뽑음..
		
		comb(idx+1, cnt+1, tmp+cards[idx]);
		comb(idx+1, cnt, tmp);
	}
}