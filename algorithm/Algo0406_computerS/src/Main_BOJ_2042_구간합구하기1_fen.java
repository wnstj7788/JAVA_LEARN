import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2042_구간합구하기1_fen {
	static int N,M,K;
	static long[] tree;
	static long[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		tree=new long[N+1];
		nums=new long[N+1];
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			nums[i]=Long.parseLong(st.nextToken());
		}
		for (int i = 1; i < N+1; i++) {
			update(i,nums[i]);
		}
		for (int i = 0; i < M+K; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			if(a==1) {
				int b=Integer.parseInt(st.nextToken());
				long c=Long.parseLong(st.nextToken());
				long temp=nums[b];
				nums[b]=c;
				update(b,c-temp);
			}else if(a==2) {
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				long s=sum(b,c);
				System.out.println(s);
			}
		}
	}
	static void update(int i, long diff) {
		while(i<N+1) {
			tree[i]+=diff;
			i+=( i & -i);
		}
	}
	static long sum(int i) {
		long result=0;
		while(i>0) {
			result+=tree[i];
			i-=( i & -i);
		}
		return result;
	}
	static long sum(int i, int j) {
		return sum(j)-sum(i-1);
	}
}