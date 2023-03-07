import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    static class getFire {
        int x, y, d;

        public getFire(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static Queue<getFire> sang, fire;

    static int ans = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= TC; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sang = new LinkedList<>();
            fire = new LinkedList<>();
            map = new char[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    char temp = ch[j];
                    if (ch[j] == '@') {
                        sang.add(new getFire(i, j, 0));
                    }
                    if (ch[j] == '*') {
                        fire.add(new getFire(i, j, 0));

                    }
                    map[i][j] = ch[j];
                }
            }//inout end

            if (!bfs()) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans);
            }
        }//tc end

    }//main end

    private static boolean bfs() {
        while (!sang.isEmpty()) {

            //불
            int fireSize = fire.size();
            for (int size = 0; size < fireSize; size++) {
                getFire now = fire.poll();
                for (int i = 0; i < dx.length; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] != '*') {
                        if (map[nx][ny] == '#' || map[nx][ny] == '*') {
                            continue;
                        } else {
                            map[nx][ny] = '*';
                            fire.add(new getFire(nx, ny, now.d + 1));
                        }
                    }

                }

            }

            //상근
            int sangSize = sang.size();
            for (int i = 0; i < sangSize; i++) {

                getFire nowSang = sang.poll();
                for (int d = 0; d < dx.length; d++) {
                    int nx = nowSang.x + dx[d];
                    int ny = nowSang.y + dy[d];
                    if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) {
                        ans = nowSang.d + 1;
                        return true;
                    }

                    if (map[nx][ny] == '.' && map[nx][ny] != '*' && map[nx][ny] != '#') {
                        map[nx][ny] = '@';
                        sang.add(new getFire(nx, ny, nowSang.d + 1));

                    }
                }

            }
       // print();

        }


        return false;
    }


    private static void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("________________________________________");
    }

}
