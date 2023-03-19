import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
    static class chicken{
        int x , y , num;

        public chicken(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    static LinkedList<chicken> chickenHouse;

    static int N, M;
    static int cards[];
    static Boolean[] isSelected;
    static int result[];

    static int map[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][N];
        visited = new boolean[N][N];
        chickenHouse = new LinkedList<>();
        result = new int [M];
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
              int temp = Integer.parseInt(st.nextToken());
                if(temp == 2){
                    chickenHouse.add(new chicken(i,j,cnt++));
                }
                map[i][j] = temp;
            }
        }

        cards = new int [chickenHouse.size()];
        isSelected = new Boolean[chickenHouse.size()];

        comb(0,0);


    }


    private static void comb(int cnt, int idx){
        if(cnt == M){

        //bfs실행


        return;
        }

        for (int i = idx; i < chickenHouse.size(); i++) {
           if(isSelected[i] == false){
               isSelected[i] = true;
                comb(cnt +1 , i +1);
                isSelected[i] = true;
           }
        }

    }

    private static void bfs(){


    }

}