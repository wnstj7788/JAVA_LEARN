import java.util.Arrays;

public class Test_조합_부분집합버전 {
	static int N=3, R=2;
	static String[] cards = {"A","B","C"};
	static boolean[] select = new boolean[cards.length];
	
	public static void main(String[] args) {
		subset(0,0);
	}
	
	static void subset(int idx, int cnt) {
		if(cnt==R) { //오 R개 뽑았대 ! 
			System.out.println(Arrays.toString(select));
			return;
		}
		
		if(idx==N) return;
		
		select[idx] = true;
		subset(idx+1, cnt+1);
		select[idx] = false;
		subset(idx+1, cnt);
	}
}
