package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class BOJ_17135_캐슬디펜스_re {
    static int N, M , D;
    static boolean isSelected[];
    static int combResult[] , map[][];
    static int result = Integer.MIN_VALUE , attackCnt;

    static class allow{
        int x,  y;

        public allow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isSelected = new boolean[M];
        combResult = new int[3];
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// input end

        comb(0,0);

        System.out.println(result);
    }

    private static void comb(int idx, int start){
        if(idx == 3){
         //   System.out.println(Arrays.toString(combResult));
            int tempMap[][] = deepCopy();
//            for (int i = 0; i < 3; i++) {
//                tempMap[N][combResult[i]] = 9;
//            }



            result = Math.max(bfs(combResult , tempMap), result);

            return;
        }

        for (int i = start; i < M; i++) {
            combResult[idx] = i;
            comb(idx +1, i +1 );

        }

    }
    private static int bfs(int arr[], int tempMap[][]){
        Queue<allow> q = new LinkedList<>();
        ArrayList<allow> target = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            q.add(new allow(N , arr[i]));
        }
        attackCnt = 0;
        System.out.println(Arrays.toString(arr));
        while (!q.isEmpty()){
            int qsize = q.size();
            for (int s = 0; s < qsize; s++) {
                allow now = q.poll();
                // 첫 번째 궁수부터 타켓 지정해서 ArrayList에 넣기
                boolean flag = true;
                for (int i = N -1 ; i >= 0 ; i--) {
                    for (int j = 0; j < M; j++) {
                        if(tempMap[i][j] == 1){
                            //타켓 잡았으면 멈춰!
                            // 공격 가능 범위에 있는지 확인 후 넣고 멈춰

                            if(D >= distance(now.x, i, now.y, j)) {

                                target.add(new allow(i, j));
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(flag == false){
                        break;
                    }
                }
                q.add(new allow(now.x, now.y));
            }// 한 턴이 끝났으면 공격 실시
//            System.out.println("공격전");
//            print(tempMap);
            for (int i = 0; i < target.size(); i++) {
                //현재 위치가 1이라면 공격 카운트 on
                if(tempMap[target.get(i).x][target.get(i).y] == 1){
                    attackCnt++;
                    tempMap[target.get(i).x][target.get(i).y] = 0;
                }
            }
            target.clear(); //비워버려

            System.out.println("공격 후" + attackCnt);
            print(tempMap);

            //이제 내리는 연산 하고 더 실행해야하는지 확인하고 끝내기
            tempMap = move(tempMap);



            if(cheak(tempMap)){
                break;
            }

        }

    return attackCnt;
    }



    private static int distance(int r1, int r2, int c1, int c2){
        return Math.abs(r1 - r2) + Math.abs(c1-c2);
    }


    private static int[][] move(int tempMap[][]){
        int temp[] = new int[M];
        for (int i = N -2; i >= 0 ; i--) {
            for (int j = 0; j < M ; j++) {
                temp[j] = tempMap[i][j];
            }
            for (int j = 0; j < M; j++) {
                tempMap[i+1][j] = temp[j];
            }
        }
        for (int i = 0; i < M; i++) {
            tempMap[0][i] = 0;

        }

        return tempMap;
    }

    private static boolean cheak(int teamMap[][]){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(teamMap[i][j] == 1){
                    return false;
                }
            }
        }
       return true;
    }



    private static int[][] deepCopy(){
        int tempMap[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
        return tempMap;
    }



    private static void print(int map[][]){
        for(int temp[] : map){
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }


}


