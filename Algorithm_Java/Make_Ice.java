import java.util.*;


public class Make_Ice{
	
	public static int n, m; // 그래프의 크기 
	
	public static int[][] graph = new int [1000][1000];
	
	public static boolean dfs(int x,int y) {
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		// 2차원 리스트 입력 
		for(int i = 0; i < n; i ++) {
			String str = sc.nextLine();
			for(int j =0; j < m; j ++ ) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
	 // 얼음이 얼려진다면 카운트
		int cnt = 0;
		for(int i = 0; i <n; i ++) {
			for(int j = 0 ; j <  m; j++) {
				if(dfs(i,j)) {
					cnt+=1;
				}
			}
		}
		
		System.out.println(cnt);
		

	}

}
