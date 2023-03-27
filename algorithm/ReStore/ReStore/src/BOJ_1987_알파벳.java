import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    //알파벳 배열
    static boolean isSelected[];
    //4방 탐색
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    //방문체크

    static char map[][];
    //사이즈
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        isSelected = new boolean[26];

        for (int i = 0; i < N; i++) {
            char temp[] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[j];
            }
        }
        //System.out.println(Arrays.deepToString(map));
        isSelected[map[0][0] -'A'] = true;

        dfs(0,0, 1);
        System.out.println(ans);

    }

    private static void dfs(int i, int j, int cnt){
        ans = Math.max(ans, cnt);
        for (int d = 0; d < dx.length; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(nx >= 0 && nx < N && ny >= 0 && ny <M && !isSelected[map[nx][ny] - 'A'] ){

                isSelected[map[nx][ny] -'A'] = true;

                dfs(nx,ny,cnt+1);
                isSelected[map[nx][ny] -'A'] = false;
            }
        }



    }

}
