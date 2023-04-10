package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SWEA_수영장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        int[] day = new int[13];
        int[] money = new int[4];
        int[] dp = new int[13];
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }
 
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                day[i] = Integer.parseInt(st.nextToken());
            }
 
            for (int i = 1; i <= 12; i++) {
                int k1 = day[i] * money[0] + dp[i - 1];
                int k2 = money[1] + dp[i - 1];
                int k3 = 0;
                if (i >= 3) {
                    k3 = money[2] + dp[i - 3];
                }
                int k4 = money[3];
                int min = Integer.MAX_VALUE;
                min = Math.min(min, k1);
                min = Math.min(min, k2);
                if (i >= 3) {
                    min = Math.min(min, k3);
                }
                min = Math.min(min, k4);
                dp[i] = min;
            }
            System.out.println(Arrays.toString(dp));
            sb.append("#"+tc+" ").append(dp[12]).append("\n");
        }
        System.out.println(sb);
    }
}