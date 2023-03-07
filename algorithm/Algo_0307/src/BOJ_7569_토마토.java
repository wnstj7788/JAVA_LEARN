import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
    static class Tomato{
        int x, y, h, time;

        public Tomato(int x, int y, int h, int time) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.time = time;
        }
    }

    static int N, M ,H;
    static int dx[] = {-1,0,1,0,0,0};
    static int dy[] = {0,-1,0,1,0,0};
    static int dh[] = {0,0,0,0,-1,1};

    static int map[][][];
    static boolean visited[][][];
    static int TomatoCnt;

    static Queue<Tomato> q = new LinkedList<>();
    static int ans = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //가로
        M = Integer.parseInt(st.nextToken()); //세로
        H = Integer.parseInt(st.nextToken()); //높이
        map = new int[M][N][H];
        visited = new boolean[M][N][H];
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp == 1){
                        q.add(new Tomato(i,j,h,0));
                        visited[i][j][h] = true;

                    }
                    if(temp == 0){
                        TomatoCnt++;
                    }
                    map[i][j][h] = temp;
                }                
            }
            
        } //input end

        bfs();

        if(TomatoCnt == 0){
            System.out.println(0);
        }else if(ans == Integer.MIN_VALUE){
            System.out.println(-1);
        }else
            System.out.println(ans);



    }


    private static void bfs(){
        int cnt = 0;
        while (!q.isEmpty()){
            Tomato now = q.poll();
            //print();
            for (int d = 0; d < dx.length; d++) {
                int nx =  now.x + dx[d];
                int ny = now.y + dy[d];
                int nh = now.h + dh[d];


                if( nx >= 0 && nx < M && ny >= 0 && ny < N && nh >= 0 && nh < H && !visited[nx][ny][nh] && map[nx][ny][nh] != -1){
                    cnt++;
                    visited[nx][ny][nh] = true;
                    q.add(new Tomato(nx, ny, nh , now.time +1));
                }

            }
            if(cnt == TomatoCnt) ans = Math.max(ans,now.time);
        }
    }


    private static void print() {
        for (int h = 0; h <H; h++) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(map[i][j][h] + " ") ;

                }
                System.out.println();
            }
            System.out.println("______________________________");
        }
    }
}
