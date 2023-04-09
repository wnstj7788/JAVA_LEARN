package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2117_홈방범서비스_re {
    static int map[][];
    static boolean visisted[][];
    static int N, M, HomeCnt, result;

    static class home{
        int x ,  y;

        public home(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<home> homes;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc  <= TC ; tc++) {
            result = Integer.MIN_VALUE;
            homes = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <N ; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp == 1){
                        homes.add(new home(i,j));
                    }
                    map[i][j] = temp;

                }
            }// input end

//            for (int i = 0; i < homes.size() ; i++) {
//                bfs(i);
//               // result = Math.max(bfs(i), result);
//            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <N ; j++) {
                    bfs(i,j);
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static void bfs(int i, int j){
        Queue<home> q = new LinkedList<>();
//        q.add(new home(homes.get(start).x, homes.get(start).y));
        visisted = new boolean[N][N];
//        visisted[homes.get(start).x][homes.get(start).y] = true;
        q.add(new home(i,j));
        visisted[i][j] = true;

        HomeCnt = map[i][j] == 1 ? 1: 0;
        int area = 1;

        if(cost(area, HomeCnt)){
            result = Math.max(result, HomeCnt);
        }

        while(!q.isEmpty()){
            int size = q.size();

            for (int s = 0; s < size; s++) {
                home now = q.poll();


                for(int d =0; d < 4; d++){
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visisted[nx][ny]){
                        if(map[nx][ny] == 1){
                            HomeCnt++;
                        }
                        visisted[nx][ny] = true;
                        q.add(new home(nx, ny));
                    }

                }

            }
            area++;
            //가능한지 확인해봐야지
            if(cost(area, HomeCnt)){
                result = Math.max(result, HomeCnt);
            }
        }

    }

    private static boolean cost(int area, int homeCnt) {
        int playMoney = area * area + ((area-1) * (area-1));
        int getMoney = homeCnt * M;
        if(getMoney >= playMoney){
            return true;
        }
        return false;
    }


}