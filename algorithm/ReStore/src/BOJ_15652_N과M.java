import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15652_N과M {
    static int N, M;
    static int result[];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result  = new int[M];


        perm(0 ,1);

        System.out.println(sb);
    }

    private static void perm(int idx, int cnt){
        if(idx == M){
            for (int i = 0; i < M; i++) {
               sb.append(result[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = cnt; i <= N ; i++) {
            result[idx] = i;
            perm(idx +1, i);
        }

    }
}
