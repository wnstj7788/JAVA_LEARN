import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class SWEA_2112_보호필름 {
	static int D, W, K;
	static int map[][];
	static boolean isSelected[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[D][W];
		isSelected = new boolean[D];
		
		
		// 0 => A , 1=> B
		for (int i = 0; i < D; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		subset(0);
		
		
		
	}
	
	
	private static void subset(int idx) {
		if(idx == D) {
			for (int i = 0; i < D; i++) {
				if(isSelected[i]) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			return;
		}
		

		isSelected[idx] = false;
		subset(idx + 1);

        isSelected[idx] = true;
        subset(idx + 1);
		
		

	}
	
	
	private static void cheak() {
		
	}
	
	

}
