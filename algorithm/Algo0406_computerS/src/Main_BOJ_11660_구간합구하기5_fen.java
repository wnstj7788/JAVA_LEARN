import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11660_구간합구하기5_fen {

	static int N,M;
	static int [][] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree=new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				update(i, j, Integer.parseInt(st.nextToken()));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int answer = sum(x1,y1,x2,y2); 
			sb.append(answer);
			sb.append('\n');
			
		}
		System.out.println(sb);
		
		
	}
	static void update(int i,int jj, int diff) {
		while(i<N+1) {
			int j=jj;
			while(j<N+1) {
				tree[i][j]+=diff;
				j+=( j & -j);
			}
			i+=( i & -i);
		}
	}
	static int sum(int i, int jj) {
		int result=0;
		while(i>0) {
			int j=jj;
			while(j>0) {
				result+=tree[i][j];
				j-=( j & -j);
			}
			i-=( i & -i);
		}
		return result;
	}
	static int sum(int i1, int j1,int i2, int j2) {
		return sum(i2,j2)-sum(i1-1,j2)-sum(i2,j1-1)+sum(i1-1,j1-1);
	}
}