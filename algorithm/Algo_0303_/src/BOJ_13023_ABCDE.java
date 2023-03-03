import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13023_ABCDE {
    static int N;
    static int M;
    static ArrayList<Integer> []adjList;
    static boolean visited[];
    static boolean ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        adjList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited = new boolean[N];
        ans = false;

        for (int i = 0; i < N; i++) {
            dfs(i,1); //함수한테 자기 번호주면서 선까지 몇명인지 같이 넣어주기
            if(ans) break; // 방금 i에서 5현제 찾음 , 굳이 다른 정점 출발 불필요
        }
        if(ans){
            System.out.printf("1");
        }else
            System.out.printf("0");

    }



  //돌아 갈 수 없어서 bfs로 해결 할 수 없다.
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;

        int cnt =1;
        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int now = q.poll();

                for(int next: adjList[now]){

                }

            }
        }

    }

    static void dfs(int now , int cnt){
        if(cnt == 5){
            ans = true;
            return;
        }

        visited[now] = true;
        for(int next : adjList[now]) { // 내 친구 목록에 있는 애들중
            if (!visited[next]) { // 건반 안누른 상태인 애들만 골라서
                dfs(next, cnt + 1); // 너까지하면 한명 늘어난다고 바통넘기고
            }//기다려

        }
        visited[now] = false; // 나중에 다시 찾아와도 되는 부분
    }


    //union으로 풀었을 때 불가능한가?
    // 불가능 하다. 싸이클를 찾는 문제가 아니라 5개 이상 이어진 노드의 집합을 찾는 문제였다
    //생각해보고 혼자 풀어보기


}
