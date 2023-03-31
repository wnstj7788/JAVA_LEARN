import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;

public class BOJ_2239_스도쿠 {
	
	//9 * 9 문제임
	static int [][] map = new int[9][9];
	static boolean flag = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = temp[j] -'0';
			}
		}
		
		dfs(0);
		for(int temp[] : map) {
			System.out.println(Arrays.toString(temp));
		}
	}

private static void dfs(int d) {
		
		if(d==81) {
			flag = true;
			return;
		}
	
		int r = d/9;
		int c = d%9;
		
		if(map[r][c]!=0)
			dfs(d+1);
		else {
			for(int i=1;i<10;i++) {
				if(!isTrue(r,c,i))continue;
				map[r][c] = i;
				dfs(d+1);
				
				// 종료 조건이 아니라면 더이상 선택할 수가 없다는 뜻 => 백트랙킹

				if(flag) return;
				map[r][c]=0;
				
			}
		}
		
		
		
	}
	
	private static boolean isTrue(int ni, int nj, int j) {
		// 가능한지 여부를 파악해주기
		// 행체크 
		// 열체크 
	
		for(int i=0;i<9;i++) {
			if(map[i][nj]==j || map[ni][i]==j) return false;
		}
		
		// 3*3

		int sr = ni/3 * 3;
		int sc = nj - nj%3;
		for(int row=sr;row<sr+3;row++) {
			for(int col=sc;col<sc+3;col++) {
				if(map[row][col]==j) return false;
			}
		}
		
		
		return true;

	}

}
