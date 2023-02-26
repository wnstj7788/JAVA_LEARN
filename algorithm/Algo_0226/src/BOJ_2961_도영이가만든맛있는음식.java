import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	static class food {
		int bitterness;
		int sour;
		public food(int sour,int bitterness)  {
			this.bitterness = bitterness;
			this.sour = sour;
		}
	}
	
	static int N;
	static boolean isSelected[];
	static ArrayList<food> foodlist = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			foodlist.add(new food(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		subset(0);
		System.out.println(min);
		
		

	}
	
	
	static void subset(int cnt) {
		if(cnt == N && cnt != 0) {
			int total = 0;
			int bitterness_sum = 0;
			int sour_Mult= 1;
			for(int i = 0; i < N;i++) {
				//해당 재료를 쓰고 있다면 
				if(isSelected[i] == true ) {
				//System.out.println(Arrays.toString(isSelected));
				//System.out.println(foodlist.get(i).sour);
					 bitterness_sum += foodlist.get(i).bitterness;				
					 sour_Mult = sour_Mult * foodlist.get(i).sour;
				}
			}
			if(bitterness_sum != 0 && sour_Mult != 1 ) {
			total = Math.abs(sour_Mult - bitterness_sum); 
			min = Math.min(total, min);
			//System.out.println("bitterness_sum : " + bitterness_sum +" sour_Mult  : " + sour_Mult);
			}
			return;
			
		}
		
		
		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt +1);
		
		
		
	}

}
