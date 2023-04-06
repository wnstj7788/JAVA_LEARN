import java.util.ArrayList;
import java.util.Scanner;

public class Main_BOJ_15660_테트로미노2 {

	static int N, M;
	static int[][] map;
	static int cnt;
	
	static int[] tt={2,1,8,4,4};
	static int[][] ar={{0,0,0,0},{0,1,2,3}};
	static int[][] ac={{0,1,2,3},{0,0,0,0}};
	static int[][] br={{0,0,1,1}};
	static int[][] bc={{0,1,0,1}};
	static int[][] cr={{0,0,0,-1},{0,0,0,1},{0,-1,0,0},{0,1,0,0},
			           {0,1,2,2},{0,1,2,2},{0,0,1,2},{0,0,1,2}};
	static int[][] cc={{0,1,2,2},{0,1,2,2},{0,0,1,2},{0,0,1,2},
			           {0,0,0,-1},{0,0,0,1},{0,-1,0,0},{0,1,0,0}};
	static int[][] dr={{0,0,1,1},{0,0,-1,-1},{0,1,1,2},{0,1,1,2}};
	static int[][] dc={{0,1,1,2},{0,1,1,2},{0,0,1,1},{0,0,-1,-1}};
	static int[][] er={{0,0,0,1},{0,0,0,-1},{0,1,2,1},{0,1,2,1}};
	static int[][] ec={{0,1,2,1},{0,1,2,1},{0,0,0,1},{0,0,0,-1}};
	
	static int[][][] zr={ar,br,cr,dr,er};
	static int[][][] zc={ac,bc,cc,dc,ec};
	static ArrayList<ArrayList<int[]>> points=new ArrayList<>();
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		cnt=go();
		cnt+=go2();
		System.out.println(cnt);
	}
	
	private static int go() {
		int max=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int p = 0; p < tt.length; p++) {
					for (int k = 0; k < tt[p]; k++) {
						int sum=0;
						for (int d = 0; d < 4; d++) {
							int nr=i+zr[p][k][d];
							int nc=j+zc[p][k][d];
							if(!check(nr, nc)){ continue;}
							sum+=map[nr][nc];	
						}
						max=Math.max(max, sum);
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int p = 0; p < tt.length; p++) {
					for (int k = 0; k < tt[p]; k++) {
						int sum=0;
						ArrayList<int[]> list=new ArrayList<>();
						for (int d = 0; d < 4; d++) {
							int nr=i+zr[p][k][d];
							int nc=j+zc[p][k][d];
							if(!check(nr, nc))continue;
							list.add(new int[]{nr,nc});
							sum+=map[nr][nc];	
						}
						if(max!=sum) continue;
						if(max==sum){
							points.add(list);							
						}
					}
				}
			}
		}
/*		for (int i = 0; i < points.size(); i++) {
			ArrayList<int[]> list2=points.get(i);
			for (int j = 0; j <list2.size(); j++) {
				System.out.print(Arrays.toString(list2.get(j)));
			}
			System.out.println();
		}*/
		return max;
	}
	private static int go2() {
		int max=0;
		for (int ii = 0; ii < points.size(); ii++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int p = 0; p < tt.length; p++) {
						for (int k = 0; k < tt[p]; k++) {
							int sum=0;
							aa:for (int d = 0; d < 4; d++) {
								int nr=i+zr[p][k][d];
								int nc=j+zc[p][k][d];
								if(!check(nr, nc)){ continue;}
								ArrayList<int[]> list2=points.get(0);
								for (int jj = 0; jj <list2.size(); jj++) {
									int[] newA=list2.get(jj);
									// 한점이라도 이미 간곳이라면 
									if(newA[0]==nr && newA[1]==nc){
										break aa;
									}
								}
								sum+=map[nr][nc];	
							}
							max=Math.max(max, sum);
						}
					}
				}
			}//
		}
		return max;
	}
	public static boolean check(int r, int c){
		return r>=0 && r<N && c>=0 && c<M;
	}
}
