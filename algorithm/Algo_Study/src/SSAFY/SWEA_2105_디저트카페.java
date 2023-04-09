package SSAFY;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
    static int N, map[][];
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    static boolean disert[];
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC ; tc++) {
            result = -1;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    disert = new boolean[101];
                    dfs(i,j,i,j,0,0);
                }
            }
            System.out.println("#" + tc + " " + result);

        }

    }

    private static void dfs(int starti, int startj, int endi, int endj, int dir, int cnt) {
        if(starti == endi && startj == endj && dir == 3){
            //System.out.println(cnt);
            result = Math.max(result, cnt);
            return;
        }

        for (int d = dir; d < 4  ; d++) {
            if(d <= dir +1){
                int nx = starti + dx[d];
                int ny = startj + dy[d];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(!disert[map[nx][ny]]){
                        disert[map[nx][ny]] = true;
                        dfs(nx, ny, endi, endj,d,cnt +1);
                        disert[map[nx][ny]] = false;
                    }
                }

            }
        }


    }


}
