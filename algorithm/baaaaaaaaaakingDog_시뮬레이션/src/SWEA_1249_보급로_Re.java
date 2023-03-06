import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA_1249_보급로_Re {
    /*
    출발지에서 도착지까지 도로 복구하면서 가장 빠른 길을 선택하여고 하는문제
    bfs로 간단하게 해결 완료
     */

    static class road implements Comparable<road>{
        int x, y, time;

        public road(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(road o) {
            return this.time - o.time;
        }
    }
    static int N;
    static int map[][];
    static boolean visited[][];
    static int ans;

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i <N; i++) {
                String temp = br.readLine();
                for (int j = 0; j <N; j++) {
                    map[i][j] = temp.charAt(j) - '0';

                }
            }
            bfs(0,0);

            System.out.println("#" + tc +  " " + ans);
        }


    }

    private static void  bfs(int si, int sj){
        PriorityQueue<road> pq = new PriorityQueue<>();
        visited = new boolean[N][N];
        pq.add(new road(si,sj,0));
        visited[si][sj] = true;

        while(!pq.isEmpty()){
            road now = pq.poll();
            if(now.x == N-1 && now.y == N-1){
                ans = Math.min(ans, now.time);
            }
            for (int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];


                if(nx >= 0 && nx < N &&  ny >= 0 && ny < N && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    pq.add(new road(nx, ny, now.time + map[nx][ny]));
                }
            }

        }
    }


}
