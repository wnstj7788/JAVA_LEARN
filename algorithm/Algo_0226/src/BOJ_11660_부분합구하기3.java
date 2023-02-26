import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_11660_부분합구하기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int [][] sigma = new int[N+1][N+1];
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sigma[i][j] = sigma [i][j -1 ] + Integer.parseInt(st.nextToken());
				//print(sigma);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			int sum =0;
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int j1= Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			int j2 = Integer.parseInt(st.nextToken());
			
			
			for (int i = i1; i <= i2; i++) {
				sum += sigma[i][j2] - sigma[i][j1 -1];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);

	}
	
	
	
	static void print(int map[][]) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

}