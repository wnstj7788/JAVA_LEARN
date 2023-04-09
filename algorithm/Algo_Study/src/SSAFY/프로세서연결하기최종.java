package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 프로세서연결하기최종 {


    static class process {
        int x, y;

        public process(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int map[][];
    static int dx[] = {-1,1,0,0}; // 상 하 좌 우
    static int dy[] = {0,0,-1,1};
    static int N;
    static ArrayList<process> Pro;
    static int maxCore;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            Pro = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        if (!(i == 0 || i == N-1 || j == 0 || j == N-1)) {
                            Pro.add(new process(i, j));
                        }
                    }
                    map[i][j] = temp;
                }
            }// input end

            maxCore = Integer.MIN_VALUE;
            result = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            System.out.println("#" +  tc +" " + result);

        }


    }

    private static void dfs(int idx, int con, int lengh){
        if (idx == Pro.size()) {

            if(maxCore < con){ // 기존 연결보다  더 많이 연결이 되었는가?

                maxCore = con;
                result = lengh;

            }else if(maxCore == con){
                result = Math.min(lengh , result);
            }

            return;
        }





    }


}
