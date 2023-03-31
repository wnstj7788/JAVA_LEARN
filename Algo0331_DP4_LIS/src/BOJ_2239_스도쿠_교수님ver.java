import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;

public class BOJ_2239_스도쿠_교수님ver {

	// 9 * 9 문제임
	static int[][] board = new int[9][9];
	static boolean flag = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				board[i][j] = temp[j] - '0';
			}
		}

		dfs(0);
//		for (int temp[] : board) {
//			System.out.println(Arrays.toString(temp));
//		}
	}
//
//private static void dfs(int d) {
//		
//		if(d==81) {
//			flag = true;
//			return;
//		}
//	
//		int r = d/9;
//		int c = d%9;
//		
//		if(board[r][c]!=0)
//			dfs(d+1);
//		else {
//			for(int i=1;i<10;i++) {
//				if(!isTrue(r,c,i))continue;
//				board[r][c] = i;
//				dfs(d+1);
//				
//				// 종료 조건이 아니라면 더이상 선택할 수가 없다는 뜻 => 백트랙킹
//
//				if(flag) return;
//				board[r][c]=0;
//				
//			}
//		}
//		
//		
//		
//	}

	static boolean dfs(int num) {
		
		
		if(num == 81) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			return true;
		}
		
		boolean result = false;

		int i = num / 9;
		int j = num % 9;
		if (board[i][j] == 0) {

			for (int n = 1; n <= 9; n++) {
				if (!cheak(i, j, n))
					continue;

				board[i][j] = n;
				result = dfs(num + 1);
				if (result)
					break;
				
				board[i][j] = 0;

			}
		} else {
			result = dfs(num + 1);
		}

		return result;
	}

	static boolean cheak(int nowi, int nowj, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[i][nowj] == n)
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (board[nowi][i] == n)
				return false;

		}

		int si = nowi / 3 * 3;
		int sj = nowj / 3 * 3;

		for (int i = si; i < si + 3; i++) {
			for (int j = sj; j < sj + 3; j++) {
				if (board[i][j] == n) {
					return false;
				}
			}
		}
		return true;
	}

//	private static boolean isTrue(int ni, int nj, int j) {
//		// 가능한지 여부를 파악해주기
//		// 행체크
//		// 열체크
//
//		for (int i = 0; i < 9; i++) {
//			if (board[i][nj] == j || board[ni][i] == j)
//				return false;
//		}
//
//		// 3*3
//
//		int sr = ni / 3 * 3;
//		int sc = nj - nj % 3;
//		for (int row = sr; row < sr + 3; row++) {
//			for (int col = sc; col < sc + 3; col++) {
//				if (board[row][col] == j)
//					return false;
//			}
//		}
//
//		return true;
//
//	}

}
