import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
    /*
    나보다 큰 애들만 있거나 전부다 맵이 0이라면 종료해야함
     */
    static class shark{
        int x, y, size, cnt;
        public shark(int x, int y, int size,int cnt) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt =  cnt;
        }
    }
    static int N;
    static int map[][];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static boolean visited[][];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        shark babyshark = null;
        map = new int[N][N];
        visited = new boolean[N][N];
        int cnt = 0;
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if( temp == 9){
                    babyshark  = new shark(i,j,2,1);
                    temp = 0;

                }
                if(temp == 0){
                    cnt++;
                }
                map[i][j] = temp;

            }
        }
        //print();
        if(cnt == N*N){
            System.out.println(0);
        }else {
            System.out.println(bfs(babyshark));
        }
    }


    private static int bfs(shark babyshark){
        // 내 사이즈 이하면 이동은 가능
        // 내 사이즈보다 작으면 먹을 수 있음
        Queue<shark> q = new LinkedList<>();
        q.add(babyshark);
        visited[babyshark.x][babyshark.y] = true;

        while(!q.isEmpty()){
            shark now = q.poll();
            int nowLev = now.size;
            int Experience = 0;
            if(cheak(now.size)){ // 현재 이동 가능한지 체크 내 사이즈보다 더 큰 사이즈 애들만 있다면과 0만 있다면 멈춰
                //불가하다면 현재 내 사이즈 출력
                return now.cnt;

            }

            //현재 레벨하고 경험치가 같아지면 레벨업 할 예정
            for (int d = 0; d < dx.length; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx >= 0  && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] < now.size ){

                    // 나랑 똑같거나
                    if(map[nx][ny]  == now.size){
                        //이동가능
                        map[now.x][now.y] = 0; // 내 이전칸
                        visited[nx][ny] = true;
                        q.add(new shark(nx,ny,nowLev, now.cnt + 1));
                        ans = now.cnt;

                    }else if(map[nx][ny] < now.size){
                        Experience += map[nx][ny]; // 먹었으니 경험치 up
                        //경험치 먹고 잔여 경험치 계산
                        if(Experience >= nowLev){
                            Experience = Experience % nowLev;
                            nowLev += 1;
                        }
                        map[now.x][now.y] = 0; // 내 이전칸
                        visited[nx][ny] = true;
                        q.add(new shark(nx,ny,nowLev, now.cnt +1));
                        ans = now.cnt;


                    }


                }

            }


        }


    return ans;
    }


    //전체가 0인경우랑 0이 아닌것 중에 나보다 큰것만 있는 경우
    private static boolean cheak(int a) {
        int cnt = 0;
        for (int i = 0  ;i < N ; i ++){
            for(int j = 0; j < N; j ++){
                //나보다 작은 사이즈가 없는 경우
                if(map[i][j] != 0 && map[i][j] < a){
                    cnt++;
                }
            }
        }
        if(cnt == 0){
            return false;
        }

        return true;
    }


    private static void print(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();

        }
        System.out.println("-------------------------------------------");
    }
}
