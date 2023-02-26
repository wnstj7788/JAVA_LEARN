import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class BOJ_3109_빵집 {
	static char[][] map;
	static boolean[][] visited;
	
	static int[] di = {-1,0,1};
	static int [] dj = {1,1,1};
	static int R,C,ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
	
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map= new char[R][];
		visited = new boolean[R][C];
		
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			
		}
		
		for(int r = 0; r< R; r++) {
			func(r,0);
		}
		
		System.out.println(ans);
	}
	
	
	
	static boolean func(int nowi, int nowj) {
		visited[nowi][nowj] = true;
		if(nowj == C-1) {
			ans ++;
			return true;
		}
		
		
		for (int i = 0; i < di.length; i++) {
			int nexti = nowi + di[i];
			int nextj = nowj + dj[i];
			// 다른 재귀가 같던 옆칸??? 그럼 파이트가 있거나 또느 ㄴ파이프가 없어도 파이프르 놓을 수 없는 칸이였네 
			if(nexti <0||nexti>= R ||nextj <0||nextj>= C || map[nexti][nextj] == 'X' || visited[nexti][nextj]) continue;
			boolean result = func(nexti,nextj);
			
			if (result == true)
				return true;
		}
		
		
		//visited[nowi][nowj] = false; // 이거하면 터짐 
		return false;
	}

}
