import java.util.Iterator;
import java.util.Scanner;

public class BOJ_2567_색종이2 {
	static int map[][] = new int[102][102];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int i = 0; i < TC; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int X = x; X < x + 10; X++) {
				for(int Y = y; Y < y + 10; Y ++) {
					map[X][Y] = 1;
				}
			} //for end 
		}//input end
		//print();
		
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1) {
					for (int d = 0; d < dx.length; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						
						if(nx >= 1 && nx <= 100 && ny >= 1 && ny <= 100) {
							if(map[nx][ny] == 0) 
								cnt ++;
							
						}
						else if(nx<1 || nx>100 || ny<1 || ny>100)
							cnt++;	
						
					}
				}
			}
		}
		
		
		System.out.println(cnt);
		
	}
	
	
	
	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}

}
