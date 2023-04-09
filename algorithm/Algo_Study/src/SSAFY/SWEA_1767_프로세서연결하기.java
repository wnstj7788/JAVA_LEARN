package SSAFY;

import java.lang.*;
import java.io.*;
import java.util.*;

public class SWEA_1767_프로세서연결하기 {
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

    private static void dfs(int idx, int con, int lengh) { // 인덱스 , 연결된 코어 수, 전선의 길이

        if (idx == Pro.size()) {

            if(maxCore < con){ // 기존 연결보다  더 많이 연결이 되었는가?

                maxCore = con;
                result = lengh;

            }else if(maxCore == con){
                result = Math.min(lengh , result);
            }
            return;
        }

        int x = Pro.get(idx).x;
        int y = Pro.get(idx).y;


        for (int d = 0; d < 4; d++) {
            int count = 0, nx = x, ny = y;
            while (true) {

                 nx += dx[d];
                 ny += dy[d];


                if (nx < 0 || nx >= N || ny < 0 || ny >= N) { // 전선 범위를 넘어서는 경우
                    break;
                }

                if (map[nx][ny] == 1) { // 이미 채워져있는 경우
                    count = 0; // 이동 수를 0으로
                    break;
                }

                count++; //위 조건 안걸리고 오면

            }

            int nx_temp = x;
            int ny_temp = y;

            for (int i = 0; i < count; i++) { //움직인 수 만큼 배열 채워주기
                nx_temp += dx[d];
                ny_temp += dy[d];
                map[nx_temp][ny_temp] = 1; //움직 일 수 있으면 채우기
            }

//            System.out.println("=============="+ d +"=====================");
//
//            for(int tmep[] : map){
//                System.out.println(Arrays.toString(tmep));
//            }
//
//
//            System.out.println("=============="+ d +"=====================");

            if(count == 0){//프로세서가 못 움직이는 상황이였다면

                dfs(idx +1, con, lengh);
            }else{
                //움직 일 수 있는 상황이였다면

                dfs(idx +1, con +1 , lengh + count);
                //dfs 바꾼 배열 상태로 계속 보내고 다음 방향 전환의 상황을 고려하기 위해서 배열을 다시 바꿔줌
                nx_temp = x;
                ny_temp = y;
                for (int i = 0; i < count; i++) { //움직인 수 만큼 배열 채워주기
                    nx_temp += dx[d];
                    ny_temp += dy[d];
                    map[nx_temp][ny_temp] = 0; //움직 일 수 있으면 채우기
                }
            }


        }

    }


}
