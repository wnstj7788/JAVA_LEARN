import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N+1][N+1];

        // 이전값에 현재 값을 더 해주면서 부분합 구하기
        // 0번째 인덱스는 0으로 지정하고 사용하지 않기 때문에 첫번쨰 입력의 경우에도 아래의 수식이 성립합
        for (int i = 1; i <=N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N ; j++) {
                map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i <=N ; i++) {
//            for (int j = 0; j <=N ; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("-----------------------");



        for (int i = 0; i < M; i++) {
           st = new StringTokenizer(br.readLine());
           int si = Integer.parseInt(st.nextToken());
           int sj = Integer.parseInt(st.nextToken());
           int ei = Integer.parseInt(st.nextToken());
           int ej = Integer.parseInt(st.nextToken());

           int result = 0;
            for (int j = si; j <= ei; j++) {
                result += map[j][ej] - map[j][sj -1];
//                System.out.println("나 j " + j + "난 result: " + result  );
            }

           sb.append(result + "\n");

        }
        System.out.println(sb);

    }
}
