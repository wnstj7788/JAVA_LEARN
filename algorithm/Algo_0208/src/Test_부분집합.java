import java.util.Arrays;

public class Test_부분집합 {
	static String[] cards = {"A","B","C"};
	static boolean[] select = new boolean[cards.length];
	
	public static void main(String[] args) {
		subset(0);
	}
	
	static void subset(int idx) {
		if(idx==cards.length) {
			System.out.println(Arrays.toString(select));
			return;
		}
		
		select[idx] = true;
		subset(idx+1);
		select[idx] = false;
		subset(idx+1);
	}
}

















