import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_보급로 {

    static int N, map[][];
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < N ; j++) {
                    map[i][j] = ch[j] - '0';

                }
            }
            System.out.println("#" + tc + " " + dijkstra());

        }
    }

    private static int dijkstra() {
        final int INF = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        int[][]  minTime = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                minTime[i][j] = INF;
            }
        }

        minTime[0][0] = 0;
        pq.offer(new int[] {0,0,minTime[0][0]});

        int[] now = null;
        int r, c, minCost;
        while(true){

            //step 1
            now = pq.poll();
            r = now[0];
            c = now[1];
            minCost = now[2];
            if(visited[r][c]) continue;
            visited[r][c] = true;
            if(r == N-1 && c == N-1) return minCost;


            //step 2
            int nr = 0; int nc = 0;
            for (int d = 0; d < 4 ; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && ! visited[nr][nc] && minTime[nr][nc] > minCost+ map[nr][nc]){
                    minTime[nr][nc]  = minCost+ map[nr][nc];
                    pq.add(new int[] {nr,nc, minTime[nr][nc]});
                }
            }


        }

    }
}
