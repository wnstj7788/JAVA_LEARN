import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141_연구소2 {
    static class virus{
        int x, y , time;

        public virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static LinkedList<Point> cards;

    static int result = Integer.MAX_VALUE;

    static int map[][];
    static boolean visited[][];

    static boolean isSelected[];

    static int N,M ,zeroZone;
    static int combResult[];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][N];


        cards = new LinkedList<>();
        combResult = new int[M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = stoi(st.nextToken());
                if(temp == 0){
                    zeroZone++;
                }
                if(temp == 2){
                    cards.add(new Point(i,j));
                    zeroZone++;
                }
                map[i][j] = temp;


            }
        }
        isSelected = new boolean[cards.size()];

        comb(0,0);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else if(result == 0) {
            System.out.println(result);
        }else{
            System.out.println(result +1);
        }
    }


    private static void comb(int cnt, int start){


        if(cnt == M){
            //System.out.println(Arrays.toString(combResult));
            bfs();
            return;

        }



        for (int i = start; i < isSelected.length; i++){
            combResult[cnt] = i;
            comb(cnt +1, i +1);
        }


    }


    private static void bfs(){
        int copy[][] = deepCopy(map);
        visited = new boolean[N][N];
        int zero = 0;
        Queue<virus> q = new LinkedList<>();
        for (int i = 0; i < combResult.length; i ++){
            Point temp = cards.get(combResult[i]);
            q.add(new virus(temp.x, temp.y,0));
            visited[temp.x][temp.y] = true;
            zero++;
        }
        int time = 0;
        while (!q.isEmpty()){
            //print(copy);
            virus now = q.poll();
            time = now.time;


            for (int d = 0; d < dx.length; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && copy[nx][ny] != 1 ){
                        zero++;

                    copy[nx][ny] = now.time;
                    visited[nx][ny] = true;
                    q.add(new virus(nx, ny, now.time+1));
                }
            }
            if(zero == zeroZone){
                result = Math.min(result, time );
            }
        }





    }

    static int stoi (String a){
        return Integer.parseInt(a);
    }

    private static int[][] deepCopy(int arr[][]){
        int copy[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        return copy;
    }

    static void print(int[][] arr){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("____________________________________________");

    }


}


