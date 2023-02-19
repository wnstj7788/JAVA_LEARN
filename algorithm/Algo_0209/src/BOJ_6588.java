import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 3부터 시작해서 소수인지 판별 
// 소수면 해당 값에서 - 소수하고 
// 다시 소수인지 판별  ......  중간에 false라면 n/2 -1까지 for문 반복 

public class BOJ_6588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int end = 0;

		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				break;
			boolean temp = false;
			for (int i = 3; i < num / 2; i++) {

				if (isPrimeNumber(i)) {
					if (isPrimeNumber(num - i)) {
						System.out.println(num + " = " + i + " + " + (num - i));
						temp = true;
						break;
					}

				}

			}
			if(!temp) {
				System.out.println("Goldbach's conjecture is wrong.");
			}

		}

	}

	public static boolean isPrimeNumber(int x) { // 2이상의 x에 대해
		if (x < 2)
            return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

}
