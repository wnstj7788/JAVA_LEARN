import java.util.Scanner;

public class BOJ_2493_탑 {
    static int N;
    static int top[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        top = new int[N];

        for (int i = 0; i < args.length; i++) {
            top[i] = sc.nextInt();
        }



    }

}




