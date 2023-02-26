import java.util.Scanner;

public class BOJ_1074_Z {
		static int r,c,N, ans;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			r =sc.nextInt();
			c = sc.nextInt();
			
			//func(0,0,(int)Math.pow(2,N),(int) Math.pow(2,N)); // 거듭 제곱만드는거 아래도 가능 
			func(0,0,1<<N,1<<N);
			
			System.out.println(ans);
			
		}
		
	
	static int cnt;
	static void func(int si, int sj, int ei, int ej){
		
		if(ei-si ==1) {
			if(si ==r  && sj ==c) {
				ans = cnt;
			}
			cnt ++;
			return;
		}
		
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		
		
		func(si,sj,mi,mj); //1번
		func(si,mj,mi,ej); //2번
		func(mi,sj,ei,mj); //3번
		func(mi,mj,ei,ej); //4번
		
		
		
				
	}
	
	
	static void print(int[][] origin) {
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin.length; j++) {
				System.out.print(origin[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

}
