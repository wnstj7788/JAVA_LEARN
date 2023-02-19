import java.util.Arrays;


public class Test01_perm {
	static int N =4, R =3;
	static String [] cards = {"A","B","C","D"};
	static int cnt = 0;
	
	static boolean[] used  = new boolean[N];
	
	static String [] result = new String[R];
	
	public static void main(String[] args) {
		perm(0);
		
	}
	
	
	static void perm(int idx) { // 나는 result의 idx칸에 집착! 채워햐해ㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐ
		
		
		if(idx == R) {
			cnt++;
			System.out.println(Arrays.toString(result) + "cnt : " + cnt );
			return;
		}
		
		for(int i = 0; i< N ;i++) {//카드 번호이니 인덱스랑 해갈리지 말자  , 자 재료는 여러개가 있다잉 
			if(used[i]) continue; // 내 카드 ㅠㅠ 이미 쓰고 있네,,,, 그건 포기하고 다른 카드 보자!
			result[idx] = cards[i]; //다른 카드로 채우장
			used[i] = true;
			
			perm(idx +1); // 다음 졸라맨 소환~ . 너도 0부터 카드 다 새로봐라잉 
			
			used[i] = false;
			
		}
	}

}
