import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1265_달란트2dp {  // D5

	public static int T=0,N=0,P=0;
	public static long max=0L;
	public static long[][] dalant;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		T=Integer.parseInt(br.readLine().trim());
		for (int iT = 1; iT <= T; iT++) {
			st=new StringTokenizer(br.readLine().trim());
			N=Integer.parseInt(st.nextToken().trim());
			P=Integer.parseInt(st.nextToken().trim());
			dalant=new long[101][101];
			for (int i = 0; i < 101; i++) {
				Arrays.fill(dalant[i], 0L);
			}
			dalant(N,P);
			System.out.printf("#%d %d\n",iT,dalant[N][P]);
		}
	}
	public static long dalant(int n, int p) {
		if(p==1) {
			return n;
		}

		if(dalant[n][p]!=0) return dalant[n][p];
		
		long ret = 0L+Integer.MIN_VALUE; 
	    for(int i=1;i<n;i++){
	        ret = Math.max(ret, i*dalant(n-i,p-1));
	    }
	    dalant[n][p]=ret;
	    return dalant[n][p];
	}
}