import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchCount = Integer.parseInt(br.readLine()); // 스위치 갯수

		int[] arr = new int[switchCount + 1]; // 스위치 상태 기록 스위치번호 1번부터 쓰네!

		StringTokenizer input = new StringTokenizer(br.readLine()); // 0 0 1 0 1 1 1 0
		for (int i = 1; i <= switchCount; i++) // 스위치 1번부터인거 신경쓰기!
			arr[i] = Integer.parseInt(input.nextToken());

		int studentCount = Integer.parseInt(br.readLine()); // 학생 수

		for (int s = 0; s < studentCount; s++) {
			input = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(input.nextToken()); // 남자냐 여자냐
			int num = Integer.parseInt(input.nextToken()); // 스위치 번호 ex)3

			if (gender == 1)
				boy(arr, num, 1, switchCount); // 곱할거라 1부터 가면 자기자신부터
			else {
				arr[num] = arr[num] == 0 ? 1 : 0; // 일단 자기 스위치 한번 누르고
				girl(arr, num, 1, switchCount); // 양옆 멀어지는 대칭 작업 보내기
			}
		} // end student

		for (int i = 1; i <= switchCount; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}

	static void boy(int[] arr, int num, int i, int switchCount) {
		if (num * i > switchCount)
			return;

		arr[num * i] = arr[num * i] == 0 ? 1 : 0;
		boy(arr, num, i + 1, switchCount);
	}

	static void girl(int[] arr, int num, int k, int switchCount) {
		if (num + k > switchCount || num - k < 1)
			return;

		if (arr[num + k] == arr[num - k]) {
			arr[num + k] = arr[num + k] == 0 ? 1 : 0;
			arr[num - k] = arr[num - k] == 0 ? 1 : 0;
			girl(arr, num, k + 1, switchCount);
		} else {
			return;
		}
	}
}