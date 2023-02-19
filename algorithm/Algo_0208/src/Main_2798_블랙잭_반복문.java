import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2798_블랙잭_반복문 {
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

		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int tmp = cards[i]+cards[j]+cards[k];
					if(tmp <= M) {
						ans = Math.max(ans, tmp);
					}
				}
			}
		}
		
		System.out.println(ans);
	}

	
}