import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10974_Re {
    static int cards[];
    static boolean isSelected[];

    static int result[];
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         N = sc.nextInt();
         cards = new int[N];
         isSelected = new boolean[N];
         result = new int[N];

        for (int i = 1; i <= N; i++) {
            cards[i-1] = i;
        }

        perm(0);
    }


    private static void perm(int cnt){
        if(cnt == N){
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < cards.length ; i++) {
            if(isSelected[i]) continue;
            result[cnt] = cards[i];
            isSelected[i] = true;
            perm(cnt+1);
            isSelected[i] = false;

        }

    }
}
