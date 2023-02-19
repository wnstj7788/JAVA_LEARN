import java.util.Scanner;

public class BOJ_2961 {
	static Ingredient[] cards; //부분집합을 만들 재료 ( 모집합)
	static int ans, N;
	static boolean[] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		cards = new Ingredient[N];
		select = new boolean[N];
		
		ans = Integer.MAX_VALUE;
		
		for (int n =0; n < N; n ++) {
			cards[n] = new Ingredient(sc.nextInt(), sc.nextInt());
		}
		
		subset(0);
		
	}
	static void subset(int idx) {
		if(idx == N) {
			int soursum =1, bittersum =0;
			for(int i = 0;  i< N; i++) {
				if(select[i]) {
					bitter += cards[i].bitter;
					soursum *= cards[i].sour;
				}
			}
		}
		select[idx] = true;
	}
	
	
	
	static class Ingredient{
		int bitter, sour;
		
		public Ingredient(int sour, int bitter) {
			this.sour;
			this.bitter;
		}
	}

}
