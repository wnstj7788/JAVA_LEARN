import java.util.*;


public class SWEA_1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		

		
		for(int t = 0; t < test; t++) {	
			int [][] map = new int[9][9];
			boolean sign = true;
			for(int i = 0; i <9; i++) {
				for (int j = 0; j < 9;  j++) {
				map[i][j] = sc.nextInt();
				}	
			}
			
		
		// 행체
		for(int i =0; i<9; i++) {
			int[] arr = new int[9]; //행을 담아둘 공간 생성
			for(int j= 0; j < 9; j++) {
				arr[map[i][j]-1] ++ ;
			}
			for(int a = 0; a<9; a++) {
				if(arr[a] == 0) {
					sign = false;
					break;
				}
			}
			
		}
		
		//열체
		for(int i = 0; i < 9; i ++ ) {
			int[] arr = new int[9];
			for(int j = 0; j<9; j++) {
				arr[map[j][i] -1 ] ++;
			}
			for(int a = 0; a<9; a++) {
				if(arr[a] == 0) {
					sign = false;
					break;
				}
		}
		
		
				
		}
		// 3 * 3단위 체크 
		for(int i = 0; i<=6; i+=3) {
			for(int j = 0; j<=6; j+=3) {
				int arr[] = new int[9];
				int r = i + 3;
				int c = j + 3;
				
				for(int a = i;a<r;a++) {
					for(int b = j; b<c;b++) {
						arr[(map[a][b]-1)]++;
						
					}
				}
				for(int z = 0; z < 9; z++) {
					if(arr[z] == 0 ) {
						sign = false;
						break;
					}
				}
			}
		}
			
		
		if(sign == true) {
			System.out.printf("#%d %d\n",t + 1,1);
		}else {
			System.out.printf("#%d %d\n",t+1,0);
		}
			
			
			
			
		}}}


