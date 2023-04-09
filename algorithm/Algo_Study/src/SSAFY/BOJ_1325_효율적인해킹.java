package SSAFY;

import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.lang.*;

public class BOJ_1325_효율적인해킹 {
    static boolean visited[];
    static ArrayList<Integer> mylist[];
    static int ans[];

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        mylist = new ArrayList[N + 1];
        // 배열 1부터 시작
        for (int i = 1; i <= N; i++) {
            mylist[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st =new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
//            System.out.println(node + " " + edge);
            mylist[node].add(edge);

        }


        ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i); // 모든 노드에 대해서 실행
//           System.out.println(Arrays.toString(ans));
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(ans[i], result);
//            System.out.println("나 reulst" + " " + result);
        }

        //중복되는 result값 호춣
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result == ans[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);

    }// main end

    private static void dfs(int startNode) {
        for (int i = 0; i < mylist[startNode].size(); i++) {
            int node = mylist[startNode].get(i);
            if (!visited[node]) {
                ans[node]++;
                visited[node] = true;
                dfs(node);
            }
        }


    }
}
