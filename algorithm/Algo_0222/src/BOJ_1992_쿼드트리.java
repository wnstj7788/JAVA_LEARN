import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i <n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

	
		quadTree(0, 0, n);
		System.out.println(sb);
	}

	private static void quadTree(int x, int y, int size) {
	
		if (cutting(x, y, size)) {
	
			sb.append(map[x][y]);
		}
		// 색이 다르면 다시 분할하여 검색
		else {
			int halfSize = size / 2;
			sb.append("(");
			quadTree(x, y, halfSize); //왼쪽 위
			quadTree(x, y + halfSize, halfSize);//오른쪽 위
			quadTree(x + halfSize, y, halfSize);//왼쪽 아래
			quadTree(x + halfSize, y + halfSize, halfSize);//오른쪽 아래
			sb.append(")");
		}

		
	}

	private static boolean cutting(int x, int y, int size) {
		
		if (size == 1) {
			return true;
		} else {
	
			int target = map[x][y];

			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					//target과 다르면 컷 
					if (map[i][j] != target) {
						return false;
					}
				}
			}
			return true;
		}
		
	}

}