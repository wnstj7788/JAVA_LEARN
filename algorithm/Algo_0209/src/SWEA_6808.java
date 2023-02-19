import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {

	static int fir[] = new int[9];
	static int se[] = new int[9];
	static boolean[] check;
	static int[] result;
	static  int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= TC; t++) {
			boolean[] cards = new boolean[19]; // total cards
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				fir[i] = Integer.parseInt(st.nextToken());
				// 규영이 카드 
				cards[fir[i]] = true;
			}
			// 인영이 카드 
			int idx =0;
			for (int i = 1; i <= 18; i++) {
				if(!cards[i])
					se[idx ++] = i; 
			}
			
			result  = new int[9];
			check  = new boolean[9];
			cnt = 0;
			perm(0);
			
			System.out.println("#" + t + " "+ cnt + " " +(362880 - cnt) );
		}
		
		
	}
	public static void perm(int idx) {
		if(idx == 9) {
			int fiSoc = 0;
			int seSoc =  0;
			
			for(int i = 0; i <9; i++) {
				if(fir[i] > result[i]) fiSoc += fir[i] + result[i];
				else seSoc += fir[i] + result[i]; 
			}
			if(fiSoc > seSoc) cnt ++;
			return;
			
		}
		for(int i = 0; i < 9; i++) {
			if(!check[i]) {
				result[idx] = se[i];
				check[i] = true;
				perm(idx +1);
				check[i] = false;
			}
		}
	}
}
