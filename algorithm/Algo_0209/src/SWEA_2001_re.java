import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_re {
    static int max,n,m;   // n*n : 배열의 개수, m*m : 파리채 크기
    static int[][] area;  // 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            area = new int[n][n];

            for(int i = 0; i < n; i++){ // 배열에 값 집어넣는 for문
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            // 모든 경우의 수 구하기
            for(int i = 0; i <= n - m; i++){
                for(int j = 0; j <= n-m; j++){
                    getMax(i,j);
                }
            }

            System.out.println("#" + tc + " " + max);
        }

    }

    // 파리채 구하기 
    static void getMax(int x, int y){
        int sum = 0;
        for(int i = x; i < x + m; i++){
            for(int j = y; j < y + m; j++){
                sum += area[i][j];
            }
        }
        if(max < sum)
            max = sum;
    }
}