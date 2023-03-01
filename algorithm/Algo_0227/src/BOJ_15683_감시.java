import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
    static int[] di = { -1,1,0,0 }; // 0상 1하 2좌 3우
    static int[] dj = { 0,0,-1,1 };

    static String[][] cctvDir = {
            {}, // 0번 카메라 음슴
            {"0","1","2","3"}, // 1번카메라는 반복 4번
            {"01","23"}, // 2번카메라는 반복 2번
            {"03","31","12","20"}, // 3번카메라는 반복 4번
            {"123","023","013","012"}, // 4번카메라는 반복 4번
            {"0123"} // 5번 카메라는 반복 1번
    };

    static int N, M; // 지도크기
    static ArrayList<CCTV> camera; // 카메라 총 몇개있을지 입력 안줌.
    static int ans; // 카메라를 적절히 배치했을 때 사각지대의 최소크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        camera = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) { // 빈칸, 벽 아니면 카메라다!!!!
                    camera.add(new CCTV(i, j, map[i][j]));
                }
            }
        } // end input

        dfs(0, map); // 현재 0번부터 2번까지 카메라가 있다 치면 재귀 한놈당 카메라 하나씩 맡기기.
        System.out.println(ans);
    }


    static void dfs(int camIdx, int[][] origin) {

//        print(origin);
        if(camIdx==camera.size()) { // 모든 카메라 배치 일단 완료!
            // 사각지대 카운트해보기
            int zero = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    zero += origin[i][j]==0?1:0;
                }
            }
            ans = Math.min(ans, zero);
            return;
        }

        //ex) 현재 카메라 타입 2번카메라 {"01","23}
        String[] camRotate = cctvDir[camera.get(camIdx).camType]; 

        for(int r=0; r<camRotate.length; r++) { // 카메라 종류마다 회전수가 다름. ex)1번카메라는 회전네번, 2번은 회전두번
            int[][] copy = deepcopy(origin); // 현재 방향으로 그림그리기 전에 원본유지. 사본 획득.

            String now = camRotate[r]; // "01" -> 현재 비추고 있는 방향정보
            for(int d=0; d<now.length(); d++) { // 0방향 draw, 1방향 draw
                draw(camera.get(camIdx).i, camera.get(camIdx).j, now.charAt(d)-'0', copy);
            }
            dfs(camIdx+1, copy);
        }
    }

    static void draw(int si, int sj, int dir, int[][] copy) {
        int nexti = si+di[dir]; // 현재 쳐다보고 있는 방향으로 슈퍼직진
        int nextj = sj+dj[dir];
        while(true) {
            if(nexti<0 || nexti>=N || nextj<0 || nextj>=M || copy[nexti][nextj]==6) break;

            copy[nexti][nextj] = 7; // 벽을 만나거나 뛰쳐나가지 않으면(빈칸 또는 다른 카메라 아래이면 감시)
            nexti += di[dir];
            nextj += dj[dir];
        }
    }

    static int[][] deepcopy(int[][] origin){
        int[][] copy = new int[origin.length][origin[0].length];

        for(int i=0; i<origin.length; i++) {
            for(int j=0; j<origin[i].length; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }

static class CCTV {
    int i, j;
    int camType;
    CCTV(int i, int j, int camType) {
        this.i = i;
        this.j = j;
        this.camType = camType;
    }
}

static void print(int[][] arr) {
    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            System.out.print(arr[i][j]==7?"#":arr[i][j]);
        }
        System.out.println();
    }
    System.out.println("-------------------------");
}
}