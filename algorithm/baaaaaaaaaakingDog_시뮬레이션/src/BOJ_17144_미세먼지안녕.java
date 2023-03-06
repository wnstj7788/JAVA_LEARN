import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {

    static class dust{
        int x, y, value;

        public dust(int x, int y,int value) {
            this.x = x;
            this.y = y;

            this.value = value;
        }
    }
    static int r,c, t;
    static int map[][];
    static int air_cleaner;
    static int result;

    static Queue<dust> q;

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};

    static int windtime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        r = stoi(st.nextToken());
        c =stoi(st.nextToken());
        t = stoi(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                int temp = stoi(st.nextToken());
                if(temp  == -1){
                    air_cleaner = i;
                }
                map[i][j] = temp;

            }
        }
        for (int a = 0 ; a < t; a++){
            checkDust();
            bfs();
            wind();
        }
        cntdust();


        System.out.println(result);

    }



    private static void checkDust() {

        q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == -1 || map[i][j] == 0) continue;
                // 미세먼지가 있는 공간과 미세먼지 양
                q.add(new dust(i, j, map[i][j]));
            }
        }

    }


    // 공기 청정 함수
    private static void  wind(){
    // 반시계 방향

        int top = air_cleaner -1;
        int down = air_cleaner;

        for (int i = top - 1; i > 0; i--)
            map[i][0] = map[i-1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < c - 1; i++)
            map[0][i] = map[0][i+1];
        // 위로 당기기
        for (int i = 0; i < top; i++)
            map[i][c - 1] = map[i + 1][c - 1];
        // 오른쪽으로 당기기
        for (int i = c - 1; i > 1; i--)
            map[top][i] = map[top][i-1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[top][1] = 0;

        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
        // 위로 당기기
        for (int i = down + 1; i < r - 1; i++)
            map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < c - 1; i++)
            map[r - 1][i] = map[r - 1][i + 1];
        // 아래로 당기기
        for (int i = r - 1; i > down; i--)
            map[i][c - 1] = map[i - 1][c - 1];
        // 오른쪽으로 당기기
        for (int i = c - 1; i > 1; i--)
            map[down][i] = map[down][i - 1];

        map[down][1] = 0;

        //print();

    }



    //bfs 함수 + 확산
    private static void bfs(){

        while(!q.isEmpty()){
            dust now = q.poll();
            if(now.value < 5) continue;

            int cnt = 0; //확산 가능했던 방향을 저장
            // 확산 가능한 반경 확인
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(map[nx][ny] == -1) continue;
                cnt++;
                map[nx][ny] += now.value /5;

            }

            // 확산 시작
            //지금 내 자리
            map[now.x][now.y] -= (now.value / 5) * cnt;
//            for (int d = 0; d < 4; d++) {
//                int nx = now.x + dx[d];
//                int ny = now.y + dy[d];
//                if(nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != -1){
//
//                    // 확산된 자리
//                    map[nx][ny] += now.value /5;
//
//                    q.add(new dust(nx, ny , now.time +1,map[nx][ny]));
//                }
//            }





        }
    }

    private static void cntdust() {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] != -1){
                    cnt += map[i][j];
                }

            }

        }
        result = cnt;
    }

    private static int stoi(String a){
        return Integer.parseInt(a);
    }


//    private static int[][] deepcopy(int map[][]){
//        int temp[][] = new int[map.length][map[0].length];
//        for (int i = 0; i < temp.length; i++) {
//            for (int j = 0; j < temp[0].length; j++) {
//                if(map[i][j] == -1){
//                    temp[i][j] = -1;
//                }else{
//                    temp[i][j] = 0;
//                }
//            }
//
//        }
//        return  temp;
//    }


    private static void print(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();

        }
        System.out.println("-------------------------");
    }


}
