package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406_대건버전 {

static int n;
static int m;
static int num;
static int[][] arr;
static int[][] storeArr;

static int[] di = { 0, 1, 0, -1 };
static int[] dj = { 1, 0, -1, 0 };

static boolean[] select;
static Op[] ops;
static Op[] combResult;

static int sum;
static int minVal;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    num = Integer.parseInt(st.nextToken());
    
    arr = new int[n][m];
    storeArr = new int[n][m];

    for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
            storeArr[i][j] = arr[i][j];
//                    System.out.print(arr[i][j] + " ");
            }
//                System.out.println();
        }
        ops = new Op[num];
        combResult = new Op[num];
        select = new boolean[num];

    for (int i = 0; i < num; i++) {
        st = new StringTokenizer(br.readLine());
        Op o = new Op(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        ops[i] = o;

    }
    minVal = Integer.MAX_VALUE;
    comb(0);
    System.out.println(minVal);

}

private static void rotate(Op[] operate, int[][] storeArr, int idx, int[][] fromArr) {
    if(idx == num){
        for(int i=0; i<storeArr.length; i++){
            sum = 0;
            for(int j=0; j<storeArr[i].length; j++){
                sum += storeArr[i][j];
            }
            minVal = Math.min(minVal, sum);
        }
        return;
    }
    
    int r, c, s;
    r = operate[idx].r;
    c = operate[idx].c;
    s = operate[idx].s;
    int[][] nextArr;
    int depth = Math.min(r + s, c + s);
    depth /= 2;
    for (int d = 0; d <= depth; d++) {
        int dir = 0;
        int i = r - s - 1 + d;
        int j = c - s - 1 + d;
        int nexti;
        int nextj;

        while (dir < 4) {
            nexti = i + di[dir];
            nextj = j + dj[dir];
            if (nexti < r-s+d-1  || nextj < c-s+d-1 || nexti > r+s-1-d || nextj > c+s-1-d) {
                dir++;
                continue;
            }

            storeArr[nexti][nextj] = fromArr[i][j];
            i = nexti;
            j = nextj;
        }
    }

    //바뀐 배열 임시 배열에 저장 후 파라미터로 넘김
    nextArr = deepCopy(storeArr);
    rotate(operate, storeArr.clone(), idx+1, nextArr);

}

private static void comb(int cnt) {

    if (cnt == num) {
        rotate(combResult, storeArr, 0, arr);
        //테스트 배열 원상 복구
        storeArr = deepCopy(arr);
        return;

    }

    for (int i = 0; i < ops.length; i++) {
        if (select[i]) {
            continue;
        }
        select[i] = true;
        combResult[cnt] = ops[i];
        comb(cnt + 1);
        select[i] = false;

    }

}
//2차 배열 deep copy
static int[][] deepCopy(int[][] origin){
    int[][] copy = new int[origin.length][origin[0].length];
    for(int i=0; i<origin.length; i++) {
        for(int j=0; j<origin[0].length; j++) {
            copy[i][j] = origin[i][j];
        }
    }
    return copy;
}


private static class Op {
    int r, c, s;

    public Op(int r, int c, int s) {
        super();
        this.r = r;
        this.c = c;
        this.s = s;
    }
    @Override
    public String toString() {
        return "Op [r=" + r + ", c=" + c + ", s=" + s + "]";
    }

}
}