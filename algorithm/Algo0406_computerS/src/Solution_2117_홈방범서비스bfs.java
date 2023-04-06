import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2117_홈방범서비스bfs {
   static int[][] map;
   static int ans;
   static int N, M; // 맵크기, 한집당 지불비용
   
   static int[] di = {0,0,1,-1};
   static int[] dj = {1,-1,0,0};
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int TC = sc.nextInt();
      
      for(int tc=1; tc<=TC; tc++) {
         N = sc.nextInt();
         M = sc.nextInt();
         
         map = new int[N][N];
         for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
               map[i][j] = sc.nextInt();
            }
         }
         
         ans = 0;
         for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
               bfs(i,j);
            }
         }
         System.out.println("#"+tc+" "+ans);
      }
   }
   
   static void bfs(int si, int sj) {
      Queue<Point> queue = new LinkedList<>();
      boolean[][] visit = new boolean[N][N];
      int K=1; // 서비스 범위
      int house = 0; // 영역 안의 집 수
      
      queue.add(new Point(si,sj)); // 서비스 영역의 중심
      visit[si][sj] = true;
      
      while(!queue.isEmpty()) {
         int size = queue.size();
         
         for(int s=0; s<size; s++) { // 중심에서 같은 거리의 서비스 지역 확인 for
            Point now = queue.poll();
            if(map[now.i][now.j]==1)
               house++;
            for(int d=0; d<4; d++) {
               int ni = now.i+di[d];
               int nj = now.j+dj[d];
               
               if(ni>=0 && ni<N && nj>=0 && nj<N && !visit[ni][nj]) {
                  visit[ni][nj] = true;
                  queue.add(new Point(ni, nj));
               }
            }
         }// 현재 중심에서 거리가 k인 영역의 집들 처리했음. (k+1로 늘어났을 경우의 좌표는 queue에 넣어 놓은 상태)
         
         int cost = K*K+(K-1)*(K-1); // 운영비용
         int income = house*M; // 수입
         if(cost <= income) // 적자만 안나면
            ans = Math.max(ans, house);
         
         K++; // 영역 범위 증가.(서비스 중심 좌표로부터의 거리)
      }
   }
   
   static class Point{
      int i, j;
      Point(int i, int j){
         this.i = i;
         this.j = j;
      }
   }
}