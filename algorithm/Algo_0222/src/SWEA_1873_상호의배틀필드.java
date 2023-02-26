import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	static char[][] map;
	static int tank[][] = new int[1][2];
	// 상하좌우가 존재하니 델타 만들기
	static char temp;
	static int H, W;
	static int userLangth;
	static int d;
	static int tank_i, tank_j;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String A = br.readLine();
				//map[i] = br.readLine().toCharArray(); 한번에 입력도 가능 
				for (int j = 0; j < W; j++) {
					temp = A.charAt(j);
					if (temp == '<' || temp == '^' || temp == 'v' || temp == '>') {
						tank_i = i;
						tank_j = j;
						if (temp == '<') {
							d = 3;
						} else if (temp == '^') {
							d = 1;
						} else if (temp == 'v') {
							d = 2;
						} else
							d = 4;
					}
					map[i][j] = temp;
				}
			} // end for

			//print();
			userLangth = Integer.parseInt(br.readLine());
			String userinput = br.readLine();
			for (int i = 0; i < userLangth; i++) {
				userKey(userinput.charAt(i));
			}
			System.out.print("#" + tc + " " );
			print();
		} // tc

	}// main

	static void userKey(char a) {
		int shoot = 0;
		// 키에 맞는 행위 진행

		if (a == 'U') {
			// 전차가 바라보고 있는 방향을 위로 바꾸고 , 한 칸위의 칸이 평지면 위칸으로 이동
			d = 1;
			map[tank_i][tank_j] = '^';
			if ( tank_i >0 && map[tank_i - 1][tank_j] == '.') {

				map[tank_i - 1][tank_j] = map[tank_i][tank_j];
				map[tank_i][tank_j] = '.';
				tank_i = tank_i - 1;
			}

		} else if (a == 'D') {
			// 전차가 바라보고 있는 방향 아래 바꾸고, 한칸 아래의 칸이 평지면 아래로 이동
			map[tank_i][tank_j] = 'v';
			d = 2;
			if (tank_i < H-1 && map[tank_i + 1][tank_j] == '.') {

				map[tank_i + 1][tank_j] = map[tank_i][tank_j];
				map[tank_i][tank_j] = '.';
				tank_i = tank_i + 1;
			}

		} else if (a == 'L') {
			map[tank_i][tank_j] = '<';
			d = 3;
			if ( tank_j >0 && map[tank_i ][tank_j-1] == '.') {

				map[tank_i][tank_j -1] = map[tank_i][tank_j];
				map[tank_i][tank_j] = '.';
				tank_j = tank_j - 1;
			}

		} else if (a == 'R') {
			map[tank_i][tank_j] = '>';
			d = 4;
			if ( tank_j < W-1 && map[tank_i ][tank_j+1] == '.') {

				map[tank_i][tank_j +1] = map[tank_i][tank_j];
				map[tank_i][tank_j] = '.';
				tank_j = tank_j + 1;
			}

		} else if (a == 'S') {
			// 바라보고 있는 방향으로 포탄 발사
			// *(벽돌이면 부숴버림) -> .
			// #이면 안부숴짐
			switch (d) {
			case 1: // 위방향
				shoot = tank_i;
				while (true) {
					if (shoot - 1 < 0 || map[shoot - 1][tank_j] == '#')
						break;
					if (map[shoot - 1][tank_j] == '*') {
						map[shoot - 1][tank_j] = '.';
						break;
					}
					shoot--;
				}

				break;
			case 2:
				shoot = tank_i;
				while (true) {
					if (shoot + 1 >= H || map[shoot + 1][tank_j] == '#')
						break;
					if (map[shoot + 1][tank_j] == '*') {
						map[shoot + 1][tank_j] = '.';
						break;
					}
					shoot++;
				}
				break;
			case 3:
				shoot = tank_j;
				while (true) {
					if (shoot - 1 < 0 || map[tank_i][shoot - 1] == '#')
						break;
					if (map[tank_i][shoot - 1] == '*') {
						map[tank_i][shoot - 1] = '.';
						break;
					}
					shoot--;
				}
				break;
			case 4:
				shoot = tank_j;
				while (true) {
					if (shoot + 1 >= W || map[tank_i][shoot + 1] == '#')
						break;
					if (map[tank_i][shoot + 1] == '*') {
						map[tank_i][shoot + 1] = '.';
						break;
					}
					shoot++;
				}
				break;

			}
		}
	

	}// userKey

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] );
			}
			System.out.println();
		}
		//System.out.println("------------------------");
	}
}
