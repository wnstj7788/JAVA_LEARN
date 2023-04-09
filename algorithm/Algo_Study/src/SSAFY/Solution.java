package SSAFY;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};

    static class road implements Comparable<road>{
        int x;
        int y;
        int time;

        public road(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(road o) {
            if(this.time < o.time) {
                return -1;
            } else if(this.time > o.time) {
                return 1;
            }
            return 0;
        }
    }


    static int result ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = stoi(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            result = Integer.MAX_VALUE;
            N = stoi(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j =0 ; j < N ; j++){
                    map[i][j] = s.charAt(j) - '0';
                }

            }
            //System.out.println(Arrays.deepToString(map));
            bfs(0, 0);

            System.out.println("#" + tc + " "+result);

        }
    }
    private static void bfs(int si, int sj) {
        PriorityQueue<road> q = new PriorityQueue<>();
        q.add(new road(si,sj,0));
        visited[si][sj] = true;

        while(!q.isEmpty()) {
            road now = q.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                result = Math.min(result, now.time);
            }


            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    q.add(new road(nx, ny , now.time + map[nx][ny]));
                    visited[nx][ny] = true;

                }
            }
        }
    }



    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}