import javax.swing.*;
import java.util.Scanner;

public class BOJ_15651_N과M {
    static int N;
    static int M;
//    static int cards[];
static StringBuilder sb = new StringBuilder();
    static int result[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
//        cards = new int[N];
        result = new int[M];
//        for (int i = 0; i < N ; i++) {
//            cards[i] = i+1;
//        }

        comb(0);
        System.out.println(sb);


    }

    private static void comb(int cnt) {
        if(cnt == M){
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 0; i <N; i++) {
            result[cnt] = i+1;
            comb(cnt +1 );
        }

    }
}





//import java.util.Scanner;
//
//public class Main {
//    static int N, M;
//    static int[] arr;
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        M = sc.nextInt();
//        arr = new int[M];
//        dfs(0);
//        System.out.print(sb);
//    }
//
//    public static void dfs(int depth) {
//        if (depth == M) {
//            for (int i = 0; i < M; i++) {
//                sb.append(arr[i] + " ");
//            }
//            sb.append("\n");
//            return;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            arr[depth] = i;
//            dfs(depth + 1);
//        }
//    }
//}

