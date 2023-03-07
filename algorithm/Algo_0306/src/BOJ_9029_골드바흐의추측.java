import java.util.Scanner;

public class BOJ_9029_골드바흐의추측 {

    /*
        false : 소수
        range : 0 ~ 10000
    */
    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        get_prime();

        int T = in.nextInt();	// 테스트케이스

        while (T-- > 0) {
            int n = in.nextInt();
            int first_partition = n / 2;
            int second_partition = n / 2;

            while (true) {

                // 두 파티션이 모두 소수일 경우
                if (!prime[first_partition] && !prime[second_partition]) {
                    System.out.println(first_partition + " " + second_partition);
                    break;
                }
                first_partition--;
                second_partition++;
            }
        }

    }

    // 에라토스테네스의 체
    public static void get_prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

}