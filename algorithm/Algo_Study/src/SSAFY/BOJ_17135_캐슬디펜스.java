package SSAFY;

import java.awt.*;
import java.lang.*;
import java.util.*;
import java.io.*;

public class BOJ_17135_캐슬디펜스 {

    public static class allow {
        int x, y, cnt;

        public allow(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }


    }

    static int N, M, D; // 행의 수 , 열의 수 . 공격 사거리

    static int map[][];
    static int monsterCnt;
    static boolean isSelected[];
    static int combResult[];


    static int bfsResult;
	static int resultNum = Integer.MIN_VALUE;





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];
        isSelected = new boolean[M];
        combResult = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    monsterCnt++;
                }
                map[i][j] = temp;
            }

        } // input end

        comb(0, 0);

        System.out.println(resultNum);

    }// main end

    private static void comb(int idx, int start) {
        if (idx == 3) {
            System.out.println(Arrays.toString(combResult));

//			for (int i = 0; i < 3; i++) {
//				copyMap[N+1][combResult[i]] = 9; // 궁숭는 9로 표시해둘거임
//			}
			bfsResult = 0;
            bfs(combResult);
            resultNum = Math.max(resultNum, bfsResult);

            return;
        }

        for (int i = start; i < M; i++) {
            isSelected[i] = true;
            combResult[idx] = i;
            comb(idx + 1, i + 1);
            isSelected[i] = false;

        }


    }


    private static void bfs(int combResult[]) {
        int copyMap[][] = deepCopy(map);
       // System.out.println(Arrays.toString(combResult));
        Queue<allow> q = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            q.add(new allow(N, combResult[i], 0));
        }

        while (!q.isEmpty()) {
            //현재 queue사이즈 저장
            int Qsize = q.size();
            for (int i = 0; i < Qsize; i++) {
                // 궁수 하나당 쏠 수 있는 표적지 확인 후 발사
				allow now = q.poll();
				copyMap = killingMonster(now, copyMap);

				q.add(new allow(now.x, now.y, now.cnt));
                // 큐에 넣어주기
            }

            // 1초가 지난 상태이니 상태 확인 및 아래로 내려주기
            //2. 안 죽었으면 애들 전부다 내려
			copyMap = moveMoster(copyMap);
//            System.out.println(bfsResult + " <- bfsreuslt   monsterCnt ->" + monsterCnt );


            //맵 전체가 0이면 멈춰
           if(end(copyMap)){
               break;
            }

            //3. 내렸는데 다 죽었어? 멈춰
            // 4. 내렸는데도 아직 살아있어? 큐 반복
            // 끝


        }

    }

    private static boolean end(int copyMap[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j] == 1){
                    return false;
                }

            }
        }
        return true;
    }

    private static int[][] moveMoster(int[][] copyMap) {
        // 잘 내려주기만하면 끝난다
        for (int i = N ; i >= 1; i--) {
            int temp[] = copyMap[i-1];
            for (int j = 0; j < M; j++) {
                if(i == N){
                    if(temp[j] == 1){
                        monsterCnt--;
                        temp[j] = 0;
                    }
                }

                copyMap[i][j] = temp[j];

            }

        }
        for (int i = 0; i < M ; i++) {
            copyMap[0][i] = 0;

        }
//        System.out.println("내렸다 아래는 맵이다 ");
//        for(int[] temp : copyMap){
//            System.out.println(Arrays.toString(temp));
//        }

    return copyMap;
	}

	private static int[][] killingMonster(allow now, int[][] copyMap) {

			int si = now.x;
			int sj =  now.y;
            for (int i = N-1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
					if(copyMap[i][j] == 1){// 몬스터라면 체크

						if(distance(si,i,sj,j)){ // 쏠 수 있는 거리에 있는 궁수라면
                            copyMap[i][j] = 0;
                            //System.out.println("몬스터 죽임 ");
                            monsterCnt--;
							bfsResult++;
							return copyMap;
						}
					}

                }

            }

		return copyMap;
    }

	static boolean distance(int r1, int r2, int c1, int c2) {
		if( Math.abs(r1 - r2) + Math.abs(c1 - c2) <= D){
			return true;
		}
		return false;
	}


    private static int[][] deepCopy(int map[][]) {
        int copyMap[][] = new int[N + 1][M];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }

        }
        return copyMap;
    }

}





