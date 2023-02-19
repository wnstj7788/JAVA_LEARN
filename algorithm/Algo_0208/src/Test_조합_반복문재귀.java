import java.util.Arrays;

// 얘는 조합을 구해주는데 코드가 순열 비스무리한데 인덱스가 약간 헷갈리(효율은 조금 좋은편)
public class Test_조합_반복문재귀 {
	static int N = 5, R = 2;
	static String[] cards = {"A","B","C","D","E"};
	static String[] result = new String[R];
	
	public static void main(String[] args) {
		for(int r=0; r<=N; r++) {
			comb(0, 0);
		}
	}
	
	static void comb(int idx, int start) {
		if(idx == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[idx] = cards[i];
			comb(idx+1, i+1);
		}
	}
}
