import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 모든 경우을 다 해봐서 최적의 해를 구하는 문제
 * 부분집합을 활용하여 나눌 수 있는 모든 경우를 계산
 * 선택된 도시는 A, 선택이 안된 도시는 B로 분류하여 2가지 경우 모두 연결이 가능한지 확인
 * 가능하다면 최소 값을 구하고 아니면 -1을 출력
 *
 *
 */


public class BOJ_17471_게리맨더링 {

    static int N;
    static int result = Integer.MAX_VALUE;
    static int population[];
    static ArrayList<Integer>[] adjList;
    static boolean isSelectd[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        adjList = new ArrayList[N + 1];

        // 인구 정보
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<>();
        }
        // 인접한 구역 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        isSelectd = new boolean[N + 1];
        subset(1);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }


    }

    //부분 집합으로 모든 경우의 수 체크 
    private static void subset(int idx) {
        // 모든 경우의 수 
        if (idx == N + 1) {
            // 각 선거구에 포함된 구역이 모두 연결되었는지 확인
            if (cheak() == true) {
                // 연결되었다면

//            	// debuging
//            	for (int i = 1; i < isSelectd.length; i++) {
//					if(isSelectd[i])
//						System.out.print(i + " ");
//					else
//						System.out.print("X" + " ");
//				}
//            	System.out.println();

                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (isSelectd[i]) sumA += population[i];
                    else sumB += population[i];
                }
                // 두 값중 더 작은 값
                result = Math.min(result, Math.abs(sumA - sumB));
            }

            return;
        }

        // A 구역으로 
        isSelectd[idx] = true;
        subset(idx + 1);
        // B 구역으로 
        isSelectd[idx] = false;
        subset(idx + 1);

    }

    // 가능한 케이스 인지 확인하는 과정 
    private static boolean cheak() {
        boolean[] visited = new boolean[N + 1];

        int selectedA = -1;
        //A구역 찾기 
        for (int i = 1; i <= N; i++) {
            if (isSelectd[i]) {
                selectedA = i;
                break;
            }
        }
        int selectedB = -1;
        // B 구역 찾기 
        for (int i = 1; i <= N; i++) {
            if (!isSelectd[i]) {
                selectedB = i;
                break;
            }
        }

        // 한 구역에 몰려있는 경우  선거구로 나눌 수 없기에 false 리턴 
        if (selectedA == -1) return false;
        if (selectedB == -1) return false;

        Queue<Integer> q = new LinkedList<>();
        //A구역으로 확인 
        q.add(selectedA);
        visited[selectedA] = true; // 해당 구역 방문 처리 
        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 구역과 연결된 구역들을 확인
            for (int i = 0; i < adjList[now].size(); i++) {
                // 이미 방문 한 곳이면 continue;
                if (visited[adjList[now].get(i)]) continue;
                // B구역 녀석이면 continue;
                if (!isSelectd[adjList[now].get(i)]) continue;

                // 방문안하고 나랑 인접해있으면 방문처리하고 큐에 넣기 
                visited[adjList[now].get(i)] = true;
                q.add(adjList[now].get(i));
            }
        }

        // B구역 전부 연결되어있는지 확인 
        q.add(selectedB);
        visited[selectedB] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 구역과 연결된 구역들을 확인
            for (int i = 0; i < adjList[now].size(); i++) {
                // 이미 방문 한 곳이면 continue;
                if (visited[adjList[now].get(i)]) continue;
                // A구역 녀석이면 continue;
                if (isSelectd[adjList[now].get(i)]) continue;
                visited[adjList[now].get(i)] = true;
                q.add(adjList[now].get(i));
            }
        }

        // A든 B든 연결이 안되었다면  연결이 안된 것으로 판단 
        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

}