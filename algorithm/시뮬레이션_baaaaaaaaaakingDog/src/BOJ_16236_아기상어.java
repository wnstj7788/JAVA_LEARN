import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236_아기상어{
    static int n;
    static int[][] board;
    static int dx[] = {-1, 0, 1, 0}; //위 왼 아래 오
    static int dy[] = {0, 1, 0, -1};
    static ArrayList<shark> fishes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        Queue<shark> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
                if(board[i][j] == 9){
                    q.add(new shark(i, j, 0));
                    board[i][j] = 0;
                }
            }
        }

        int eat = 0;
        int time = 0;
        int age = 2;
        while(true){
            LinkedList<shark> fish = new LinkedList<>();
            int[][] dist = new int[n][n];
            
            while (!q.isEmpty()) {
               // print(dist);
                shark now = q.poll();

                for(int d=0; d<4; d++){
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny]==0 && board[nx][ny] <= age){
                        dist[nx][ny] = dist[now.x][now.y] + 1;
                        q.add(new shark(nx, ny, dist[nx][ny]));
                        if(1 <= board[nx][ny] && board[nx][ny] <= 6 && board[nx][ny] < age)
                            fish.add(new shark(nx, ny, dist[nx][ny]));
                    }
                }
            }

            if(fish.size() == 0){
                System.out.println(time);
                return;
            }

            shark currentFish = fish.get(0);
            for(int i = 1; i < fish.size(); i++){
                if(currentFish.dist > fish.get(i).dist) {
                    currentFish = fish.get(i);
                }
                else if(currentFish.dist == fish.get(i).dist) {
                    if(currentFish.x > fish.get(i).x) currentFish = fish.get(i);
                    else if(currentFish.x == fish.get(i).x){
                        if(currentFish.y > fish.get(i).y) currentFish = fish.get(i);
                    }
                }
            }

            time += currentFish.dist;
            eat++;
            board[currentFish.x][currentFish.y] = 0;
            if(eat == age) {
                age++;
                eat = 0;
            }

            q.add(new shark(currentFish.x, currentFish.y, 0));
        }
    }

    public static class shark {
        int x;
        int y;
        int dist;

        public shark(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }






    static void print(int[][] arr){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("____________________________________________");

    }
}