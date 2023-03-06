import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7578_토마토_Re {

    static int N, M;
    static int map[][];

    static Queue<Tomato> q;

    static class Tomato{
        int x, y, time;

        public Tomato(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }

    static boolean visited[][];

    static int Tomatocnt;

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int ans = Integer.MIN_VALUE;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    q.add(new Tomato(i,j, 0));
                    visited[i][j] = true;
                }
                if(temp == 0){
                    Tomatocnt++;
                }
                map[i][j] = temp;
            }
        }

        bfs();

        if(Tomatocnt == 0){
            System.out.println(0);

        }else if(Tomatocnt == cnt){
            System.out.println(ans);
        } else{
            System.out.println(-1);
        }
    }

    private static void bfs(){
        cnt = 0;
        while(!q.isEmpty()){
            Tomato now = q.poll();
            for(int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] != -1){
                    cnt++;
                    visited[nx][ny] = true;
                    q.add(new Tomato(nx, ny ,now.time +1));
                }

            }


             ans = Math.max(ans, now.time);
        }
    }
}
