package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static class robot{
        int x, y, d;

        public robot(int x, int y, int d){
            this.x = x;
            this.y = y;

            this.d = d;
        }
    }
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1}; // 북 동 남 순서로 진행
    static int map[][];
    static int N, M;
    static int clearMap[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        clearMap = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        System.out.println(bfs(r,c,d));


    }



    private static int bfs(int r, int c, int d){
        Queue<robot> q = new LinkedList<>();
        q.add(new robot(r,c,d));
        int clearCnt = 0;


        while (!q.isEmpty()){
            robot now = q.poll();
            //현재 위치 청소 안했으면 청소한다
            if(clearMap[now.x][now.y] == 0){
                clearMap[now.x][now.y] = 1;
                clearCnt++;
            }

            boolean flag = false;
            for (int dir = 0; dir < 4; dir++) {
                int nx  = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0){
                    flag = true;
                    // 하나라도 들어면 청소 가능하다는 뜻
                }
            }

            // 청소가 불가능할 경우
            if(!flag){
                int changeX =  now.x + dx[(now.d + 2) % 4];
                int changeY =  now.y+ dy[(now.d + 2) % 4];
                if(changeX >= 0 && changeX < N && changeY >= 0 && changeY < M &&map[changeX][changeY] == 0){
                    // 뒤로갈 수 있는 상황
                     q.add(new robot(changeX,changeY,now.d ));
                }else{
                    break;
                }
                // 가능한 경우
            }else{
                int changeDir = (now.d +1) % 4; // 회전
                int changeX =  now.x+ dx[changeDir];
                int changeY = now.y + dy[changeDir];
                if(changeX >= 0 && changeX < N && changeY >= 0 && changeY < M && map[changeX][changeY] == 0 && clearMap[changeX][changeY] == 0){
                    q.add(new robot(changeX,changeY,changeDir));
                }else {
                    q.add(new robot(now.x, now.y, changeDir));
                }


            }



        }


    return clearCnt;
    }
}
