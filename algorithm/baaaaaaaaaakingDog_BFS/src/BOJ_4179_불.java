import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ_4179_불 {
 
    static int R, C, res;
    static char map[][];
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    static Queue<State> fire, jh;
    static class State {
        int x, y, d;
 
        public State(int x, int y, int d) {
            super();
            this.x = x;
            this.y = y;
            this.d = d;
        }
        
    }
    
    private static boolean bfs() {
        
        while(!jh.isEmpty()) {
            
            // 불이 먼저 퍼진다.
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                State now = fire.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    
                    // 범위를 벗어나면 pass
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    // 벽이거나 방문한 곳이면 pass
                    if(map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
                    
                    map[nx][ny] = 'F';
                    fire.add(new State(nx, ny, now.d + 1));
                }    
            }    
            
            // 지훈이가 불을 피해 이동
            size = jh.size();
            for (int i = 0; i < size; i++) {
                State now = jh.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    
                    // 지훈이는 범위를 벗어나면 탈출
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        res = now.d + 1;
                        return true;
                    }
                    
                    // 벽이거나 불이거나 방문한 곳이면 pass
                    if(map[nx][ny] == '#' || map[nx][ny] == 'F' || map[nx][ny] == 'J') continue;
                    
                    map[nx][ny] = 'J';
                    jh.add(new State(nx, ny, now.d + 1));
                }    
            }
        }
 
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        
        fire = new LinkedList<>();
        jh = new LinkedList<>();
        
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                // 지훈이의 위치
                if(map[i][j] == 'J') {
                    jh.add(new State(i, j, 0));
                }
                // 불의 위치
                else if(map[i][j] == 'F') {
                    fire.add(new State(i, j, 0));
                }
            }
        }
        
        if(bfs()) System.out.println(res);
        else System.out.println("IMPOSSIBLE");
    }
}
 
