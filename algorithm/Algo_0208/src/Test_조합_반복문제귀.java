import java.util.Arrays;

public class Test_조합_반복문제귀 {
	static int N =5, R =2;
	static String[] cards = {"A","B","C","D","E"}; // 안에 들어가는거 숫자 , 객체 등 될 수 있음
	//
	static String[] result = new String[R];
	
	
	public static void main(String[] args) {
		comb (0,0);
	}
	
	
	
	static void comb(int idx, int start) {
		if(idx == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = start; i< N ; i++) {
			result[idx] = cards[i];
			comb(idx +1, i+1);
		}
	}
}



