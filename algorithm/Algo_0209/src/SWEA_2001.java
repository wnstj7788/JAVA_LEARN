import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2001 {
	static int M;
	static int arr[][];
	static int N; 
	static int max = 0;
	static int tc =1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

				}

			} // 입력 끝
			
			killing(0);
		

		} // 테케 끝

	}// 메인 끝

	public static void killing(int idx) {
		int sum = 0;
		if(idx == N -M ) {
			
			System.out.println("#" + tc + " " + max);
			tc ++;
			return;
		}
		
		for(int i =0; i < M ; i++) {
			//sum += arr[idx + i][idx];
			for (int j = idx; j < idx+M; j++) {
				sum += arr[idx+i][j];
			}
			
		}
		if(sum > max) {
			max = sum; 
		}
		killing(idx +1);
		

	}

}
