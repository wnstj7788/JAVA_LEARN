import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2798_블랙잭_조합_뽑고안뽑고 {
	static int[] cards;
	static boolean[] select;
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

		select = new boolean[N]; // 세개의 카드를 여기 뽑아놓는 조합
		comb(0,0);
		System.out.println(ans);
	}

	static void comb(int idx, int cnt) {
		if(cnt==3) {
			int tmp = 0;
			
			for(int i=0; i<select.length; i++) {
				if(select[i])
					tmp += cards[i];
			}
			
			if(tmp<=M)
				ans = Math.max(ans, tmp);
			return;
		}
		if(idx == cards.length) return; // 앞에 재귀들이 너무 false, false 해서 총 3개를 못뽑음..
		
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}